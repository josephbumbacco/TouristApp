package com.example.touristapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_viewpager, R.id.nav_reviews, R.id.nav_about)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    /**
     * Method inflates the options menu and includes the icons for each overflow action
     * @param menu
     *
     */
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch(requestCode) {

            case ViewPager.PERMISSION_ACCESS_FINE_LOCATION: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Uri location = Uri.parse(ReviewsDetails.geoLocation);
                    Intent intent = new Intent(Intent.ACTION_VIEW, location);
                    intent.setPackage("com.google.android.apps.maps");

                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Cannot find any eligible software to perform this task", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //disable button

                }
                break;
            }
            case AboutFragment.PERMISSION_SEND_SMS: {
                if (grantResults.length > 0 && (grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED)) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("smsto:"));
                    intent.putExtra("sms_body", "Hello, I have a question I'd like answered: ");
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Cannot find any eligible software to perform this task", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //disable button

                }
                break;
            }
            case AboutFragment.PERMISSION_INSERT: {
                if (grantResults.length > 0 && (grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED)) {
                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                    intent.putExtra(ContactsContract.Intents.Insert.NAME, AboutFragment.name);
                    intent.putExtra(ContactsContract.Intents.Insert.EMAIL, AboutFragment.email);
                    intent.putExtra(ContactsContract.Intents.Insert.PHONE, AboutFragment.phone);

                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Cannot find any eligible software to perform this task", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //disable button

                }
                break;
            }

        }
    }
}
