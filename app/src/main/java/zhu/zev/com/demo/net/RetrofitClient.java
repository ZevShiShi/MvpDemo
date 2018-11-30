package zhu.zev.com.demo.net;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zev on 2018/11/29.
 */
public class RetrofitClient {


    private ApiService apiService;
    private static final String BaseUrl = "http://www.wanandroid.com/";

    private RetrofitClient() {
    }

    public static RetrofitClient getInstance() {
        return RetrofitInnerInstance.INSTANCE;
    }

    private static class RetrofitInnerInstance{
        private static RetrofitClient INSTANCE = new RetrofitClient();
    }

    /**
     * 设置Header
     *
     * @return
     */
    private Interceptor getHeaderInterceptor() {
        return chain -> {
            Request request = chain.request();
            Request resultReq = request.newBuilder()
                    .header("token", "")
                    .build();
            return chain.proceed(resultReq);
        };
    }


    /**
     * 设置日志 拦截器
     * @return
     */
    private Interceptor getInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);// 显示日志
        return interceptor;
    }

    public ApiService getApi() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(getHeaderInterceptor())
                .addInterceptor(getInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
        return apiService;
    }



}
