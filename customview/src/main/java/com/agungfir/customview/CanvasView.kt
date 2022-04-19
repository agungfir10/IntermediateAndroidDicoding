package com.agungfir.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.core.content.res.ResourcesCompat

class CanvasView(context: Context) : View(context) {
    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // Di sini Anda bisa langsung menggunakan canvas dari kelas View.
        //canvas.drawColor(ResourcesCompat.getColor(resources, R.color.purple_200, null))

        val mBitmap = Bitmap.createBitmap(1100, 1100, Bitmap.Config.ARGB_8888)
        val mPaint = Paint()
        mPaint.color = ResourcesCompat.getColor(resources, R.color.pink_200, null)
        // create circle / membuat lingkaran
        canvas.drawCircle(
            (mBitmap.width / 2).toFloat(),
            (mBitmap.height / 2).toFloat(),
            200f,
            mPaint
        )

        val mBitmapRect = Bitmap.createBitmap(1100, 1100, Bitmap.Config.ARGB_8888)
        val mPaintRect = Paint()
        mPaintRect.color = ResourcesCompat.getColor(resources, R.color.pink_500, null)
        // create rect / membuat persegi
        canvas.drawRect(
            (mBitmapRect.width / 2 - 100).toFloat(),
            (mBitmapRect.height / 2 - 100).toFloat(),
            (mBitmapRect.width / 2 + 100).toFloat(),
            (mBitmapRect.height / 2 + 100).toFloat(),
            mPaintRect
        )

        val mPaintText = Paint(Paint.FAKE_BOLD_TEXT_FLAG)
        mPaintText.textSize = 20F
        mPaintText.color = ResourcesCompat.getColor(resources, R.color.white, null)

        val text = "Selamat Datang!"
        val mBounds = Rect()
        mPaintText.getTextBounds(text, 0, text.length, mBounds)
        val x: Int = mBitmap.width / 2 - mBounds.centerX()
        val y: Int = mBitmap.height / 2 - mBounds.centerY()
        canvas.drawText(text, x.toFloat(), y.toFloat(), mPaintText)

        mPaint.color = ResourcesCompat.getColor(resources, R.color.pink_200, null)
        canvas.drawCircle(
            (mBitmap.width / 2).toFloat(),
            (mBitmap.height / 2).toFloat(),
            200f,
            mPaint
        )

        mPaint.color = ResourcesCompat.getColor(resources, R.color.pink_500, null)
        val mRect = Rect()
        mRect.set(
            mBitmap.width / 2 - 100,
            mBitmap.height / 2 - 100,
            mBitmap.width / 2 + 100,
            mBitmap.height / 2 + 100
        )
        canvas.drawRect(mRect, mPaint)

        canvas.clipRect(
            mBitmap.width / 2 - 100,
            mBitmap.height / 2 - 100,
            mBitmap.width / 2 + 100,
            mBitmap.height / 2 + 100
        )
    }
}