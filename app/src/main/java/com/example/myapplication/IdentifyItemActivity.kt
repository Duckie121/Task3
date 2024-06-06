package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class IdentifyItemActivity : AppCompatActivity() {

    private lateinit var imageView12: ImageView
    private lateinit var imageView40: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.identifyitemscreen2)

        imageView12 = findViewById(R.id.imageView12)
        imageView40 = findViewById(R.id.imageView40)

        val imageResourceId = intent.getIntExtra("imageResId", -1)
        if (imageResourceId != -1) {
            imageView12.setImageResource(imageResourceId)
        }

        // Xử lý sự kiện nhấn vào imageView43
        imageView40.setOnClickListener {
            val intent = Intent(this@IdentifyItemActivity, WasteSortingGuideMainActivity::class.java)
            startActivity(intent)
            finish() // Nếu muốn đóng Activity hiện tại
        }
    }
}
