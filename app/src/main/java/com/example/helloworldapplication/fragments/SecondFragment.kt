package com.example.helloworldapplication.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.helloworldapplication.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val binding: FragmentSecondBinding = FragmentSecondBinding
            .inflate(inflater, container, false)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.hideKeyboardButton.setOnClickListener {
            this.context?.let { it1 -> onHideKeyboard(it1, binding.root) }
        }

        binding.machLineEditText.addTextChangedListener{
            if (binding.machLineEditText.lineCount > 5){
                binding.machLineEditText.text.delete(
                    binding.machLineEditText.text.length - 1,
                    binding.machLineEditText.text.length
                )
            }
        }
        return binding.root
    }

    private fun onHideKeyboard(context: Context, view: View){
        val imm: InputMethodManager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}