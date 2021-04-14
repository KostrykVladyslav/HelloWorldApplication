
package com.example.helloworldapplication.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.helloworldapplication.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        val binding: FragmentThirdBinding = FragmentThirdBinding
            .inflate(inflater, container, false)

        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.applianceCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (buttonView != null) {
                binding.radioCheckBox.isEnabled = isChecked
                binding.sliderCheckBox.isEnabled = isChecked
                binding.seekBar.isEnabled = isChecked
                binding.radioFirst.isEnabled = isChecked
                binding.radioSecond.isEnabled = isChecked
                binding.radioThird.isEnabled = isChecked
            }
        }

        binding.radioCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (buttonView != null) {
                    binding.radioFirst.isEnabled = !isChecked
                    binding.radioSecond.isEnabled = !isChecked
                    binding.radioThird.isEnabled = !isChecked
            }
        }

        binding.sliderCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (buttonView != null) {
                    binding.seekBar.isEnabled = !isChecked
            }
        }
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean){}
                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    if (seekBar != null) {
                        if (seekBar.progress == 1){
                            binding.radioFirst.isChecked = true
                        }
                        if (seekBar.progress == 2){
                            binding.radioSecond.isChecked = true
                        }
                        if (seekBar.progress == 3){
                            binding.radioThird.isChecked = true
                        }

                    }
                }
            }
        )

        binding.radioFirst.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                binding.seekBar.progress = 1
            }
        }

        binding.radioSecond.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                binding.seekBar.progress = 2
            }
        }

        binding.radioThird.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                binding.seekBar.progress = 3
            }
        }
        return  binding.root
    }
}