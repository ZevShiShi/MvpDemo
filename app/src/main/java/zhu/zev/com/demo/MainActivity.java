package zhu.zev.com.demo;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import zhu.zev.com.demo.base.BaseMvpActivity;
import zhu.zev.com.demo.bean.BaseBean;
import zhu.zev.com.demo.bean.LoginBean;
import zhu.zev.com.demo.contract.UserContract;
import zhu.zev.com.demo.di.component.DaggerUserComponent;
import zhu.zev.com.demo.di.module.UserModule;
import zhu.zev.com.demo.presenter.UserPresenter;
import zhu.zev.com.demo.ui.ProgressDialog;

public class MainActivity extends BaseMvpActivity<UserPresenter> implements UserContract.View {


    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.etPwd)
    EditText etPwd;

    private static final String TAG = "MainActivity";

    @Override
    protected void initView() {
        // 未使用Dagger2的方法
//        mPresenter = new UserPresenter();
//        mPresenter.attachView(this);   // 绑定view
//        mPresenter.attachModel(new UserModel()); //  绑定model

        // 已经使用Dagger2的方法
        DaggerUserComponent.builder()
                .userModule(new UserModule(this))
                .build().inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showLoading() {
        runOnUiThread(()->{
            ProgressDialog.getInstance().show(this);
        });
    }

    @Override
    public void hideLoading() {
        ProgressDialog.getInstance().dissmiss();
    }

    @Override
    public void onError(Throwable throwable) {
        Log.e(TAG, "onError: "+throwable.toString());
    }


    @Override
    public void onSuccess(BaseBean<LoginBean> bean) {
        Toast.makeText(this, bean.toString(), Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onSuccess: " + bean.toString());
    }

    @OnClick(R.id.btnLogin)
    public void onLoginClick(View view) {
        String username = etUsername.getText().toString();
        String pwd = etPwd.getText().toString();
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(pwd)) {
            mPresenter.login(username, pwd);
        }
    }
}
