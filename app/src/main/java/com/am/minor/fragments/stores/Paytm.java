package com.am.minor.fragments.stores;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.am.minor.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * Created by Akshay on 12-07-2018.
 */

public class Paytm extends Fragment {


    private WebView bookStore;
    private String base_url = " https://paytmmall.com/shop/search?q=";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.book_store, container, false);

        Bundle bundle = getActivity().getIntent().getExtras();
        final String isbn = bundle.getString("isbn");


        String newUA = "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0";
        bookStore = rootView.findViewById(R.id.webview);
        bookStore.getSettings().setJavaScriptEnabled(true);
        bookStore.setWebChromeClient(new WebChromeClient());
        bookStore.getSettings().setPluginState(WebSettings.PluginState.ON);
        //bookStore.getSettings().setUserAgentString(newUA);
        bookStore.loadUrl(base_url + isbn);


        bookStore.canGoBack();
        bookStore.setOnKeyListener(new View.OnKeyListener() {

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == MotionEvent.ACTION_UP
                        && bookStore.canGoBack()) {
                    bookStore.goBack();
                    return true;
                }
                return false;
            }
        });

        FloatingActionButton floatingActionButton = getActivity().findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey! checkout this book on Paytm Mall at the cheapest price at\n\n" + base_url + isbn
                + "\n\n--powered by Interactive Learning with AR app!");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });


        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
