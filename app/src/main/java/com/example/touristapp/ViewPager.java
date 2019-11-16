package com.example.touristapp;


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

        view.findViewById(R.id.mapButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                            Manifest.permission.ACCESS_FINE_LOCATION)) {

                        final AlertDialog alertDialog =
                                new AlertDialog.Builder(getContext())
                                .setTitle("ACCESS LOCATION")
                                .setMessage("We require your location to navigate you to the destination")
                                .create();
                        alertDialog.setButton(
                                AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        alertDialog.dismiss();
                                        ActivityCompat.requestPermissions(getActivity(),
                                                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                                PERMISSION_ACCESS_FINE_LOCATION);
                                    }
                                }
                        );
                        alertDialog.show();
                    } else {
                        ActivityCompat.requestPermissions(getActivity(),
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                PERMISSION_ACCESS_FINE_LOCATION);
                    }
                } else {
                    Uri location = Uri.parse(geoCoordinate);
                    Intent intent = new Intent(Intent.ACTION_VIEW, location);
                    intent.setPackage("com.google.android.apps.maps");

                    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(getContext(), "Cannot find any eligible software to perform this task", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
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
                case 0: return LocationsFragment.newInstance(R.drawable.city1, "Chicago", "Description1");
                case 1: return LocationsFragment.newInstance(R.drawable.city2,"Rome","Description2");
                case 2: return LocationsFragment.newInstance(R.drawable.city3,"Greece", "Description3");
                case 3: return LocationsFragment.newInstance(R.drawable.city1,"Spain","Description4");
                case 4: return LocationsFragment.newInstance(R.drawable.city2,"Rio","Description5" );
                case 5: return LocationsFragment.newInstance(R.drawable.city3,"Japan", "Description6");
                case 6: return LocationsFragment.newInstance(R.drawable.city2,"China","Description7");
                case 7: return LocationsFragment.newInstance(R.drawable.city1,"Canada","Description8");


                default: return LocationsFragment.newInstance(R.drawable.city1,"ERROR", "ERROR");
            }
        }
        @Override
        public int getCount() {
            return 7;
        }
    }
}
