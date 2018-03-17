package com.developer.kayali.tourguideapp;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {
    // To store the current Context
    private Context mContext;

    // Constructor with two inputs: Context and FragmentManager
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // Get the current item
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new OutsideFragment();
        } else if (position == 1) {
            return new ShoppingFragment();
        } else if (position == 2) {
            return new RestaurantsFragment();
        } else if (position == 3) {
            return new CultureFragment();
        } else return new MuseumsFragment();
    }

    // Get count of Fragments
    @Override
    public int getCount() {
        return 5;
    }

    // Get Fragment's Title
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_outside);
        } else if (position == 1) {
            return mContext.getString(R.string.category_shopping);
        } else if (position == 2) {
            return mContext.getString(R.string.category_restaurants);
        } else if (position == 3) {
            return mContext.getString(R.string.category_culture);
        } else return mContext.getString(R.string.category_museums);
    }
}
