package promiserpkg;

@FunctionalInterface
public interface PromiseInitializer<T> {
	Promiser process( InterceptorCallback<T> callback);
}
