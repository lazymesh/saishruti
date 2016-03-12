package com.beauty.SaiShruti.services;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.beauty.SaiShruti.R;

/**
 * Created by user on 20/02/2016.
 */
public class ServicesAdapter extends ArrayAdapter {
    private final Activity context;

    public ServicesAdapter(Activity context) {
        super(context, R.layout.services);
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.services, parent, false);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        txtTitle.setText(R.array.services);
        return rowView;
    }
}