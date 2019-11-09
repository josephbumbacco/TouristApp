package com.example.touristapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPager extends Fragment {


    public ViewPager() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
        androidx.viewpager.widget.ViewPager pager = view.findViewById(R.id.locationViewPager);
        CustomViewPagerAdapter adapter = new CustomViewPagerAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }


    public class CustomViewPagerAdapter extends FragmentPagerAdapter {
        public CustomViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return LocationsFragment.newInstance("1", "Italy", "Description1");
                case 1: return LocationsFragment.newInstance("2","Rome","Description2");
                case 2: return LocationsFragment.newInstance("3","Greece", "Description3");
                case 3: return LocationsFragment.newInstance("4","Spain","Description4");
                case 4: return LocationsFragment.newInstance("5","Rio","Description5" );
                case 5: return LocationsFragment.newInstance("6","Japan", "Description6");
                case 6: return LocationsFragment.newInstance("7","China","Description7");
                case 7: return LocationsFragment.newInstance("8","Canada","Description8");


                default: return LocationsFragment.newInstance("ERROR","ERROR", "ERROR");
            }
        }
        @Override
        public int getCount() {
            return 7;
        }
    }
}
