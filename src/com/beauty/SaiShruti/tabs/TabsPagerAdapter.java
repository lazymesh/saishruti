package com.beauty.SaiShruti.tabs;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.beauty.SaiShruti.beautyTips.BeautyTips;
import com.beauty.SaiShruti.services.Services;

/**
 * Created by user on 31/01/16.
 */


public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Gallery fragment activity
                return new Gallery();
            case 1:
                // Beauty Tips fragment activity
                return new BeautyTips();
            case 2:
                // Services fragment activity
                return new Services();
            case 3:
                // About fragment activity
                return new About();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 4;
    }

}