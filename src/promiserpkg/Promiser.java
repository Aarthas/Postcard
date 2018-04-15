package promiserpkg;

public class Promiser<T, U> {

    public PromiseState state;
    private Resolver<T> _success = null;
    private Rejecter<U> _error = null;
    public PromiseInitializer<T, U> _init;

    T resolveResult;
    U rejectError;

    public Promiser(PromiseInitializer<T, U> init) {
        this._init = init;
//		state = PromiseState.PENDING;
        this.go();
    }

    public Resolver<T> resolve = new Resolver<T>() {
        @Override
        public Promiser run(T res) {
//			state = PromiseState.FULFILLED;
            resolveResult = res;
            Promiser.this.next();
            return null;
        }
    };

    public Rejecter<U> reject = (U err) -> {
//		state = PromiseState.REJECTED;
        rejectError = err;
        next();
    };

    private void next() {
//		if(state == PromiseState.FULFILLED && this._success != null) {
//			this._success.run(resolveResult);
//
//		} else if(state == PromiseState.REJECTED && this._error != null) {
//			this._error.run(rejectError);
//
//		} else {
//
//		}
    }


    public Promiser<T, U> then(Resolver<T> pSuccess) {
        this._success = pSuccess;

        Promiser run = this._success.run(resolveResult);
        if (run == null) {
            return this;
        }
        return run;


    }

//	public Promiser<V, Exception> then(thenFunc<V> pThen) {
//		PromiseInitializer<T, Exception> c = (Resolver<V> resolve, Rejecter<Exception> reject) -> {
//			try {
//				resolve.run(pThen.run(resolveResult));
//			} catch  (Exception e) {
//				reject.run(e);
//			}
//		}; 
//		Promiser<v, Exception> p = new Promiser<T, Exception>(c);
//		return p;
//	}


    public Promiser<T, U> catcha(Rejecter<U> pError) {
        this._error = pError;

        this._error.run(rejectError);

        return this;
    }

    public Promiser<T, U> go() {
        _init.run(this.resolve, this.reject);
        return this;
    }
}
