package com.example.touristapp;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.touristapp.JavaBean.Info;

import java.util.ArrayList;


public class AboutFragment extends Fragment {

    public static final int PERMISSION_SEND_SMS = 2;
    public static final int PERMISSION_INSERT = 3;

    public static String name = "TourGuide Support";
    public static String email = "tourguidesupport@hotmail.com";
    public static String phone = "5199757591";

    public AboutFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        Button emailButton = view.findViewById(R.id.emailButton);
        Button phoneButton = view.findViewById(R.id.phoneButton);
        Button callButton = view.findViewById(R.id.callButton);
        Button addContactButton = view.findViewById(R.id.addContactButton);
        Button webButton = view.findViewById(R.id.webButton);
        Button socialButton = view.findViewById(R.id.socialButton);

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, email);
                intent.putExtra(Intent.EXTRA_SUBJECT, "TourGuide Support");
                intent.putExtra(Intent.EXTRA_TEXT, "Hello TourGuide Support, ");
                if (intent.resolveActivity(getActivity().getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Toast.makeText(getContext(),"Cannot find any eligible software to perform this task", Toast.LENGTH_SHORT);
                }
            }
        });

        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED) {

                    if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                            Manifest.permission.SEND_SMS)) {
                        final AlertDialog alertDialog =
                                new AlertDialog.Builder(getContext())
                                        .setTitle("SEND SMS")
                                        .setMessage("We require your permission to begin your SMS message")
                                        .create();
                        alertDialog.setButton(
                                AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        alertDialog.dismiss();
                                        ActivityCompat.requestPermissions(getActivity(),
                                                new String[]{Manifest.permission.SEND_SMS},
                                                PERMISSION_SEND_SMS);
                                    }
                                });
                        alertDialog.show();
                    } else {
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.SEND_SMS},
                                PERMISSION_SEND_SMS);
                    }
                } else {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("smsto:"));
                    intent.putExtra("sms_body", "Hello, I have a question I'd like answered: ");
                    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(getContext(), "Cannot find any eligible software to perform this task", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:5199757591"));
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        addContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.WRITE_CONTACTS)
                        != PackageManager.PERMISSION_GRANTED) {

                    if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                            Manifest.permission.WRITE_CONTACTS)) {
                        final AlertDialog alertDialog =
                                new AlertDialog.Builder(getContext())
                                        .setTitle("ADD CONTACT")
                                        .setMessage("We require your permission to add our contact information")
                                        .create();
                        alertDialog.setButton(
                                AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        alertDialog.dismiss();
                                        ActivityCompat.requestPermissions(getActivity(),
                                                new String[]{Manifest.permission.WRITE_CONTACTS},
                                                PERMISSION_INSERT);
                                    }
                                });
                        alertDialog.show();
                    } else {
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.WRITE_CONTACTS},
                                PERMISSION_INSERT);
                    }
                } else {
                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                    intent.putExtra(ContactsContract.Intents.Insert.NAME,name);
                    intent.putExtra(ContactsContract.Intents.Insert.EMAIL,email);
                    intent.putExtra(ContactsContract.Intents.Insert.PHONE,phone);

                    if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(getContext(), "Cannot find any eligible software to perform this task", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.stclaircollege.ca/"));
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        socialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://twitter.com/intent/tweet?text=Check%20out%20the%20TourGuide%20app%2C%20on%20the%20app%20store%20now%21"));
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(getContext(), "Cannot find any eligible software to perform this task", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ArrayList<Info> links = new ArrayList<>();
        links.add(new Info("https://pixabay.com/"));
        links.add(new Info("https://en.wikipedia.org/wiki/Jackson_Park_(Windsor,_Ontario)"));
        links.add(new Info("http://detroitnews.mycapture.com/mycapture/enlarge_remote.asp?source=&remoteimageid=28319937"));
        links.add(new Info("https://www.infowindsor.com/peace-fountain-conventry-gardens/"));
        links.add(new Info("https://www.citywindsor.ca/residents/Culture/Willistead-Manor/Pages/Willistead-Manor-Tours.aspx"));
        links.add(new Info("https://developer.android.com/"));

        RecyclerView recyclerView = view.findViewById(R.id.creditsRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CustomRecyclerViewAdapter adapter = new CustomRecyclerViewAdapter(links);

        recyclerView.setAdapter(adapter);

        return view;
    }
}
