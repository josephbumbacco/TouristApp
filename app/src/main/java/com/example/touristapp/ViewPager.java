package com.example.touristapp;


import android.content.Intent;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import static com.example.touristapp.LocationsFragment.newInstance;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPager extends Fragment {


    public static final int PERMISSION_ACCESS_FINE_LOCATION = 1;

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
                case 0:

                    return LocationsFragment.newInstance(R.drawable.bridge
                        , "Ambassador Bridge"
                        , "The Ambassador Bridge is a suspension bridge which connects Detroit, MI to Windsor, ON. The bridge spans the Hudson River, and is a total of 7,490 feet long"
                        );

                case 1: return LocationsFragment.newInstance(R.drawable.jacksonpark
                        ,"Jackson Park"
                        ,"Jackson Park is a park which contains many  Memorials including both a World War II and Korean War Memorial. Jackson park also contains a wide variety of plants and vegetation"
                        );


                case 2: return LocationsFragment.newInstance(R.drawable.gardens
                        ,"Dieppe Gardens"
                        , "Dieppe Garden is a riverfront park containing many Memorials to the Essex-Kent Scottish Regiment."
                        );

                case 3: return LocationsFragment.newInstance(R.drawable.willistead
                        ,"Willistead Park"
                        ,"Willistead Park is a park located in the Walkerville area of Windsor. This park contains over 300 trees, including Windsor's only persimmon, a tree native to the southern United States."
                        );

                default: return LocationsFragment.newInstance(R.drawable.bridge,"ERROR", "ERROR");
            }
        }
        @Override
        public int getCount() {
            return 4;
        }
    }
}
