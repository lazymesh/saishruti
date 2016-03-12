package com.beauty.SaiShruti.tabs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import com.beauty.SaiShruti.R;
import com.beauty.SaiShruti.gallery.GalleryUtils;

/**
 * Created by user on 02/02/16.
 */
public class Gallery extends Fragment {

    private ImageView hair;
    private ImageView facial;
    private ImageView mehendi;
    private ImageView nail;
    private ImageView makeup;
    private ImageView more;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gallery, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        hair = (ImageView) getView().findViewById(R.id.hair);
        facial = (ImageView) getView().findViewById(R.id.facial);
        mehendi = (ImageView) getView().findViewById(R.id.mehendi);
        nail = (ImageView) getView().findViewById(R.id.nail);
        makeup = (ImageView) getView().findViewById(R.id.makeup);
        more = (ImageView) getView().findViewById(R.id.more);

        setOnClickListener(hair, "Hair");
        setOnClickListener(facial, "Facial");
        setOnClickListener(mehendi, "Mehendi");
        setOnClickListener(nail, "Nail");
        setOnClickListener(makeup, "MakeUp");

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(getOpenFacebookIntent(getContext()));
            }
        });
    }

    private void setOnClickListener(ImageView imageView, final String gallery){
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GalleryUtils galleryUtils = new GalleryUtils(getActivity().getApplicationContext());
                if(galleryUtils.getFilePaths(gallery).size() > 0){
                    Intent intent = new Intent("GalleryViewActivity");
                    intent.putExtra("folderName", gallery);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(), "It does not have photos yet", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Intent getOpenFacebookIntent(Context context) {
        String url = "https://www.facebook.com/sai.shruti.50/photos_stream?ref=page_internal";
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://facewebmodal/f?href=" + url));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        }
    }
}