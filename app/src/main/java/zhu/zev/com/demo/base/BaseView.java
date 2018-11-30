package zhu.zev.com.demo.base;

import com.uber.autodispose.AutoDisposeConverter;

/**
 * Created by zev on 2018/11/29.
 */

public interface BaseView {

    void showLoading();

    void hideLoading();

    void onError(Throwable throwable);

    /**
     * 绑定Android生命周期 防止RxJava内存泄漏
     *
     * @param <T>
     * @return
     */
    <T> AutoDisposeConverter<T> bindAutoDispose();
}
