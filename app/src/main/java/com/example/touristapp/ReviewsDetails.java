package com.example.touristapp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import static com.example.touristapp.ReviewsFragment.locationNumber;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewsDetails extends Fragment {



    public ReviewsDetails() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_reviews_details, container, false);

       TextView locationName = view.findViewById(R.id.textObj1);
       TextView locationDesc = view.findViewById(R.id.textObj2);

       ImageView locationImage = view.findViewById(R.id.imageObj);

       switch (locationNumber){

           case 1:
               locationName.setText("Ambassador Bridge");
               locationDesc.setText("The Ambassador Bridge is a suspension bridge which connects Detroit, MI to Windsor, ON. The bridge spans the Hudson River, and is a total of 7,490 feet long");
               locationImage.setImageResource(R.drawable.bridge);
               break;


           case 2:
               locationName.setText("Jackson Park");
               locationDesc.setText("Jackson Park is a park which contains many  Memorials including both a World War II and Korean War Memorial. Jackson park also contains a wide variety of plants and vegetation");
               locationImage.setImageResource(R.drawable.jacksonpark);
               break;

           case 3:
               locationName.setText("Dieppe Gardens");
               locationDesc.setText("Dieppe Garden is a riverfront park containing many Memorials to the Essex-Kent Scottish Regiment.");
               locationImage.setImageResource(R.drawable.gardens);
               break;

           case 4:
               locationName.setText("Willistead Park");
               locationDesc.setText("Willistead Park is a park located in the Walkerville area of Windsor. This park contains over 300 trees, including Windsor's only persimmon, a tree native to the southern United States.");
               locationImage.setImageResource(R.drawable.willistead);
               break;


               default:
               locationName.setText("ERROR");
               locationDesc.setText("ERROR");
               locationImage.setImageResource(R.drawable.ic_menu_gallery);
               break;

       }



        return view;
    }

}
