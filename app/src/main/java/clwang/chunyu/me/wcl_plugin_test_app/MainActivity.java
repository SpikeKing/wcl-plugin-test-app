package clwang.chunyu.me.wcl_plugin_test_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import clwang.chunyu.me.wcl_plugin_test_app.utils.PluginConsts;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DEBUG-WCL: " + MainActivity.class.getSimpleName();

    @Bind(R.id.main_b_goto_master) Button mBGotoMaster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        if (intent != null && intent.getStringExtra(PluginConsts.PLUGIN_EXTRA_STRING) != null) {
            String words = "say: " + intent.getStringExtra(PluginConsts.PLUGIN_EXTRA_STRING);
            Toast.makeText(this, words, Toast.LENGTH_SHORT).show();
        }

        mBGotoMaster.setOnClickListener(this::gotoMaster);

        Log.d(TAG, "onCreate"); // 测试生命周期
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy"); // 测试生命周期
    }

    // 跳转控件
    private void gotoMaster(View view) {
        if (isActionAvailable(view.getContext(), PluginConsts.MASTER_ACTION_MAIN)) {
            Intent intent = new Intent(PluginConsts.MASTER_ACTION_MAIN);
            intent.putExtra(PluginConsts.MASTER_EXTRA_STRING, "Hello, My Master!");
            startActivity(intent);
        } else {
            Toast.makeText(view.getContext(), "跳转失败", Toast.LENGTH_SHORT).show();
        }
    }

    // Action是否允许
    public static boolean isActionAvailable(Context context, String action) {
        Intent intent = new Intent(action);
        return context.getPackageManager().resolveActivity(intent, 0) != null;
    }
}
