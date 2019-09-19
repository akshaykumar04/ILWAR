package com.am.minor.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.am.minor.R;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ProfileFragment extends Fragment {

    private ImageView profilePic;
    TextView name, email;
    private FirebaseAuth mAuth;

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, viewGroup, false);
        mAuth = FirebaseAuth.getInstance();
        profilePic = view.findViewById(R.id.profilePic);
        name = view.findViewById(R.id.displayName);
        email = view.findViewById(R.id.displayEmail);
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateProfile(currentUser);



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
