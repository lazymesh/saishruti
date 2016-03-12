package com.beauty.SaiShruti.beautyTips;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.beauty.SaiShruti.R;
import com.beauty.SaiShruti.beautyTips.BeautyTipsAdapter;

/**
 * Created by user on 02/02/16.
 */
public class BeautyTips extends ListFragment implements AdapterView.OnItemClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.beauty_tips, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = new BeautyTipsAdapter(getActivity(), title, subTitle, imageId);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        Intent intent = new Intent("BeautyTipsActivity");
        intent.putExtra("fileName", title[position].toLowerCase()+".txt");
        startActivity(intent);
    }

    String[] title = {
            "Mehendi",
            "Facial",
            "Nail",
            "Eye",
            "Hair",
            "Threading",
            "Massage",
            "Skin",
            "Waxing"
    } ;

    String[] subTitle = {
            "tips on Mehendi",
            "tips on Facial",
            "tips on Nail",
            "tips on Eye",
            "tips on Hair",
            "tips on Threading",
            "tips on Massage",
            "tips on Skin",
            "tips on Waxing"
    } ;
    Integer[] imageId = {
            R.drawable.mehendi_tips,
            R.drawable.facial_tips,
            R.drawable.nail_tips,
            R.drawable.eye_tips,
            R.drawable.hair_tips,
            R.drawable.threading_tips,
            R.drawable.massage_tips,
            R.drawable.skin_tips,
            R.drawable.waxing_tips
    };
}
