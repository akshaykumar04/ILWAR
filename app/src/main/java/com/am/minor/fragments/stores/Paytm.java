package com.am.minor.fragments.stores;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;

import com.am.minor.R;

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
        String isbn = bundle.getString("isbn");

        String newUA = "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0";
        bookStore = rootView.findViewById(R.id.webview);
        bookStore.getSettings().setJavaScriptEnabled(true);
        bookStore.setWebChromeClient(new WebChromeClient());
        bookStore.getSettings().setPluginState(WebSettings.PluginState.ON);
        bookStore.clearHistory();
        bookStore.clearCache(true);
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


        return rootView;
    }
}
