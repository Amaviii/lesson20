package com.example.lesson20

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: DynamicFragmentAdapter
    private var fragmentCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        val addButton = findViewById<Button>(R.id.btnAddFragment)

        adapter = DynamicFragmentAdapter(this)
        viewPager.adapter = adapter

        // Добавим первый фрагмент
        addNewFragment()

        addButton.setOnClickListener {
            addNewFragment()
        }
    }

    private fun addNewFragment() {
        fragmentCounter++
        val fragment = FragmentExample.newInstance(fragmentCounter)
        adapter.addFragment(fragment)
        // Переключаемся на новый фрагмент
        viewPager.currentItem = adapter.itemCount - 1
    }
}