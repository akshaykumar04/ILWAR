package com.am.minor.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.am.minor.BarcodeScannerActivity;
import com.am.minor.R;

public class ScannerFragment extends Fragment {

    Button openScanner;

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scanner, viewGroup, false);

        openScanner = view.findViewById(R.id.btn_scan);
        openScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i  = new Intent(getActivity(), BarcodeScannerActivity.class);
                startActivity(i);
            }
        });


        return view;
    }
}
