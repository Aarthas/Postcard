package promiserpkg.b;

@FunctionalInterface
public interface Rejecter<U> {
	public void run(U u);
}