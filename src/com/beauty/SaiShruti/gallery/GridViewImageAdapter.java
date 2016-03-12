package com.beauty.SaiShruti.gallery;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import com.beauty.SaiShruti.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by user on 05/02/16.
 */
public class GridViewImageAdapter extends BaseAdapter {

    private Activity _activity;
    private ArrayList<String> _filePaths = new ArrayList<String>();
    private int imageWidth;
    private String folderToLook;

    public GridViewImageAdapter(Activity activity, ArrayList<String> filePaths, int imageWidth, String folderToLook) {
        this._activity = activity;
        this._filePaths = filePaths;
        this.imageWidth = imageWidth;
        this.folderToLook = folderToLook;
    }

    @Override
    public int getCount() {
        return this._filePaths.size();
    }

    @Override
    public Object getItem(int position) {
        return this._filePaths.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(_activity);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(imageWidth, imageWidth));
        try{
        Picasso.with(this._activity)
                .load("file:///android_asset/"+folderToLook+"/"+_filePaths.get(position))
                .into(imageView);
        }catch(Exception e){
            Toast.makeText(_activity.getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
        // image view click listener
        imageView.setOnClickListener(new OnImageClickListener(position));


        return imageView;
    }

    class OnImageClickListener implements View.OnClickListener {
        int _postion;

        // constructor
        public OnImageClickListener(int position) {
            this._postion = position;
        }

        @Override
        public void onClick(View v) {
            // on selecting grid view image
            // launch full screen activity
            Intent i = new Intent(_activity, FullScreenViewActivity.class);
            i.putExtra("position", _postion);
            i.putExtra("folderName", folderToLook);
            _activity.startActivity(i);
        }

    }
}