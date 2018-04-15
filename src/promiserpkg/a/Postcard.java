package promiserpkg.a;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A container that contains the roadmap.
 *
 * @author Alex <a href="mailto:zhilong.liu@aliyun.com">Contact me.</a>
 * @version 1.1.0
 * @since 16/8/22 19:16
 */
public final class Postcard  {
    // Base

    private Object tag;             // A tag prepare for some thing wrong.
    private HashMap mBundle;         // Data to transform
    private int flags = -1;         // Flags of route
    private int timeout = 300;      // Navigation timeout, TimeUnit.Second
    private IProvider provider;     // It will be set value, if this postcard was provider.
    private boolean greenChannel;
    Context context;
    private Object data;
    private ILifeCircle iLifeCircle;
    private OnInterrupt onInterrupt;

    public OnInterrupt getOnInterrupt() {
        return onInterrupt;
    }

    public ILifeCircle getiLifeCircle() {
        return iLifeCircle;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    ArrayList<IInterceptor> filters = new ArrayList();

    private int enterAnim = -1;
    private int exitAnim = -1;
    private Action action;



    public int getEnterAnim() {
        return enterAnim;
    }

    public int getExitAnim() {
        return exitAnim;
    }

    public IProvider getProvider() {
        return provider;
    }

    public Postcard setProvider(IProvider provider) {
        this.provider = provider;
        return this;
    }

    public Postcard() {

    }
    public static Postcard build( ) {
        Postcard postcard = new Postcard();
        return postcard;
    }



    public boolean isGreenChannel() {
        return greenChannel;
    }

    public Object getTag() {
        return tag;
    }

    public Postcard setTag(Object tag) {
        this.tag = tag;
        return this;
    }


    public int getTimeout() {
        return timeout;
    }

    /**
     * Set timeout of navigation this time.
     *
     * @param timeout timeout
     * @return this
     */
    public Postcard setTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }


//
//    /**
//     * Navigation to the route with path in postcard.
//     * No param, will be use application context.
//     */
//    public Object navigation() {
//        return navigation(null);
//    }
//
//    /**
//     * Navigation to the route with path in postcard.
//     *
//     * @param context Activity and so on.
//     */
//    public Object navigation(Context context) {
//        return navigation(context, null);
//    }

//    /**
//     * Navigation to the route with path in postcard.
//     *
//     * @param context Activity and so on.
//     */
//    public Object navigation(Context context, NavigationCallback callback) {
//        return ARouter.getInstance().navigation(context, this, -1, callback);
//    }
//
//    /**
//     * Navigation to the route with path in postcard.
//     *
//     * @param mContext    Activity and so on.
//     * @param requestCode startActivityForResult's param
//     */
//    public void navigation(Activity mContext, int requestCode) {
//        navigation(mContext, requestCode, null);
//    }
//
//    /**
//     * Navigation to the route with path in postcard.
//     *
//     * @param mContext    Activity and so on.
//     * @param requestCode startActivityForResult's param
//     */
//    public void navigation(Activity mContext, int requestCode, NavigationCallback callback) {
//        ARouter.getInstance().navigation(mContext, this, requestCode, callback);
//    }

    /**
     * Green channel, it will skip all of interceptors.
     *
     * @return this
     */
    public Postcard greenChannel() {
        this.greenChannel = true;
        return this;
    }

    /**
     * BE ATTENTION TO THIS METHOD WAS <P>SET, NOT ADD!</P>
     */
    public Postcard with(HashMap bundle) {
        if (null != bundle) {
            mBundle = bundle;
        }

        return this;
    }

    public Postcard withFilters(ArrayList<IInterceptor> arrayList) {
        filters.addAll(arrayList);
        return this;
    }

    public void send() {
        MAction.navigate(filters,this,action);

    }

    public void send(Action action) {
        MAction.navigate(filters,this,action);

    }
    public Postcard setAction(Action action) {
        this.action = action;
        return this;
    }

    public Action getAction() {
        return action;
    }

    public Postcard withFilter(IInterceptor iInterceptor) {
        filters.add(iInterceptor);
        return this;
    }

    public Postcard withData(Object data) {
        this.data=data;
        return this;
    }

    public <E> E  getData( ) {
        return (E)data;
    }



    public Postcard withFlags( int flag) {
        this.flags = flag;
        return this;
    }

    public int getFlags() {
        return flags;
    }

//    /**
//     * Set object value, the value will be convert to string by 'Fastjson'
//     *
//     * @param key   a String, or null
//     * @param value a Object, or null
//     * @return current
//     */
//    public Postcard withObject(@Nullable String key, @Nullable Object value) {
//        serializationService = ARouter.getInstance().navigation(SerializationService.class);
//        mBundle.putString(key, serializationService.object2Json(value));
//        return this;
//    }

    // Follow api copy from #{Bundle}



    public Postcard withLifeCicle(ILifeCircle iLifeCircle) {
        this.iLifeCircle=iLifeCircle;
        return this;
    }

    public Postcard withInterrupt(OnInterrupt onInterrupt) {
        this.onInterrupt=onInterrupt;
        return this;
    }
}
