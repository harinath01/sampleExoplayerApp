package com.example.sampleplayerapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tpstream.player.*
import com.tpstream.player.ui.InitializationListener
import com.tpstream.player.ui.TPStreamPlayerView
import com.tpstream.player.ui.TpStreamPlayerFragment

class PlayerActivity : AppCompatActivity() {
    lateinit var player: TpStreamPlayer
    lateinit var playerView: TPStreamPlayerView
    lateinit var playerFragment: TpStreamPlayerFragment
    private val accessToken = "c381512b-7337-4d8e-a8cf-880f4f08fd08"
    private val videoId = "C3XLe1CCcOq"
    private var parameters : TpInitParams? = null
    private var pausedAt: Long = 0L
    val TAG = "PlayerActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actitvity_tpstreams_player)

        val sharedPreference =  getSharedPreferences("player", Context.MODE_PRIVATE)
        pausedAt = sharedPreference.getLong("pausedAt", 0L)

        playerFragment = supportFragmentManager.findFragmentById(R.id.tpstream_player_fragment) as TpStreamPlayerFragment
        playerFragment.setOnInitializationListener(object: InitializationListener {

            override fun onInitializationSuccess(player: TpStreamPlayer) {
                this@PlayerActivity.player = player
                playerView = playerFragment.tpStreamPlayerView
                loadPLayer()
            }
        });
        playerFragment.enableAutoFullScreenOnRotate()
    }

    fun loadPLayer(){
        if (parameters == null){
            parameters = TpInitParams.Builder()
                .setVideoId("BMKNMs2DnXZ")
                .setAccessToken("14d73e70-bf86-4ee9-905a-7a30e28bdb37")
                .setOrgCode("6eafqn")
                .startAt(pausedAt)
                .enableDownloadSupport(true)
                .build()
        }
        player.load(parameters!!)
    }
}