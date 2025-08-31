package com.example.lesson20

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment){

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            2 -> ThirdFragment()
            else -> throw IllegalStateException("Unexpected position: $position")
        }
    }
}