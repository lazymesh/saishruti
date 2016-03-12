package com.beauty.SaiShruti.gallery;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.GridView;
import com.beauty.SaiShruti.R;

import java.util.ArrayList;

/**
 * Created by user on 05/02/16.
 */
public class GalleryViewActivity extends Activity {

    private GalleryUtils utils;
    private ArrayList<String> imagePaths = new ArrayList<String>();
    private GridViewImageAdapter adapter;
    private GridView gridView;
    private int columnWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_grid_view);

        gridView = (GridView) findViewById(R.id.grid_view);

        utils = new GalleryUtils(this);

        // Initilizing Grid View
        InitilizeGridLayout();
        String folderToLook = getIntent().getStringExtra("folderName");

        // loading all image paths from SD card
        imagePaths = utils.getFilePaths(folderToLook);

        // Gridview adapter
        adapter = new GridViewImageAdapter(GalleryViewActivity.this, imagePaths, columnWidth, folderToLook);

        // setting grid view adapter
        gridView.setAdapter(adapter);
    }

    private void InitilizeGridLayout() {
        Resources r = getResources();
        float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, GalleryConstants.GRID_PADDING, r.getDisplayMetrics());

        columnWidth = (int) ((utils.getScreenWidth() - ((GalleryConstants.NUM_OF_COLUMNS + 1) * padding)) / GalleryConstants.NUM_OF_COLUMNS);

        gridView.setNumColumns(GalleryConstants.NUM_OF_COLUMNS);
        gridView.setColumnWidth(columnWidth);
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setPadding((int) padding, (int) padding, (int) padding,
                (int) padding);
        gridView.setHorizontalSpacing((int) padding);
        gridView.setVerticalSpacing((int) padding);
    }

}