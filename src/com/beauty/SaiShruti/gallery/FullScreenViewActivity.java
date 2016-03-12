package com.beauty.SaiShruti.gallery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.beauty.SaiShruti.R;

/**
 * Created by user on 05/02/16.
 */
public class FullScreenViewActivity extends Activity {

    private GalleryUtils utils;
    private FullScreenImageAdapter adapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        viewPager = (ViewPager) findViewById(R.id.pager);

        utils = new GalleryUtils(getApplicationContext());

        Intent i = getIntent();
        int position = i.getIntExtra("position", 0);
        String folderName = i.getStringExtra("folderName");

        adapter = new FullScreenImageAdapter(FullScreenViewActivity.this, utils.getFilePaths(folderName), folderName);

        viewPager.setAdapter(adapter);

        // displaying selected image first
        viewPager.setCurrentItem(position);
    }
}