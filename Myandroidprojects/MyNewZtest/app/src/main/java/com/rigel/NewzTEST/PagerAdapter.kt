package com.rigel.NewzTEST

import android.widget.Switch
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter (f:FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(f,lifecycle) {
    override fun getItemCount(): Int {
     return 6
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0->return HOME()
            1->return Science()
            2->return tech()
            3->return Bussiness()
            4-> return Sports()
            5->return Entertaitment()
            else->return null!!
        }
    }


}