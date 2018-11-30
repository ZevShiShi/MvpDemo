package zhu.zev.com.demo.base;

/**
 * Created by zev on 2018/11/29.
 */

public class BasePresenter<V extends BaseView,M extends BaseModel> {

    protected V mView;
    protected M mModel;


    /**
     * 绑定view，一般在初始化中调用该方法
     *
     * @param view view
     */
    public void attachView(V view) {
        this.mView = view;
    }

    public void attachModel(M model) {
        this.mModel = model;
    }

    /**
     * 解除绑定view，一般在onDestroy中调用
     */
    public void detachView() {
        this.mView = null;
    }

    public void detachModel() {
        this.mModel = null;
    }

    /**
     * View是否绑定
     *
     * @return
     */
    public boolean isViewAttachView() {
        return mView != null;
    }


}
