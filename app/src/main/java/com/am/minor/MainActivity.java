package com.am.minor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.am.minor.fragments.HomeFragment;
import com.am.minor.fragments.ProfileFragment;
import com.am.minor.fragments.TutorialFragment;

public class MainActivity extends AppCompatActivity {

    Button home, profile, tutorial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottomnav);
//        home= findViewById(R.id.home);
//        profile = findViewById(R.id.profile);
//        tutorial = findViewById(R.id.tutorial);
    }

    public void onClick(View view) {
        Fragment fragment = new HomeFragment();
        ;
        if (view == findViewById(R.id.home)) {
            fragment = new HomeFragment();

        } else if (view == findViewById(R.id.profile)) {
            fragment = new ProfileFragment();

        } else if (view == findViewById(R.id.tutorial)) {
            fragment = new TutorialFragment();

        }
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.output, fragment);
        transaction.commit();
    }
}
