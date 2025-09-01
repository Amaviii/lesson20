package com.example.lesson20

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.core.content.ContextCompat
import android.widget.TextView

class FragmentExample : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val textView = TextView(requireContext())
        textView.text = "Фрагмент #${arguments?.getInt("number", 0) ?: 0}"
        textView.textSize = 24f
        textView.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                android.R.color.holo_blue_light
            )
        )
        textView.gravity = android.view.Gravity.CENTER
        return textView
    }

    companion object {
        fun newInstance(number: Int): FragmentExample {
            val args = Bundle()
            args.putInt("number", number)
            val fragment = FragmentExample()
            fragment.arguments = args
            return fragment
        }
    }
}