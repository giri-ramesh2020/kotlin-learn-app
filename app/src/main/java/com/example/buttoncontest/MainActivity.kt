package com.example.buttoncontest

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var imageView: ImageView
    private lateinit var btnDog: Button
    private lateinit var btnCat: Button
    private lateinit var btnClear: Button
    private lateinit var tvScore: TextView

    private var dogCount = 0
    private var catCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.tv)
        imageView = findViewById(R.id.imageView)
        btnDog = findViewById(R.id.btnDog)
        btnCat = findViewById(R.id.btnCat)
        btnClear = findViewById(R.id.btnClear)
        tvScore = findViewById(R.id.tvScore) // Add this line to initialize tvScore

        initListeners()
    }

    private fun initListeners() {
        btnDog.setOnClickListener {
            textView.text = "Dog"
            dogCount++
            updateScore()
            showToast("Dog was clicked. (Dog count: $dogCount)")
            imageView.setImageResource(R.drawable.dog_vec)
        }

        btnCat.setOnClickListener {
            textView.text = "Cat"
            catCount++
            updateScore()
            showToast("Cat was clicked. (Cat count: $catCount)")
            imageView.setImageResource(R.drawable.cat_vec)
        }

        btnClear.setOnClickListener {
            clearAllRecords()
        }

        // Additional listener for hiding the winner board
        imageView.setOnClickListener {
            hideWinnerBoard()
        }
    }

    private fun clearAllRecords() {
        textView.text = "Please click the button."
        dogCount = 0
        catCount = 0
        updateScore() // Add this line to clear the score display
        hideWinnerBoard()
        showToast("All data are reset.")
        imageView.setImageDrawable(null)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun hideWinnerBoard() {
        // Make the winner board disappear
        imageView.setImageDrawable(null)         // Enable the buttons
        enableButtonContest(true)
    }

    private fun enableButtonContest(enable: Boolean) {
        btnDog.isEnabled = enable
        btnCat.isEnabled = enable
    }

    private fun updateScore() {
        // Update the score display
        tvScore.text = "Dog: $dogCount  Cat: $catCount"
    }
}
