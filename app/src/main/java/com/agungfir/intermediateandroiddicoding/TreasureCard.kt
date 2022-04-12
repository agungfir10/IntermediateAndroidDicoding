package com.agungfir.intermediateandroiddicoding

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment
import com.google.android.material.card.MaterialCardView
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.shape.TriangleEdgeTreatment


class TreasureCard : MaterialCardView {

    constructor(context: Context?) : super(context){
        applyEdgeTreatmentToCardView()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        applyEdgeTreatmentToCardView()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ){
        applyEdgeTreatmentToCardView()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }

    private fun setEdgeTreatment() {
        val notchRadius = 20F
        val edgeTreatment = TriangleEdgeTreatment(dpToPixel(10), true)

    }

    private fun dpToPixel(dp: Int): Float {
        val scale = resources.displayMetrics.density
        val dpAsPixels = (16.0f * scale + 0.5f)
        return dpAsPixels
    }

    private fun applyEdgeTreatmentToCardView() {
        val edgeTreatment = TriangleEdgeTreatment(dpToPixel(10), true)
        shapeAppearanceModel = ShapeAppearanceModel.Builder()
            .setLeftEdge(edgeTreatment)
            .setRightEdge(edgeTreatment)
            .setAllCornerSizes(8F)
            .build()
    }
}