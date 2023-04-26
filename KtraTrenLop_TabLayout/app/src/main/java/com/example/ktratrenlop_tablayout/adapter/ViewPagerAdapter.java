package com.example.ktratrenlop_tablayout.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ktratrenlop_tablayout.fragment.FragmentDS;
import com.example.ktratrenlop_tablayout.fragment.FragmentTK;
import com.example.ktratrenlop_tablayout.fragment.FragmentTT;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private int numPage=3;


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new FragmentDS();
            case 1: return new FragmentTT();
            case 2: return new FragmentTK();
        }
        return new FragmentDS();
    }

    @Override
    public int getCount() {
        return numPage;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Danh sach";
            case 1: return "Thong tin";
            case 2: return "Tim kiem";
        }
        return "Danh sach";
    }
}
