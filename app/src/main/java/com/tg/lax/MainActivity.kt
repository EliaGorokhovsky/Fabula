package com.tg.lax

import android.app.Dialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

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

    fun showBugReportDialog() {
        val dialog = AlertDialog.Builder(this)
        dialog.setView(R.layout.long_text_field)
        dialog.setTitle("Send Feedback")
        dialog.setPositiveButton("Send") { dialogInterface, i ->
            Toast.makeText(this, "Thank you! We have received your feedback.", Toast.LENGTH_SHORT).show()
        }
        dialog.setNegativeButton("Cancel") { dialogInterface, i ->  }
        dialog.show()
    }
}
