package com.rigel.NewzTEST



import android.os.Bundle
import android.webkit.WebResourceRequest

import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStreamReader


class web : AppCompatActivity() {
    private lateinit var webView: WebView
    private lateinit var adservers: StringBuilder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        val my=findViewById<androidx.appcompat.widget.Toolbar>(R.id.oni1)
        setSupportActionBar(my)
        val i=intent
        val webvw=findViewById<WebView>(R.id.webv)
        val myurl: String? =i.getStringExtra("url")
        webvw.webViewClient= WebViewClient()
        webvw.settings.javaScriptEnabled=true
        webvw.clearCache(true)
       webvw.getSettings().setDomStorageEnabled(true)
        webvw.settings.allowFileAccess = true

        if (myurl != null) {
            webvw.loadUrl(myurl)
        }


    }

}

