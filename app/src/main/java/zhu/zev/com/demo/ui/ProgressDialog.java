package zhu.zev.com.demo.ui;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;

import zhu.zev.com.demo.R;

/**
 * Created by zev on 2018/11/30.
 */

public class ProgressDialog {

    private ProgressDialog() {
    }

    private  static  class ProgressDialogInner{
        private static ProgressDialog Instance = new ProgressDialog();
    }

    public static ProgressDialog getInstance() {
        return ProgressDialogInner.Instance;
    }

    private MaterialDialog mDialog;

    public void show(Context ctx) {
        mDialog = new MaterialDialog.Builder(ctx)
                .content(R.string.please_wait)
                .progress(true, 0)
                .cancelable(false)
                .progressIndeterminateStyle(false)
                .show();
    }

    public void dissmiss() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

}
