package promiserpkg;

import promiserpkg.a.*;
import promiserpkg.a.InterceptorCallback;

public class main {

    public static void main(String[] args) {


//		_Postcard.build(null)
//				.withFilter(new IInterceptor() {
//					@Override
//					public void process(Postcard postcard, InterceptorCallback callback) {
//						System.out.println("111");
//						callback.onContinue(postcard.withData("a111"));
//					}
//				})
//				.withFilter(new IInterceptor() {
//					@Override
//					public void process(Postcard postcard, InterceptorCallback callback) {
//						System.out.println("222");
//						callback.onContinue(postcard.withData("a222"));
//					}
//				})
//				.send(new Action() {
//			@Override
//			public void process(Postcard postcard) {
//				String data = postcard.getData();
//				System.out.println(data);
//			}
//		});


        Postcard.build()
                .withFilter(new IInterceptor() {
                    @Override
                    public void process(Postcard postcard, InterceptorCallback callback) {
                        System.out.println("111");
                        callback.onContinue(postcard.withData("a111"));
                    }
                })
                .withFilter(new IInterceptor() {
                    @Override
                    public void process(Postcard postcard, InterceptorCallback callback) {
                        System.out.println("22");
//						callback.onContinue(postcard.withData("a111"));
                        callback.onContinue(postcard.withData("a111"));
                    }
                })

                .send(new Action() {
                    @Override
                    public void process(Postcard postcard) {
                        System.out.println("333");
                    }
                });

        Postcard postcard = Postcard.build().

                withContext(new Context())
                .withData(new Apple())
                .withFilter(new IInterceptor() {
                    @Override
                    public void process(Postcard postcard, InterceptorCallback callback) {
                        System.out.println("111");
                        callback.onContinue(postcard);
                    }
                });
        postcard.send(new Action() {
            @Override
            public void process(Postcard postcard) {
                System.out.println("process 1");
                Apple data = postcard.getData();
                System.out.println(data);
                postcard.send();
            }
        });

//
//		Promiser<String> req = new Promiser<String>();
//
//		req.then(new Resolver<String>() {
//			@Override
//			public void run(String s) {
//				System.out.println("2");
//
//			}
//		}).then(new Resolver<String>() {
//			@Override
//			public void run(String s) {
//				System.out.println("2");
//
//			}
//		});

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

//		req.then(new Resolver<String>() {
//			@Override
//			public Promiser run(String res) {
//				// Handle then here
//				return new Promiser<String, Integer>(new PromiseInitializer<String, Integer>() {
//					@Override
//					public void run(Resolver<String> resolve, Rejecter<Integer> reject) {
//						System.out.println("BEGIN2");
//
//						// Place your asynchronous process here, and make sure to trigger resolve.run() or reject.run() when needed.
//
//						resolve.run("aaa");
//
//
//					}
//				});
//
//			}
//		}).	then(new Resolver<String>() {
//			@Override
//			public Promiser run(String res) {
//				System.out.println("BEGIN3");
//				return null;
//			}
//		})
//
//				.catcha((Integer err) -> {
//			System.out.println("catcha");
//			// Handle failure here
//			System.out.println(err);
//		});
//


    }

}


