package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class IdentifyItemActivity2 : AppCompatActivity() {

    private lateinit var imageView12: ImageView
    private lateinit var imageView43: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.identifyitemscreen)

        imageView12 = findViewById(R.id.imageView12)
        imageView43 = findViewById(R.id.imageView43)

        val imageResourceId = intent.getIntExtra("imageResId", -1)
        if (imageResourceId != -1) {
            imageView12.setImageResource(imageResourceId)
        }

        // Xử lý sự kiện nhấn vào imageView43
        imageView43.setOnClickListener {
            val intent = Intent(this@IdentifyItemActivity2, WasteSortingGuideMainActivity::class.java)
            startActivity(intent)
            finish() // Nếu muốn đóng Activity hiện tại
        }
    }
}
