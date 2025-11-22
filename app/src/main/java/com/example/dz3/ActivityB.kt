package com.example.dz3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import android.graphics.Color

class ActivityB : AppCompatActivity() {
    private var backColor: String? = null
    private val backColKey = "backColKey"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

            val colorFromIntent = intent.getStringExtra(ActivityA.toBkey)
            if (colorFromIntent != null) {
                applyBackgroundColor(colorFromIntent)
                backColor = colorFromIntent
            }

        if (savedInstanceState != null) {
            val saved = savedInstanceState.getString(backColKey)
            if (saved != null) {
                applyBackgroundColor(saved)
                backColor = saved
            }
        }


        val buttonCallC = findViewById<Button>(R.id.buttonB)
        buttonCallC.setOnClickListener{
            val intentCallC = Intent(this, ActivityC::class.java)
            startActivity(intentCallC)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(backColKey, backColor)
    }

    private fun applyBackgroundColor(hex: String) {
        try { findViewById<ConstraintLayout>(R.id.activity_b).setBackgroundColor(Color.parseColor(hex)) } catch (_: Exception) {}
    }

}