package com.example.helloworldapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.helloworldapplication.R
import com.example.helloworldapplication.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    override fun onCreateView
                (inflater: LayoutInflater,
                 container: ViewGroup?,
                 savedInstanceState: Bundle?
    ): View {
        val binding: FragmentMainBinding = FragmentMainBinding
            .inflate(inflater, container, false)
        val view = binding.root

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_FirstFragment) }
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_SecondFragment) }
        binding.buttonThird.setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_ThirdFragment) }
        return view
    }
}