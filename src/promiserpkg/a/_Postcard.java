package promiserpkg.a;

import java.util.ArrayList;

public class _Postcard {



    public static void navigate(final ArrayList<IInterceptor> interceptors, final Postcard postcard, final Action action) {

        ILifeCircle iLifeCircle = postcard.getiLifeCircle();
        if (iLifeCircle != null)
            iLifeCircle.onStart(postcard);
        InterceptorService interceptorService = new InterceptorService() {
            @Override
            public void doInterceptions(Postcard postcard, InterceptorCallback callback) {
                if (null != interceptors && interceptors.size() > 0) {
                    _excute(interceptors, 0, postcard, callback);

                } else {
                    callback.onContinue(postcard);
                }

            }
        };


        interceptorService.doInterceptions(postcard, new InterceptorCallback() {
            @Override
            public void onContinue(Postcard postcard) {
                MainLooper.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (action != null)
                            action.process(postcard);
                        if (iLifeCircle != null)
                            iLifeCircle.onComplete(postcard);
                    }
                });

            }

            @Override
            public void onInterrupt(Throwable exception) {
                if (postcard.getOnInterrupt() != null)
                    postcard.getOnInterrupt().onInterrupt(exception);
                if (iLifeCircle != null)
                    iLifeCircle.onComplete(postcard);
            }
        });


    }

    private static void _excute(final ArrayList<IInterceptor> interceptors, final int index, final Postcard postcard, final InterceptorCallback callback) {


        if (index < interceptors.size()) {
            IInterceptor iInterceptor = interceptors.get(index);

            try {

                iInterceptor.process(postcard, new InterceptorCallback() {
                    @Override
                    public void onContinue(Postcard postcard) {


                        _excute(interceptors, index + 1, postcard, callback);  // When counter is down, it will be execute continue ,but index bigger than interceptors size, then U know.
                    }

                    @Override
                    public void onInterrupt(Throwable exception) {
                        // Last interceptor excute over with fatal exception.

                        callback.onInterrupt(exception);
                    }
                });
            } catch (Exception e) {
                callback.onInterrupt(e);
            }
        } else {
            callback.onContinue(postcard);
        }

    }


}
