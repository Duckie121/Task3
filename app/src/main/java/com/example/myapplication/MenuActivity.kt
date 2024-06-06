package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menuscreen)

        // Liên kết các hình chữ nhật trong XML với mã Kotlin
        val function1: ImageView = findViewById(R.id.imageView5)
        val function2: ImageView = findViewById(R.id.imageView7)
        val imageView13: ImageView = findViewById(R.id.imageView13) // Thêm liên kết tới imageView13

        // Thiết lập onClickListener cho từng hình chữ nhật
        function1.setOnClickListener {
            // Xử lý khi function1 được nhấn
            Toast.makeText(this@MenuActivity, "Function 1 clicked", Toast.LENGTH_SHORT).show()
            // Chuyển đến màn hình mới cho function 1
            startActivity(Intent(this@MenuActivity, StartGuideScreenActivity::class.java))
        }

        function2.setOnClickListener {
            // Xử lý khi function2 được nhấn
            Toast.makeText(this@MenuActivity, "Function 2 clicked", Toast.LENGTH_SHORT).show()
            // Chuyển đến màn hình mới cho function 2
            startActivity(Intent(this@MenuActivity, StartGameScreenActivity::class.java))
        }

        // Thiết lập onClickListener cho imageView13 để quay lại màn hình đăng nhập
        imageView13.setOnClickListener {
            // Chuyển đến màn hình đăng nhập
            startActivity(Intent(this@MenuActivity, LoginActivity::class.java))
            finish() // Kết thúc activity hiện tại
        }

        // Tương tự cho function3 và function4 nếu cần
    }
}
