package materialdemo.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by mac on 2018/7/26.
 * <p>
 * <p>
 * 对于toolbar的简单封装
 * <p>
 * 由于collaspetoolbarlayout必须要toolbar或者直接子view,故继承与toolbar
 * addExtraChildView()对于任何子view的添加
 */

public class YJToolBar extends Toolbar implements View.OnClickListener {

    private TextView tx_title;
    private TextView tx_back;

    Context context;

    RelativeLayout toolbar;


    public YJToolBar(@NonNull Context context) {
        super(context);
        init(context);
    }

    public YJToolBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public YJToolBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.toolbar_layout, this);
        tx_title = findViewById(R.id.toolbar_title);
        toolbar = findViewById(R.id.toolbar);
        tx_back = findViewById(R.id.back);
        tx_back.setOnClickListener(this);
    }


    public YJToolBar addExtraChildView(View view) {

        toolbar.addView(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
        params.addRule(RelativeLayout.CENTER_VERTICAL);
        view.setLayoutParams(params);
        return this;
    }

    public void setGravityTitle(String title) {
        tx_title.setText(title);
    }

    public YJToolBar appearBackIcon() {

        tx_back.setVisibility(VISIBLE);

        return this;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.back:
                if (context instanceof Activity) {


                    if (!((Activity) context).isFinishing())
                        ((Activity) context).finish();
                }
                break;

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            findViewById(R.id.back).performClick();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
