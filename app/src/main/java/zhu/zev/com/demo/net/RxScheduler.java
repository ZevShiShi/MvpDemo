package zhu.zev.com.demo.net;

import io.reactivex.FlowableTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import zhu.zev.com.demo.base.BaseView;

/**
 * Created by zev on 2018/11/29.
 */

public class RxScheduler {
    /**
     * 统一线程处理
     *
     * @param <T> 指定的泛型类型
     * @return FlowableTransformer
     */
    public static <T> FlowableTransformer<T, T> flowToMain() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 统一线程处理
     *
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
     */
    public static <T> ObservableTransformer<T, T> obsToMain() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public static Consumer<BaseView> getShowLoadingAction() {
        return BaseView::showLoading;
    }

    public static Consumer<BaseView> getHideLoadingAction() {
        return BaseView::hideLoading;
    }


}
