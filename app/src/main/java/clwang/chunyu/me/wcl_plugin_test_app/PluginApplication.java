package clwang.chunyu.me.wcl_plugin_test_app;

import android.app.Application;
import android.util.Log;

/**
 * 插件的应用. [测试无法启动]
 * <p>
 * Created by wangchenlong on 16/1/15.
 */
public class PluginApplication extends Application {

    private static final String TAG = "DEBUG-WCL: " + PluginApplication.class.getSimpleName();

    @Override public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "onTerminate");
    }
}
