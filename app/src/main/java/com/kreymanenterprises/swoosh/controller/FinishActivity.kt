package com.kreymanenterprises.swoosh.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kreymanenterprises.swoosh.R
import com.kreymanenterprises.swoosh.model.Player
import com.kreymanenterprises.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        searchLeaguesText.text = "Looking for ${player!!.league} ${player!!.skill} league near you..."
    }
}