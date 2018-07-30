package materialdemo.myapplication;

import android.os.Build;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    CollapsingToolbarLayout collapsingToolbarLayout;

    AppBarLayout appbar;




    private YJToolBar community_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        community_toolbar = findViewById(R.id.community_toolbar);


        appbar = (AppBarLayout) findViewById(R.id.app_bar);
        setCommonUI();
        View right_view=View.inflate(this,R.layout.community_toolbar_extra_view,null);
        community_toolbar.addExtraChildView(right_view);




        LinearLayout ll = (LinearLayout) findViewById(R.id.linear);

        for (int i = 0; i < 30; i++) {
            TextView tv = new TextView(this);
            tv.setText("" + i);
            tv.setTextSize(40);
            ll.addView(tv);
        }

    }

    public void setCommonUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }


}
