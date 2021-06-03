package ru.android.simpledialog

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.android.simpledialog.utils.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialogOneButton.setOnClickListener {
            showDialogOneButton()
        }

        dialogTwoButton.setOnClickListener {
            showDialogTwoButton()
        }

        dialogThreeButton.setOnClickListener {
            showDialogThreeButton()
        }

        dialogList.setOnClickListener {
            showDialogList()
        }

        dialogListSwitch.setOnClickListener {
            showDialogListSwitch()
        }

        dialogListChoice.setOnClickListener {
            showDialogListChoice()
        }

        dialogAutomaticClosing.setOnClickListener {
            showDialogAutomaticClosing()
        }

        dialogRating.setOnClickListener {
            showDialogRating()
        }

        dialogConnection.setOnClickListener {
            showDialogConnection()
        }

    }

    fun okClicked() {
        Toast.makeText(
            applicationContext, "You have selected the Accept button!",
            Toast.LENGTH_LONG
        ).show()
    }

    fun cancelClicked() {
        Toast.makeText(
            applicationContext, "You have selected the Decline button",
            Toast.LENGTH_LONG
        ).show()
    }

}