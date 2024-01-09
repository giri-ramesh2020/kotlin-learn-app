// MenuFragment.kt

package com.example.buttoncontest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.buttoncontest.databinding.FragmentTapAppBinding


class TapAppFragment : Fragment() {

    private var _binding: FragmentTapAppBinding? = null
    private val binding get() = _binding!!

    private var dogCount = 0
    private var catCount = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTapAppBinding.inflate(inflater, container, false)
        val view = binding.root

        initListeners()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initListeners() {
        // Additional listeners for other UI elements...

        binding.btnDog.setOnClickListener {
            binding.tv.text = "いぬ"
            dogCount++
            updateScore()
            binding.imageView.setImageResource(R.drawable.dog_vec)
        }

        binding.btnCat.setOnClickListener {
            binding.tv.text = "ねこ"
            catCount++
            updateScore()
            binding.imageView.setImageResource(R.drawable.cat_vec)
        }

        binding.btnClear.setOnClickListener {
            clearAllRecords()
        }

        // Additional listener for hiding the winner board
        binding.imageView.setOnClickListener {
            hideWinnerBoard()
        }
    }

    private fun clearAllRecords() {
        binding.tv.text = "リセットされました"
        dogCount = 0
        catCount = 0
        updateScore() // Add this line to clear the score display
        hideWinnerBoard()
        binding.imageView.setImageResource(R.drawable.reset_vec)
    }

    private fun hideWinnerBoard() {
        // Make the winner board disappear
        binding.imageView.setImageDrawable(null)
        // Enable the buttons
        enableButtonContest(true)
    }

    private fun enableButtonContest(enable: Boolean) {
        binding.btnDog.isEnabled = enable
        binding.btnCat.isEnabled = enable
    }

    private fun updateScore() {
        // Update the score display
        binding.tvScore.text = "いぬ: $dogCount  ねこ: $catCount"
    }
}
