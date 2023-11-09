package com.example.sampleplayerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val defaultExoplayerActivity = findViewById<Button>(R.id.defaultExoplayerActivity)
        val tpstreamsPlayerActivity = findViewById<Button>(R.id.tpstreamsPlayerActivity)

        defaultExoplayerActivity.setOnClickListener {
            val intent = Intent(this, DefaultExoplayerActivity::class.java)
            startActivity(intent)
        }

        tpstreamsPlayerActivity.setOnClickListener {
            val intent = Intent(this, PlayerActivity::class.java)
            startActivity(intent)
        }
    }
}