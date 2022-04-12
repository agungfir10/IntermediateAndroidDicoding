package com.agungfir.intermediateandroiddicoding

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.annotation.AttrRes
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.intermediateandroiddicoding.databinding.ActivityEdgeTreatmentBinding
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel

class EdgeTreatmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEdgeTreatmentBinding

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEdgeTreatmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Unconventional UI"

        binding.custom.setShapeBackground()


        val edgeTreatment = BottomAppBarTopEdgeTreatment(0F, 0F, 0F)
            .apply {
                fabDiameter = 20 * 2f
            }
//        val edgeTreatment = CircleEdgeTreatment(dpToPixel(10), 0F)
        binding.cardView.shapeAppearanceModel = ShapeAppearanceModel.Builder()
            .setLeftEdge(edgeTreatment)
            .setRightEdge(edgeTreatment)
            .setAllCornerSizes(24F)
            .build()
        binding.cardView.elevation = 0F
        binding.imageView.shapeAppearanceModel = ShapeAppearanceModel.Builder()
            .setLeftEdge(edgeTreatment)
            .setRightEdge(edgeTreatment)
            .setAllCornerSizes(24F)
            .build()
    }

    private fun dpToPixel(dp: Int): Float {
        val scale = resources.displayMetrics.density
        val dpAsPixels = (16.0f * scale + 0.5f)
        return dpAsPixels
    }

//    private fun View.setShapeBackground() {
//        val cornerSize = resources.getDimension(R.dimen.corner_size)
//        background = MaterialShapeDrawable(
//            ShapeAppearanceModel.builder()
//                .setAllCornerSizes(cornerSize)
//                .setTopLeftCorner(CutCornerTreatment())
//                .setTopEdge(TriangleEdgeTreatment(cornerSize, true))
//                .setBottomEdge(TriangleEdgeTreatment(cornerSize, true))
//                .setLeftEdge(TriangleEdgeTreatment(cornerSize, false))
//                .setRightEdge(TriangleEdgeTreatment(cornerSize, false))
//                .build()
//        ).apply {
//            fillColor = ColorStateList.valueOf(getThemeColor(android.R.attr.colorPrimary))
//        }
//    }

//    private fun View.setShapeBackground() {
//        val cornerSize = resources.getDimension(R.dimen.corner_size)
//        background = MaterialShapeDrawable(
//            ShapeAppearanceModel.builder()
//                .setAllCornerSizes(cornerSize)
//                .setTopLeftCorner(CutCornerTreatment())
//                .setTopEdge(TriangleEdgeTreatment(cornerSize, true))
//                .setBottomEdge(TriangleEdgeTreatment(cornerSize, true))
//                .setLeftEdge(TriangleEdgeTreatment(cornerSize, false))
//                .setRightEdge(TriangleEdgeTreatment(cornerSize, false))
//                .build()
//        ).apply {
//            fillColor = ColorStateList.valueOf(getThemeColor(android.R.attr.colorPrimary))
//        }
//    }

    private fun View.setShapeBackground() {
        val cornerSize = resources.getDimension(R.dimen.corner_size)
        background = MaterialShapeDrawable(
            ShapeAppearanceModel.builder()
                .setAllCornerSizes(cornerSize)
//                .setTopLeftCorner(CutCornerTreatment())
//                .setTopEdge(TriangleEdgeTreatment(cornerSize, true))
//                .setBottomEdge(TriangleEdgeTreatment(cornerSize, true))
                .setLeftEdge(CircleEdgeTreatment(20F, 0F))
                .setRightEdge(CircleEdgeTreatment(20F, 0F))
                .build()
        ).apply {
            fillColor = ColorStateList.valueOf(getThemeColor(android.R.attr.colorPrimary))
        }
    }

    private fun getThemeColor(@AttrRes attrId: Int) =
        TypedValue().let { typedValue ->
            theme.resolveAttribute(attrId, typedValue, true)
            typedValue.data
        }
}