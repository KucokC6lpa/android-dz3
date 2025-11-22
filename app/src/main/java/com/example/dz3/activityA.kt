package com.example.dz3

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ActivityA : AppCompatActivity() {
    private var color: String? = null
    private lateinit var etColor: EditText
    companion object {
        const val toBkey = "toBkey"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity)

        etColor = findViewById<EditText>(R.id.etColor)


        if (savedInstanceState != null) {
            color = savedInstanceState.getString("colorKey")
            color?.let { etColor.setText(it) }
        }

        val buttonCallB = findViewById<Button>(R.id.button)
        buttonCallB.setOnClickListener{
            val colorToB = etColor.text.toString()
            val intentCallB = Intent(this, ActivityB::class.java)
            intentCallB.putExtra(toBkey, colorToB)
            intentCallB.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)

            startActivity(intentCallB)
        }

        val buttonSetColor = findViewById<Button>(R.id.buttonGenCol)
        buttonSetColor.setOnClickListener{
            val hex = generateColor()
            color = hex
            etColor.setText(hex)
        }
    }
        override fun onSaveInstanceState(outState: Bundle) {
            outState.putString("colorKey", etColor.text.toString())
            super.onSaveInstanceState(outState)
        }

        override fun onRestoreInstanceState(savedInstanceState: Bundle) {
            super.onRestoreInstanceState(savedInstanceState)
            val restoredColor: String? = savedInstanceState?.getString("colorKey")
        }

        private fun generateColor(): String {
            val random = java.util.Random()
            val color = Color.rgb(
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256)
            )
            return String.format("#%06X", 0xFFFFFF and color)
        }
    }