package zhu.zev.com.demo.model;

import io.reactivex.Observable;
import zhu.zev.com.demo.bean.BaseBean;
import zhu.zev.com.demo.bean.LoginBean;
import zhu.zev.com.demo.contract.UserContract;
import zhu.zev.com.demo.net.RetrofitClient;

/**
 * Created by zev on 2018/11/29.
 */

public class UserModel implements UserContract.Model {

    @Override
    public Observable<BaseBean<LoginBean>> login(String username, String password) {
        return RetrofitClient.getInstance().getApi().login(username,password);
    }
}
