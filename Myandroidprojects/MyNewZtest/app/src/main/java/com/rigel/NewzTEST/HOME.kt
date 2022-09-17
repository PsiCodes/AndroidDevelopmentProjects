package com.rigel.NewzTEST

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class HOME : Fragment() {
    lateinit var adp:adpter
   var MyModalList:ArrayList<ModalNews?> = ArrayList( )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View=inflater.inflate(R.layout.fragment_h_o_m_e, container, false)

        val r1: RecyclerView? = v.findViewById(R.id.Homefrag)
        val mylm: RecyclerView.LayoutManager= LinearLayoutManager(context)
        r1?.layoutManager=mylm
        adp= adpter(MyModalList,context)
        r1?.adapter=adp
        findnews()
        var YouKnow= arrayOf(1,2,3)
        r1!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                YouKnow[0]=newState
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(dy>0&&(YouKnow[0]==0||YouKnow[0]==2)){
                   hideToolb()
                }else{
                    if (dy< -10){showtb()}
                }
            }
        })
        return v

    }

    private fun hideToolb() {
        MainActivity.n.my!!.visibility=View.GONE
    }
    private fun showtb() {
        MainActivity.n.my!!.visibility=View.VISIBLE
    }

    private fun findnews() {
      val g=  apiutility.getMyApi().getMynews("in",100)
        g.enqueue(object:Callback<newsz>{
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<newsz>, response: Response<newsz>) {
                if(response.isSuccessful) {
                    MyModalList .addAll( response.body()!!.articles)
                    adp.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<newsz>, t: Throwable) {

            }


        })

    }}

