package com.example.touristapp;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewsFragment extends Fragment {

    ListView listView;


    public ReviewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reviews, container, false);

        listView = view.findViewById(R.id.locationsList);

        final ArrayList<Locations> locations = new ArrayList<>();
        locations.add(new Locations("Somewhere","Chicago,IL","3.5/5"));
        locations.add(new Locations("Somewhere","Chicago,IL","3.5/5"));
        locations.add(new Locations("Somewhere","Chicago,IL","3.5/5"));
        locations.add(new Locations("Somewhere","Chicago,IL","3.5/5"));
        locations.add(new Locations("Somewhere","Chicago,IL","3.5/5"));
        locations.add(new Locations("Somewhere","Chicago,IL","3.5/5"));

        //ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, locations);

        CustomListViewAdapter adapter1 = new CustomListViewAdapter(getContext(), locations);

        listView.setAdapter(adapter1);

        return view;
    }

    public class CustomListViewAdapter extends ArrayAdapter<Locations> {
        public CustomListViewAdapter(@NonNull Context context, ArrayList<Locations> items) {
            super(context, 0, items);
        }

        @NonNull
        @Override

        public View getView(int position, View convertView, ViewGroup parent) {
            Locations item = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_item, parent, false);

            }
            TextView locationName = convertView.findViewById(R.id.topLeftText);
            locationName.setText(item.getLocationName());

            TextView locationDetails = convertView.findViewById(R.id.topRightText);
            locationDetails.setText(item.getLocationDetails());

            TextView locationRating = convertView.findViewById(R.id.bottomText);
            locationRating.setText(item.getLocationRating());

            return convertView;
        }
    }

}
