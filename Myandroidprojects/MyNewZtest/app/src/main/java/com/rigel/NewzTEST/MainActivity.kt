package com.rigel.NewzTEST

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.rigel.NewzTEST.MainActivity.n.my
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    object n {
        var my: Toolbar? = null
    }

    lateinit var adpter22: adpter2
    var Mylist = ArrayList<ModalNews>()
//    lateinit var a: ViewPager2

    val a22: Handler = Handler()
   lateinit var myslider:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        my = findViewById(R.id.tb)
        setSupportActionBar(my)
        findnews()
        Toast.makeText(applicationContext, "App By Pranjal", Toast.LENGTH_SHORT).show()
        if (!isConnected(this)) {
            showInternetDialog();
        }
        //Tablayout
        val ac: TabLayout = findViewById(R.id.Realjdk)
        val Myvp = findViewById<ViewPager2>(R.id.view11)
        val pagerAdapter = PagerAdapter(supportFragmentManager, lifecycle)
        Myvp.adapter = pagerAdapter
        TabLayoutMediator(ac, Myvp) { ac, position ->
            when (position) {
                0 -> ac.text = "Home"
                1 -> ac.text = "Science"
                2 -> ac.text = "Tech"
                3 -> ac.text = "Bussiness"
                4 -> ac.text = "Sports"
                5 -> ac.text = "Entertaitment"
                else -> ac.text = "69"
            }
        }.attach()
        //Api
        val api: String = "962a1c54b51d4cbc91d11a641c1646c0"

    }


    private fun showInternetDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(false)
        val view = LayoutInflater.from(this)
            .inflate(R.layout.no_internet_dialog, findViewById(R.id.tryagain))
        view.findViewById<View>(R.id.tryagain).setOnClickListener {
            if (!isConnected(this)) {
                showInternetDialog()
            } else {
                startActivity(Intent(getApplicationContext(), this::class.java))
                finish()
            }
        }
        builder.setView(view)
        val alertDialog = builder.create()
        alertDialog.show()
    }

    private fun isConnected(M: MainActivity): Boolean {
        val connectivityManager =
            M.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        val mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
        return wifiConn != null && wifiConn.isConnected || mobileConn != null && mobileConn.isConnected
    }


    private fun findnews() {
        val g = apiutility.getMyApi().getMynews("in", 10)
        g.enqueue(object : Callback<newsz> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<newsz>, response: Response<newsz>) {
                if (response.isSuccessful) {
                    Mylist.addAll(response.body()!!.articles)

                }
            }

            override fun onFailure(call: Call<newsz>, t: Throwable) {

            }


        })

    }
}


