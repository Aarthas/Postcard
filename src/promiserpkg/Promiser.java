package promiserpkg;

public class Promiser<T> {



//    public PromiseInitializer<T> _init;
//
//    T resolveResult;
//    Throwable rejectError;
//
//    public Promiser(PromiseInitializer<T> init) {
//        this._init = init;
//
//    }
//
//    public Promiser() {
//
//
//    }
//
//
//    public Resolver<T> resolve = new Resolver<T>() {
//        @Override
//        public Promiser run(T res) {
////			state = PromiseState.FULFILLED;
//            resolveResult = res;
//            Promiser.this.next();
//            return null;
//        }
//    };
//
//    public Rejecter<Exception> reject = (Exception err) -> {
////		state = PromiseState.REJECTED;
//        rejectError = err;
//        next();
//    };
//
//    private void next() {
////		if(state == PromiseState.FULFILLED && this._success != null) {
////			this._success.run(resolveResult);
////
////		} else if(state == PromiseState.REJECTED && this._error != null) {
////			this._error.run(rejectError);
////
////		} else {
////
////		}
//    }
//
//
//    public Promiser<T> then(Resolver<T> pSuccess) {
//
//        Promiser run = pSuccess.run();
//        Promiser process = _init.process(new InterceptorCallback<T>() {
//
//            @Override
//            public void onContinue(T postcard) {
//                pSuccess.run(postcard);
//
//            }
//
//            @Override
//            public void onInterrupt(Throwable exception) {
//
//            }
//        });
//
//        return process;
//
//    }
//
////	public Promiser<V, Exception> then(thenFunc<V> pThen) {
////		PromiseInitializer<T, Exception> c = (Resolver<V> resolve, Rejecter<Exception> reject) -> {
////			try {
////				resolve.run(pThen.run(resolveResult));
////			} catch  (Exception e) {
////				reject.run(e);
////			}
////		};
////		Promiser<v, Exception> p = new Promiser<T, Exception>(c);
////		return p;
////	}
//
//
//    public Promiser<T> catcha(Rejecter<Throwable> pError) {
//        this._error = pError;
//
//        this._error.run(rejectError);
//
//        return this;
//    }


}
