package com.tg.lax

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * The main menu screen with options
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        singleplayer.setOnClickListener {
            startActivity(
                    Intent(this, CategorySelectActivity::class.java)
            )
        }

        multiplayer.setOnClickListener {
            Toast.makeText(this, "This functionality has been disabled for your convenience. Please come back at a later time!", Toast.LENGTH_SHORT).show()
        }

        leaderboards.setOnClickListener {
            Toast.makeText(this, "This functionality has been disabled for your convenience. Please come back at a later time!", Toast.LENGTH_SHORT).show()
        }

        report.setOnClickListener { this.showBugReportDialog() }
    }

    /**
     * Shows the dialog to report a bug or give feedback
     */
    fun showBugReportDialog() {
        val dialog = AlertDialog.Builder(this)
        dialog.setView(R.layout.long_text_field)
        dialog.setTitle("Send Feedback")
        dialog.setPositiveButton("Send") { dialogInterface, i ->
            //TODO
            Toast.makeText(this, "Thank you! We have received your feedback.", Toast.LENGTH_SHORT).show()
        }
        dialog.setNegativeButton("Cancel") { dialogInterface, i ->  }
        dialog.show()
    }
}
