package com.agungfir.animation.property_animation

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.agungfir.animation.R
import com.agungfir.animation.databinding.ActivityPropertyAnimationBinding

class PropertyAnimationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPropertyAnimationBinding

    @SuppressLint("StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPropertyAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ValueAnimator.ofFloat(0F, 100F).apply {
            duration = 3000
            addUpdateListener { updatedAnimation ->
                binding.tvTranslationX.apply {
                    translationX = updatedAnimation.animatedValue as Float
                    translationZ = updatedAnimation.animatedValue as Float * 2F
                    val translationX = Math.round(updatedAnimation.animatedValue as Float)
                    binding.tvTranslationX.text =
                        getString(R.string.translation_x, translationX)
                    binding.ivSoccerballX.translationX = updatedAnimation.animatedValue as Float
                }
            }
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
            start()
        }

        ObjectAnimator.ofFloat(binding.tvTranslationY, "translationY", 200f).apply {
            duration = 4000
            addUpdateListener {
                binding.tvTranslationY.translationY = it.animatedValue as Float
                val translationY = Math.round(it.animatedValue as Float)
                val translationX = Math.round(binding.tvTranslationY.translationX)
                binding.tvTranslationY.text =
                    getString(R.string.translation_y, translationY, translationX)
                binding.ivSoccerballY.translationY = it.animatedValue as Float
            }
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
            start()
        }
        ObjectAnimator.ofFloat(binding.tvScale, "scaleX", 2F).apply {
            duration = 4000
            addUpdateListener {
                binding.tvScale.text = getString(R.string.scale, it.animatedValue as Float)
                binding.tvScale.scaleX = it.animatedValue as Float
                binding.tvScale.scaleY = it.animatedValue as Float
                binding.ivSoccerballScale.apply {
                    scaleX = it.animatedValue as Float
                    scaleY = it.animatedValue as Float
                }
            }
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
            start()
        }

        ObjectAnimator.ofFloat(binding.tvRotation, "rotation", 45F).apply {
            duration = 4000
            addUpdateListener {
                val rotation = Math.round(it.animatedValue as Float)
                binding.tvRotation.text = getString(R.string.rotation, rotation)
                binding.tvRotation.rotation = it.animatedValue as Float
                binding.ivSoccerballRotation.rotation = it.animatedValue as Float
            }
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
            start()
        }

//        val bouncer = AnimatorSet().apply {
//            play(bounceAnim).before(squashAnim1)
//        }
//
//        val fadeAnim = ObjectAnimator.ofFloat(newBall, "alpha", 1f, 0f).apply {
//            duration = 250
//        }
//
//        AnimatorSet().apply
//        {
//            play(bouncer).before(fadeAnim)
//            start()
//        }
    }

}