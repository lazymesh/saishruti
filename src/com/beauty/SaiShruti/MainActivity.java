package com.beauty.SaiShruti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.beauty.SaiShruti.tabs.TabMainActivity;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Intent intent = new Intent(this, TabMainActivity.class);
//            intent.putExtra("fragmentNumber",1);
            startActivity(intent);
        }
        return super.onTouchEvent(event);
    }
}
