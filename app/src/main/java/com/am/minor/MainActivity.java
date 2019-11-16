package com.am.minor;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.am.minor.fragments.HomeFragment;
import com.am.minor.fragments.ProfileFragment;
import com.am.minor.fragments.TutorialFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_nav);
        loadFragment(new HomeFragment());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.output, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_profile:
                fragment = new ProfileFragment();
                break;

            case R.id.navigation_tutorial:
                fragment = new TutorialFragment();
                break;
        }

        return loadFragment(fragment);
    }


    public void openARCamera(View view) {

        Intent intent = getPackageManager().getLaunchIntentForPackage("com.am.ar");
        if (intent == null) {
            Toast.makeText(view.getContext(), "Error Launching Camera!", Toast.LENGTH_SHORT).show();
        }
        assert intent != null;
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplication().startActivity(intent);
    }

}
