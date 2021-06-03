package ru.android.simpledialog.dialog_class

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import ru.android.simpledialog.R

class DialogWarningThreeButton : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("What sound does a cow make?")
                .setIcon(R.drawable.ic_baseline_campaign_24)
                .setPositiveButton("moo") { dialog, _ ->
                    dialog.cancel()
                }
                .setNeutralButton("woof") { dialog, _ ->
                    dialog.cancel()

                }
                .setNegativeButton("meow") { dialog, _ ->
                    dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}