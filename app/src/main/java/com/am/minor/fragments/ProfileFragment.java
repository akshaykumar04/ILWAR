package com.am.minor.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.am.minor.LoginActivity;
import com.am.minor.R;
import com.am.minor.otp.OtpActivity;
import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.File;


public class ProfileFragment extends Fragment {

    TextView name, email;
    private ImageView profilePic;
    private FirebaseAuth mAuth;
    private String logoutKey = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profile, viewGroup, false);
        mAuth = FirebaseAuth.getInstance();
        profilePic = view.findViewById(R.id.profilePic);
        name = view.findViewById(R.id.displayName);
        email = view.findViewById(R.id.displayEmail);
        final FirebaseUser currentUser = mAuth.getCurrentUser();
        updateProfile(currentUser);


        CardView Logout = view.findViewById(R.id.logout_button);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(getActivity(), LoginActivity.class);
                logout.putExtra("key", logoutKey);
                startActivity(logout);
            }
        });

        return view;
    }

    private void updateProfile(FirebaseUser user) {

        if (user != null) {
            name.setText(user.getDisplayName());
            email.setText(user.getEmail());
            // Loading profile image
            Uri profilePicUrl = user.getPhotoUrl();
            if (profilePicUrl != null) {
                Glide.with(this).load(profilePicUrl)
                        .into(profilePic);
            }
        }

    }
}
