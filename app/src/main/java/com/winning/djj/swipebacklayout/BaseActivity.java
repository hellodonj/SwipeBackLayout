package com.winning.djj.swipebacklayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import butterknife.ButterKnife;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * 注意：代码千万行，注释第一行； 编码不规范，同事泪两行。
 * 描述: 基类activity
 * 作者|时间: djj on 2019/1/17 13:45
 * 博客地址: http://www.jianshu.com/u/dfbde65a03fc
 */
public abstract class BaseActivity extends SwipeBackActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, String.format("%s:onCreate", this));
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        ButterKnife.bind(this);

        initView();
        initData();
        applyEvent();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, String.format("%s:onStart", this));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, String.format("%s:onRestart", this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, String.format("%s:onResume", this));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, String.format("%s:onPause", this));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, String.format("%s:onStop", this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, String.format("%s:onDestroy", this));
        if (isLoadingEnable() && mProgressDialog != null) {
            mProgressDialog.dismiss();
        }

    }

    /**
     * 返回当前界面布局文件
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化View
     */
    protected void initView() {
    }

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 设置事件监听
     */
    protected void applyEvent() {
    }

    protected boolean isLoadingEnable() {
        return false;
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void startActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void startActivityForResult(Class<?> cls, int requestCode) {
        Intent intent = new Intent(this, cls);
        startActivityForResult(intent, requestCode);
    }

}
