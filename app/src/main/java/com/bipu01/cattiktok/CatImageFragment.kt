package com.bipu01.cattiktok

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class CatImageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.item_cat, container, false)
        val imageUrl = arguments?.getString("url")
        Glide.with(this).load(imageUrl).into(view.findViewById(R.id.catImage))
        return view
    }

    companion object {
        fun newInstance(url: String) = CatImageFragment().apply {
            arguments = Bundle().apply { putString("url", url) }
        }
    }
}
