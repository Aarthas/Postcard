package promiserpkg;

import java.util.Timer;
import java.util.TimerTask;

public class main {

	public static void main(String[] args) {
		
		Promiser<String, Integer> req = new Promiser<String, Integer>(new PromiseInitializer<String, Integer>() {
			@Override
			public void run(Resolver<String> resolve, Rejecter<Integer> reject) {
				System.out.println("BEGIN1");

				// Place your asynchronous process here, and make sure to trigger resolve.run() or reject.run() when needed.

				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						// resolving
						System.out.println("END");
						resolve.run("aa");
					}
				}, 1000);

			}
		});
				
//		req.then((String res) -> {
//			// Handle then here
//			System.out.println("then");
//			System.out.println(res);
//
//		}).catcha((Integer err) -> {
//			System.out.println("catcha");
//			// Handle failure here
//			System.out.println(err);
//		});

		req.then(new Resolver<String>() {
			@Override
			public Promiser run(String res) {
				// Handle then here
				return new Promiser<String, Integer>(new PromiseInitializer<String, Integer>() {
					@Override
					public void run(Resolver<String> resolve, Rejecter<Integer> reject) {
						System.out.println("BEGIN2");

						// Place your asynchronous process here, and make sure to trigger resolve.run() or reject.run() when needed.

						resolve.run("aaa");


					}
				});

			}
		}).	then(new Resolver<String>() {
			@Override
			public Promiser run(String res) {
				System.out.println("BEGIN3");
				return null;
			}
		})

				.catcha((Integer err) -> {
			System.out.println("catcha");
			// Handle failure here
			System.out.println(err);
		});




	}	

}


