package ru.android.simpledialog.dialog_class

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import ru.android.simpledialog.R

class DialogListSwitch : DialogFragment() {

    private val sound = arrayOf("moo", "woof", "meow")

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("What sound does a cow make?")
                .setIcon(R.drawable.ic_baseline_campaign_24)
                .setSingleChoiceItems(sound, -1) { _, item ->
                    Toast.makeText(
                        activity, sound[item],
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .setPositiveButton("accept") { dialog, _ ->
                    dialog.cancel()
                }
                .setNegativeButton("decline") { dialog, _ ->
                    dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}