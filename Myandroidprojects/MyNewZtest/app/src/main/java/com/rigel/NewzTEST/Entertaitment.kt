package com.rigel.NewzTEST

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Entertaitment : Fragment() {
    lateinit var adp:adpter
    var MyModalList:ArrayList<ModalNews?> = ArrayList( )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View=inflater.inflate(R.layout.fragment_entertaitment, container, false)

        val r1: RecyclerView? = v.findViewById(R.id.Entertaitmentfrag)
        val mylm: RecyclerView.LayoutManager= LinearLayoutManager(context)
        r1?.layoutManager=mylm
        adp= adpter(MyModalList,context)
        r1?.adapter=adp
        findnews()
        return v

    }

    private fun findnews() {
        val g=  apiutility.getMyApi().getMynews("in","entertainment",100)
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