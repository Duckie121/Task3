package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import com.example.myapplication.R.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(layout.main_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Thêm đoạn mã thiết lập sự kiện click cho nút "Get started"
        val buttonGetStarted: Button = findViewById(id.button_get_started)
        buttonGetStarted.setOnClickListener {
            // Chuyển sang LoginActivity khi nhấn nút
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}

