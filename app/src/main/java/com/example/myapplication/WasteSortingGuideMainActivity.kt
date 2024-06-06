package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class WasteSortingGuideMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wastesortingguidemainscreen)

        val imageView20: ImageView = findViewById(R.id.imageView20)
        val imageView21: ImageView = findViewById(R.id.imageView21)
        val imageView22: ImageView = findViewById(R.id.imageView22)
        val imageView25: ImageView = findViewById(R.id.imageView25)
        val imageView26: ImageView = findViewById(R.id.imageView26)
        val imageView27: ImageView = findViewById(R.id.imageView27)
        val imageView28: ImageView = findViewById(R.id.imageView28)
        val imageView31: ImageView = findViewById(R.id.imageView31)
        val imageView44: ImageView = findViewById(R.id.imageView44)
        val imageView32: ImageView = findViewById(R.id.imageView32) // Adding the back button ImageView

        imageView20.setOnClickListener {
            openIdentifyScreen(R.drawable.can, false)
        }

        imageView21.setOnClickListener {
            openIdentifyScreen(R.drawable.wine_bottles, false)
        }

        imageView22.setOnClickListener {
            openIdentifyScreen(R.drawable.nails, true)
        }

        imageView25.setOnClickListener {
            openIdentifyScreen(R.drawable.compost, true)
        }

        imageView26.setOnClickListener {
            openIdentifyScreen(R.drawable.plastic, false)
        }

        imageView27.setOnClickListener {
            openIdentifyScreen(R.drawable.paper, false)
        }
        imageView28.setOnClickListener {
            openIdentifyScreen(R.drawable.wood, false)
        }
        imageView31.setOnClickListener {
            openIdentifyScreen(R.drawable.battery1, false)
        }
        imageView44.setOnClickListener {
            openIdentifyScreen(R.drawable.cups, true)
        }

        // Set an OnClickListener to navigate back to MenuScreenActivity when imageView32 is clicked
        imageView32.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }

    private fun openIdentifyScreen(imageResId: Int, isIdentifyItemScreen2: Boolean) {
        val intent = if (isIdentifyItemScreen2) {
            Intent(this, IdentifyItemActivity::class.java)
        } else {
            Intent(this, IdentifyItemActivity2::class.java) // This is for identifyitemscreen
        }

        intent.putExtra("imageResId", imageResId)
        startActivity(intent)
    }
}
