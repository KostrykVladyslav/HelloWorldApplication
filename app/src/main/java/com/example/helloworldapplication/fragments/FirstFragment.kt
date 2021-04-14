package com.example.helloworldapplication.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager.LayoutParams
import com.example.helloworldapplication.R
import com.example.helloworldapplication.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val binding: FragmentFirstBinding = FragmentFirstBinding
            .inflate(inflater, container, false)
        val view = binding.root
        var buttonNumber = 0

        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.fab.setOnClickListener {
            buttonNumber++
            binding.linearLayout.addView(addButtonToList(buttonNumber))
        }
        return view
    }

    @SuppressLint("SetTextI18n")
    private fun addButtonToList(number: Int): View {
        val params = LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT)
        params.gravity = 1
        params.topMargin = 5

        val button = Button(this.context)
        button.setTextColor(Color.WHITE)
        button.textSize = 20F
        button.layoutParams = params
        button.setBackgroundResource(R.drawable.button_round)
        button.text = resources.getString(R.string.button) + " " + number.toString()

        return button
    }
}