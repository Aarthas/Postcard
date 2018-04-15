package promiserpkg.b;

@FunctionalInterface
public interface PromiseInitializer<T> {
	Promiser process( InterceptorCallback<T> callback);
}
