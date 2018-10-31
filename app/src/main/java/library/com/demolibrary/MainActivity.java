package library.com.demolibrary;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.List;

import library.com.helper.RssFeedProvider;
import library.com.helper.RssItem;


public class MainActivity extends AppCompatActivity
{
    TextView tv_;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19)
        {
            Log.e("TAG","11 - 19");
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        }
        else if(Build.VERSION.SDK_INT >= 19)
        {
            Log.e("TAG",">=19");
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
        setContentView(R.layout.activity_main);

        updateDetail("xyx");
    }

    public void updateDetail(String uri) {  //

        List<RssItem> list = RssFeedProvider.parse(uri);
        String itemListAsString = list.get(1).getLink();
        Log.e("TAG","itemListAsString = "+itemListAsString);

        tv_ = findViewById(R.id.tv_);
        tv_.setOnClickListener(view -> {
            Log.e("TAG","Click");
        });

    }
}
