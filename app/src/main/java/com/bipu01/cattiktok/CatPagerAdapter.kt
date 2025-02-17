package com.yourname.cattiktok

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class CatPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val imageUrls: List<String>
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = imageUrls.size

    override fun createFragment(position: Int): Fragment {
        return CatImageFragment.newInstance(imageUrls[position])
    }
}
