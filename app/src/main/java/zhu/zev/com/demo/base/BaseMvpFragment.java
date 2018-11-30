package zhu.zev.com.demo.base;

/**
 * Created by zev on 2018/11/29.
 */

public abstract class BaseMvpFragment<T extends BasePresenter>
        extends BaseFragment implements BaseView {

    protected T mPresenter;

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }
}
