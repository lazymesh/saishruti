package com.beauty.SaiShruti.beautyTips;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.beauty.SaiShruti.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by user on 20/02/2016.
 */
public class BeautyTipsActivity  extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beauty_tips_selected);
        TextView tips = (TextView)findViewById(R.id.tipsDisplay);
        String fileName = getIntent().getExtras().getString("fileName");
        try {
            tips.setText(readBeautyTipsFile(fileName));
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Not implemented yet!!!!! \n Coming SOON", Toast.LENGTH_LONG).show();
        }

        TextView openFacebook =(TextView)findViewById(R.id.tipsContact);
        openFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(getOpenFacebookIntent(getApplicationContext()));
            }
        });

        Button closeBtn = (Button)findViewById(R.id.tipsClose);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public StringBuilder readBeautyTipsFile(String fileName) throws IOException {
        String str="";
        StringBuilder builder = new StringBuilder();
        AssetManager am = getAssets();
        InputStream is = am.open("Tips/"+fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if (is!=null) {
            while ((str = reader.readLine()) != null) {
                builder.append(str + "\n" );
            }
        }
        is.close();
        return builder;
    }

    private Intent getOpenFacebookIntent(Context context) {
        String url ="https://www.facebook.com/sai.shruti.50";
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href=" + url));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        }
    }
}
