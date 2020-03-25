package com.akshobhya.librehealth.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentController;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.akshobhya.librehealth.Fragment.DoctorsFragment;
import com.akshobhya.librehealth.Fragment.HospitalsFragment;

public class HospitalTabAdapter extends FragmentPagerAdapter {
    public HospitalTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new HospitalsFragment();
        }
        else if (position == 1)
        {
            fragment = new DoctorsFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Hospital";
        }
        else if (position == 1)
        {
            title = "Doctor";
        }
        return title;
    }
}
