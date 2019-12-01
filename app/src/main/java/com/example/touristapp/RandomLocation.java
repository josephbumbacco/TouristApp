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
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.touristapp.ReviewsDetails.locationDesc;
import static com.example.touristapp.ReviewsDetails.locationImage;
import static com.example.touristapp.ReviewsDetails.locationName;
import static com.example.touristapp.ReviewsFragment.locationNumber;
import static com.example.touristapp.ViewPager.PERMISSION_ACCESS_FINE_LOCATION;


/**
 * A simple {@link Fragment} subclass.
 */
public class RandomLocation extends Fragment {


    public static String geoLocation;

    public static TextView locationName;
    public static TextView locationDesc;
    public static ImageView locationImage;

    public RandomLocation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_reviews_details, container, false);


        locationName = view.findViewById(R.id.textObj1);
        locationDesc = view.findViewById(R.id.textObj2);

        locationImage = view.findViewById(R.id.imageObj);


        locationImage.setOnClickListener(new View.OnClickListener(){
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
                    Uri location = Uri.parse(geoLocation);
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

        int randomNumber = new Random().nextInt(4)+1;

        switch (randomNumber){

            case 1:
                locationName.setText("Ambassador Bridge");
                locationDesc.setText("The Ambassador Bridge is a suspension bridge which connects Detroit, MI to Windsor, ON. The bridge spans the Hudson River, and is a total of 7,490 feet long");
                locationImage.setImageResource(R.drawable.bridge);
                geoLocation = "google.navigation:q=42.311065, -83.068843&mode=w";
                break;


            case 2:
                locationName.setText("Jackson Park");
                locationDesc.setText("Jackson Park is a park which contains many  Memorials including both a World War II and Korean War Memorial. Jackson park also contains a wide variety of plants and vegetation");
                locationImage.setImageResource(R.drawable.jacksonpark);
                geoLocation = "google.navigation:q=42.295257, -83.022749&mode=w";
                break;

            case 3:
                locationName.setText("Dieppe Gardens");
                locationDesc.setText("Dieppe Garden is a riverfront park containing many Memorials to the Essex-Kent Scottish Regiment.");
                locationImage.setImageResource(R.drawable.gardens);
                geoLocation = "google.navigation:q=42.319895, -83.041199&mode=w";
                break;

            case 4:
                locationName.setText("Willistead Park");
                locationDesc.setText("Willistead Park is a park located in the Walkerville area of Windsor. This park contains over 300 trees, including Windsor's only persimmon, a tree native to the southern United States.");
                locationImage.setImageResource(R.drawable.willistead);
                geoLocation = "google.navigation:q=42.317968, -83.009958&mode=w";
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
