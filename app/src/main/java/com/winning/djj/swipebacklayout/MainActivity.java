package com.winning.djj.swipebacklayout;

import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 描述: 主界面
 *
 * 作者|时间: djj on 2019/2/27 13:56
 * 博客地址: http://www.jianshu.com/u/dfbde65a03fc
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.tv_show)
    TextView mTvShow;

    @Override
    protected int getLayoutId() {
        setSwipeBackEnable(false);
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.tv_show)
    public void onViewClicked() {
        startActivity(Main2Activity.class);
    }
}
