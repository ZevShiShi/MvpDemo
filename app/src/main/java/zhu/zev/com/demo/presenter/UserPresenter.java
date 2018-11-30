package zhu.zev.com.demo.presenter;

import javax.inject.Inject;

import zhu.zev.com.demo.base.BasePresenter;
import zhu.zev.com.demo.bean.BaseBean;
import zhu.zev.com.demo.bean.LoginBean;
import zhu.zev.com.demo.contract.UserContract;
import zhu.zev.com.demo.net.ResultObserver;
import zhu.zev.com.demo.net.RxScheduler;

/**
 * Created by zev on 2018/11/29.
 */

public class UserPresenter extends BasePresenter<UserContract.View,UserContract.Model>
        implements UserContract.Presenter {


    @Inject
    public UserPresenter(UserContract.Model model, UserContract.View view) {
        this.mModel = model;
        this.mView = view;
    }

    @Override
    public void login(String username, String pwd) {
        mModel.login(username, pwd)
                .doOnSubscribe(disposable -> mView.showLoading())
                .doOnTerminate(() -> mView.hideLoading())
                .compose(RxScheduler.obsToMain())
                .as(mView.bindAutoDispose())
                .subscribe(new ResultObserver<BaseBean<LoginBean>>(){
                    @Override
                    public void onNext(BaseBean<LoginBean> bean) {
                        if (bean != null) {
                            mView.onSuccess(bean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onError(e);
                    }
                });



    }
}
