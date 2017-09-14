package com.bwie.webapp;

import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * Created by liqy on 2017/9/13.
 */

public class JSObject {
    @JavascriptInterface
    public String getPwd(String pwd){
        Log.d(getClass().getSimpleName(),"获取密码,"+pwd);
        return pwd;
    }
}
