package com.beauty.SaiShruti.beautyTips;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.beauty.SaiShruti.R;

/**
 * Created by user on 15/02/2016.
 */
public class BeautyTipsAdapter extends ArrayAdapter {
    private final Activity context;
    private final String[] title;
    private final String[] subTitle;
    private final Integer[] imageId;

    public BeautyTipsAdapter(Activity context, String[] title, String[] subTitle, Integer[] imageId) {
        super(context, R.layout.beauty_tips_list, title);
        this.context = context;
        this.title = title;
        this.subTitle = subTitle;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.beauty_tips_list, parent, false);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        TextView subTxtTitle = (TextView) rowView.findViewById(R.id.subtxt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(title[position]);
        subTxtTitle.setText(subTitle[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
