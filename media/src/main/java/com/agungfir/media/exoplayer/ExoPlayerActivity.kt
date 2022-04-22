package com.agungfir.media.exoplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.media.databinding.ActivityExoPlayerBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

class ExoPlayerActivity : AppCompatActivity() {
    companion object {
        const val URL_VIDEO_DICODING =
            "https://github.com/dicodingacademy/assets/releases/download/release-video/VideoDicoding.mp4"
    }

    private val viewBinding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityExoPlayerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        val player = ExoPlayer.Builder(this).build()
        viewBinding.videoView.player = player

        val mediaItem = MediaItem.fromUri(URL_VIDEO_DICODING)
        player.setMediaItem(mediaItem)
        player.prepare()
    }
}