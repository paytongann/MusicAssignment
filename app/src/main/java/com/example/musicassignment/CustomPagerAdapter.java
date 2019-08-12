package com.example.musicassignment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class CustomPagerAdapter extends FragmentPagerAdapter {
    ArrayList<SongFragment> pages = new ArrayList<>();

    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return pages.get(i);
    }

    @Override
    public int getCount() {
        return pages.size();
    }
    public void addPages(SongFragment songFragment){
        pages.add(songFragment);
        notifyDataSetChanged();
    }
}
