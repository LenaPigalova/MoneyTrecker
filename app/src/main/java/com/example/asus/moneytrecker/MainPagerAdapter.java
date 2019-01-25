package com.example.asus.moneytrecker;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;

import layout.BalanceFragment;

/**
 * Created by ASUS on 24.01.2019.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private String[] titles;

    public MainPagerAdapter(FragmentManager fm, Context context){
        super(fm);
        titles = context.getResources().getStringArray(R.array.tab_title);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return FragmrntItemsActivity.createFragmentItem(position);
            case 1:return FragmrntItemsActivity.createFragmentItem(position);
            case 2: return new BalanceFragment();
            default: return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
