package com.example.touristapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocationsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    private int mParam1;
    private String mParam2;
    private String mParam3;


    public LocationsFragment() {
        // Required empty public constructor
    }

        public static LocationsFragment newInstance(int param1, String param2, String param3) {
            LocationsFragment fragment = new LocationsFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_PARAM1, param1);
            args.putString(ARG_PARAM2, param2);
            args.putString(ARG_PARAM3, param3);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mParam1 = getArguments().getInt(ARG_PARAM1);
                mParam2 = getArguments().getString(ARG_PARAM2);
                mParam3 = getArguments().getString(ARG_PARAM3);
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_locations, container, false);
            ImageView imagePlaceHolder = view.findViewById(R.id.locationImage);
            if (mParam1 != 0) {
                imagePlaceHolder.setImageResource(mParam1);
            }

            TextView locationName = view.findViewById(R.id.locationName);
            if (mParam2 != null) {
                locationName.setText(mParam2);
            }

            TextView locationDetails = view.findViewById(R.id.locationDetails);
            if (mParam3 != null) {
                locationDetails.setText(mParam3);
            }
            return view;

        }

    }
