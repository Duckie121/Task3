package com.example.myapplication

import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private var correctDrops = 0
    private var totalDrops = 0
    private var correctGames = 0

    private lateinit var currentRubbish: ImageView
    private lateinit var loseLayout: RelativeLayout
    private lateinit var winLayout: RelativeLayout
    private val rubbishIds = listOf(
        R.id.rubbish1, R.id.rubbish2, R.id.rubbish3,
        R.id.rubbish4, R.id.rubbish5, R.id.rubbish6, R.id.rubbish7
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gamescreen)

        // Khai báo winLayout và loseLayout
        winLayout = findViewById(R.id.winLayout)
        loseLayout = findViewById(R.id.loseLayout)

        // Tìm kiếm các nút trong màn hình
        val okButton = findViewById<Button>(R.id.okButton)
        val retryButton = findViewById<Button>(R.id.retryButton)
        val backButton = findViewById<ImageView>(R.id.imageView29)

        // Đặt các trình nghe sự kiện cho các nút
        okButton.setOnClickListener {
            // Quay trở lại màn hình menu
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish() // Kết thúc activity hiện tại
        }

        retryButton.setOnClickListener {
            // Ẩn đi màn hình thua và đặt lại trò chơi
            loseLayout.visibility = View.INVISIBLE
            resetGame()
        }

        // Đặt trình nghe sự kiện cho nút quay lại
        backButton.setOnClickListener {
            // Quay trở lại màn hình trước đó
            finish()
        }

        // Tìm kiếm các ImageView đại diện cho thùng rác
        val recycleBin = findViewById<ImageView>(R.id.imageView17)
        val organicBin = findViewById<ImageView>(R.id.imageView18)
        val nonRecycleBin = findViewById<ImageView>(R.id.imageView19)

        // Thiết lập các trình nghe sự kiện thả
        setDropListeners(recycleBin, "recycle")
        setDropListeners(organicBin, "organic")
        setDropListeners(nonRecycleBin, "non-recycle")

        // Xuất hiện vật rác đầu tiên
        spawnNewRubbish()
    }

    private fun setDragListeners(rubbish: ImageView) {
        rubbish.setOnLongClickListener {
            Log.d("DragDrop", "Long click detected, starting drag")
            val clipData = ClipData.newPlainText("", "")
            val dragShadow = View.DragShadowBuilder(it)
            it.startDragAndDrop(clipData, dragShadow, it, 0)
            true
        }
    }

    private fun setDropListeners(bin: ImageView, binType: String) {
        bin.setOnDragListener { view, event ->
            when (event.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    Log.d("DragDrop", "Drag started")
                }
                DragEvent.ACTION_DRAG_ENTERED -> {
                    Log.d("DragDrop", "Drag entered")
                }
                DragEvent.ACTION_DRAG_EXITED -> {
                    Log.d("DragDrop", "Drag exited")
                }
                DragEvent.ACTION_DROP -> {
                    Log.d("DragDrop", "Dropped")
                    val droppedView = event.localState as ImageView
                    handleDrop(droppedView, binType)
                }
                DragEvent.ACTION_DRAG_ENDED -> {
                    Log.d("DragDrop", "Drag ended")
                }
            }
            true
        }
    }

    private fun handleDrop(droppedView: ImageView, binType: String) {
        val rubbishType = when (droppedView.id) {
            R.id.rubbish1 -> "organic"
            R.id.rubbish2 -> "recycle"
            R.id.rubbish3 -> "recycle"
            R.id.rubbish4 -> "organic"
            R.id.rubbish5 -> "recycle"
            R.id.rubbish6 -> "recycle"
            R.id.rubbish7 -> "non-recycle"
            else -> ""
        }

        if (rubbishType == binType) {
            correctDrops++
            Toast.makeText(this, "Đúng!", Toast.LENGTH_SHORT).show()

            // Tăng số lần chơi đúng
            correctGames++
        } else {
            Toast.makeText(this, "Sai!", Toast.LENGTH_SHORT).show()
        }

        totalDrops++

        if (totalDrops == 7) {
            if (correctGames >= 5) {
                // Hiển thị màn hình thắng nếu số lần chơi đúng >= 5
                winLayout.visibility = View.VISIBLE
            } else {
                // Hiển thị màn hình thua nếu số lần chơi đúng < 5
                loseLayout.visibility = View.VISIBLE
            }
            // Đặt lại số lần chơi đúng và số lần chơi sau mỗi lần chơi
            correctGames = 0
            totalDrops = 0
            resetGame()
        } else {
            spawnNewRubbish()
        }
    }

    private fun spawnNewRubbish() {
        // Ẩn tất cả các hình ảnh rác
        rubbishIds.forEach { id ->
            findViewById<ImageView>(id).visibility = View.INVISIBLE
        }

        // Hiển thị một hình ảnh rác ngẫu nhiên
        val randomIndex = Random.nextInt(rubbishIds.size)
        currentRubbish = findViewById(rubbishIds[randomIndex])
        currentRubbish.visibility = View.VISIBLE

        // Thiết lập trình nghe sự kiện kéo cho vật rác hiện tại
        setDragListeners(currentRubbish)
    }

    private fun resetGame() {
        correctDrops = 0
        totalDrops = 0
        spawnNewRubbish()
    }
}
