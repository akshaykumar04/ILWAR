package com.am.minor.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.am.minor.BuyBooksActivity;
import com.am.minor.R;

public class TutorialFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tutorial, viewGroup, false);

        Intent i  = new Intent(getActivity(), BuyBooksActivity.class);
        startActivity(i);

        return view;
    }
}
