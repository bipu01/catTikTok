package com.yourname.cattiktok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private val catImageUrls = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.viewPager)

        // Load initial images
        loadMoreCats()

        // Detect scroll to load more cats
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (position >= catImageUrls.size - 2) {
                    loadMoreCats()
                }
            }
        })
    }

    private fun loadMoreCats() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val newCats = RetrofitClient.apiService.getRandomCat()
                newCats.forEach { catImage ->
                    catImageUrls.add(catImage.url)
                }
                withContext(Dispatchers.Main) {
                    viewPager.adapter = CatPagerAdapter(this@MainActivity, catImageUrls)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
