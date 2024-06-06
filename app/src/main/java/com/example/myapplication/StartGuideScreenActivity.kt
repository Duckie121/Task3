package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StartGuideScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waste_sorting_guide)

        // Tham chiếu đến nút "PLAY" từ tệp XML
        val buttonPlay: Button = findViewById(R.id.button)

        // Xử lý sự kiện bấm nút "PLAY"
        buttonPlay.setOnClickListener {
            val intent = Intent(this, WasteSortingGuideMainActivity::class.java)
            startActivity(intent)
        }

        // Tham chiếu đến nút "MENU" từ tệp XML
        val buttonMenu: Button = findViewById(R.id.button2)

        // Xử lý sự kiện bấm nút "MENU"
        buttonMenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}
