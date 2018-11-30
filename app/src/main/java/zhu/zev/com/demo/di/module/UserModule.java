package zhu.zev.com.demo.di.module;

import dagger.Module;
import dagger.Provides;
import zhu.zev.com.demo.contract.UserContract;
import zhu.zev.com.demo.model.UserModel;
import zhu.zev.com.demo.presenter.UserPresenter;

/**
 * 1、首先创建@Module注解类，传入View，生成构造，
 * 2、@Provides需要依赖注入的对象
 *
 * Created by zev on 2018/11/30.
 */
@Module
public class UserModule {

    UserContract.View mView;

    public UserModule(UserContract.View view) {
        this.mView = view;
    }

    @Provides
    UserPresenter getUserPresenter() {
        return new UserPresenter(getUserModel(), getView());
    }

    UserModel getUserModel() {
        return new UserModel();
    }

    UserContract.View getView() {
        return mView;
    }

}
