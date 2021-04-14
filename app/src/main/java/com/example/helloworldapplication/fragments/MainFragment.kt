package com.example.helloworldapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
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
        val nav = Navigation.findNavController(this.requireActivity(), R.id.nav_host_fragment)

        binding.buttonFirst.setOnClickListener {
            nav.navigate(R.id.action_MainFragment_to_FirstFragment) }
        binding.buttonSecond.setOnClickListener {
            nav.navigate(R.id.action_MainFragment_to_SecondFragment) }
        binding.buttonThird.setOnClickListener {
            nav.navigate(R.id.action_MainFragment_to_ThirdFragment) }
        return view
    }
}