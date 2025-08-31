package com.example.lesson20

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        val tabs = listOf(
            Pair("Главная", R.drawable.ic_launcher_foreground),
            Pair("Профиль", R.drawable.outline_add_to_queue_24),
            Pair("Настройки", R.drawable.outline_airline_seat_recline_extra_24)
        )

        tabs.forEach { (title, iconRes) ->
            val tab = tabLayout.newTab()
            val customView = layoutInflater.inflate(R.layout.custom_tab, null)
            val imageView = customView.findViewById<ImageView>(R.id.tabIcon)
            val textView = customView.findViewById<TextView>(R.id.tabText)

            textView.text = title
            imageView.setImageResource(iconRes)

            tab.customView = customView
            tabLayout.addTab(tab)
        }

    }
}