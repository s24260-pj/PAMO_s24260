package com.example.pamo_s24260;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class BmiChartFragment extends Fragment {

    @SuppressLint({"SetJavaScriptEnabled", "MissingInflatedId"})
    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_bmi_chart, container, false);
        WebView webView = view.findViewById(R.id.webview_bmi_chart);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/bmi_chart.html");

        return view;
    }
}