package com.example.catshelter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.catshelter.adapter.CatAdapter
import com.example.catshelter.data.DataSource
import com.example.catshelter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val dataSource = DataSource()
        val catList = dataSource.getCats()

        binding.catRecycler.adapter = CatAdapter(this,catList)

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.catRecycler)
    }
}