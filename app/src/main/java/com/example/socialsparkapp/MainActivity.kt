package com.example.socialspark

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var timeInput: EditText
    private lateinit var suggestionText: TextView
    private lateinit var getButton: Button
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        timeInput = findViewById(R.id.timeInput)
        suggestionText = findViewById(R.id.suggestionText)
        getButton = findViewById(R.id.getButton)
        resetButton = findViewById(R.id.resetButton)

        // Set click listeners
        getButton.setOnClickListener { getSuggestion() }
        resetButton.setOnClickListener { resetUI() }
    }

    private fun getSuggestion() {
        val input = timeInput.text.toString().trim().lowercase()

        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter a time of day!", Toast.LENGTH_SHORT).show()
            return
        }

        val suggestion = when (input) {
            "morning" -> "☀️ Send a 'Good morning' text to a family member"
            "mid-morning" -> "⭐ Reach out to a colleague with a quick 'Thank you'"
            "afternoon" -> "🎉 Share a funny meme or interesting link with a friend"
            "snack time" -> "💭 Send a quick 'thinking of you' message"
            "dinner" -> "📞 Call a friend or relative for a 5-minute catch-up"
            "night" -> "🌙 Leave a thoughtful comment on a friend's post"
            else -> null
        }

        if (suggestion != null) {
            suggestionText.text = suggestion
            Toast.makeText(this, "✨ Spark generated! ✨", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Try: morning, afternoon, dinner, or night", Toast.LENGTH_SHORT).show()
            suggestionText.text = ""
        }
    }

    private fun resetUI() {
        timeInput.text.clear()
        suggestionText.text = ""
        Toast.makeText(this, "Ready for a new spark!", Toast.LENGTH_SHORT).show()
    }
}