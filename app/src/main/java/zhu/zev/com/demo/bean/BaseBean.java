package zhu.zev.com.demo.bean;

/**
 * Created by zev on 2018/11/29.
 */

public class BaseBean<T> {

    /**
     * status : 1
     * msg : 获取成功
     * result : {} 对象
     */
    private int errorCode;
    private String errorMsg;
    private T result;


    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", result=" + result +
                '}';
    }
}
