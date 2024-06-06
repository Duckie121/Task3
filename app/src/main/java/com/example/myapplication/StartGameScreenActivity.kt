package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class StartGameScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.playgamescreen)

        // Tham chiếu đến nút "PLAY" từ tệp XML
        val buttonPlay: Button = findViewById(R.id.button_play)

        // Xử lý sự kiện bấm nút "PLAY"
        buttonPlay.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

        // Tham chiếu đến ImageView "imageView45" từ tệp XML
        val imageView45: ImageView = findViewById(R.id.imageView45)

        // Xử lý sự kiện bấm vào ImageView "imageView45"
        imageView45.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}
