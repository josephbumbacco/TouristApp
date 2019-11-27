package com.example.touristapp;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewsFragment extends Fragment {

    ListView listView;
    public static int locationNumber;


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
        locations.add(new Locations("Ambassador Bridge","2/5", R.drawable.bridge));
        locations.add(new Locations("Jackson Park","4/5", R.drawable.jacksonpark));
        locations.add(new Locations("Dieppe Gardens","3/5", R.drawable.gardens));
        locations.add(new Locations("Willistead Park","5/5", R.drawable.willistead));

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
            final Locations item = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_item, parent, false);

            }
            final TextView locationName = convertView.findViewById(R.id.topText);
            locationName.setText(item.getLocationName());

            TextView locationRating = convertView.findViewById(R.id.bottomText);
            locationRating.setText(item.getLocationRating());

            ImageView locationImage = convertView.findViewById(R.id.locationImage);
            locationImage.setImageResource(item.getLocationImage());


            convertView.findViewById(R.id.locationImage).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (item.getLocationName()) {

                        case "Ambassador Bridge":
                            locationNumber = 1;
                            Navigation.findNavController(listView).navigate(R.id.action_nav_reviews_to_reviewsDetails);
                            break;

                        case "Jackson Park":
                            locationNumber = 2;
                            Navigation.findNavController(listView).navigate(R.id.action_nav_reviews_to_reviewsDetails);
                            break;

                        case "Dieppe Gardens":
                            locationNumber = 3;
                            Navigation.findNavController(listView).navigate(R.id.action_nav_reviews_to_reviewsDetails);
                            break;

                        case "Willistead Park":
                            locationNumber = 4;
                            Navigation.findNavController(listView).navigate(R.id.action_nav_reviews_to_reviewsDetails);
                            break;

                    }
                }
            });

            return convertView;
        }
    }

}
