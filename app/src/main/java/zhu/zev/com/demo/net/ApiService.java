package zhu.zev.com.demo.net;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import zhu.zev.com.demo.bean.BaseBean;
import zhu.zev.com.demo.bean.LoginBean;

/**
 * Created by zev on 2018/11/29.
 */

public interface ApiService {


    @FormUrlEncoded
    @POST("user/login")
    Observable<BaseBean<LoginBean>> login(@Field("username")String username
            , @Field("password")String pwd);
}
