package com.agungfir.intermediateandroiddicoding.custom_view

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.intermediateandroiddicoding.databinding.ActivityCanvasBinding

class CanvasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCanvasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCanvasBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        // use canvas view
        setContentView(CanvasView(this))

        // create bitmap Bitmap.createBitmap(width, height, Bitmap.Config)
        val mBitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888)
        val mCanvas = Canvas(mBitmap)
        binding.myImageView.setImageBitmap(mBitmap)
    }
}