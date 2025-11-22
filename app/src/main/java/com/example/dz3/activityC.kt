package com.example.dz3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class ActivityC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        val buttonCallA = findViewById<Button>(R.id.buttonC)
        buttonCallA.setOnClickListener{
            val intentCallA = Intent(this, ActivityA::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intentCallA)
        }
    }
}