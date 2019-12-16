package com.am.minor.fragments.stores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.am.minor.R;

/**
 * Created by Akshay on 12-07-2018.
 */

public class Flipkart extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.store_frag_flipkart, container, false);
        return rootView;
    }

}
