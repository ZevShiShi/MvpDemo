package zhu.zev.com.demo.contract;

import io.reactivex.Observable;
import zhu.zev.com.demo.base.BaseModel;
import zhu.zev.com.demo.base.BaseView;
import zhu.zev.com.demo.bean.BaseBean;
import zhu.zev.com.demo.bean.LoginBean;

/**
 * Created by zev on 2018/11/29.
 */

public interface UserContract {
    interface Model extends BaseModel {
        Observable<BaseBean<LoginBean>> login(String username, String password);
    }

    interface View extends BaseView {
        void onSuccess(BaseBean<LoginBean> bean);
    }

    interface Presenter {
        void login(String username, String pwd);
    }
}
