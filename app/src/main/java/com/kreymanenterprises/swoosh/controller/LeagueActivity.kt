package com.kreymanenterprises.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.kreymanenterprises.swoosh.R
import com.kreymanenterprises.swoosh.model.Player
import com.kreymanenterprises.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*


class LeagueActivity : BaseActivity() {
    var selectedLeague = ""
    var player = Player("", "")

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
        }
    }

    fun menClicked(view: View){
        womenLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = "men"
    }

    fun womenClicked(view: View) {
        menLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = "women"
    }

    fun coedClicked(view: View) {
        womenLeagueBtn.isChecked = false
        menLeagueBtn.isChecked = false

        player.league = "coed"
    }

    fun leagueNextClicked(view: View) {
        if (player.league != ""){
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Select a League.", Toast.LENGTH_SHORT).show()
        }
    }
}