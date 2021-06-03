package ru.android.simpledialog.dialog_class

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import ru.android.simpledialog.R
import java.util.*

class DialogAutomaticClosing : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val timer = Timer()
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Warning!")
                .setMessage("Error")
                .setIcon(R.drawable.ic_baseline_dangerous_24)
            timer.schedule(object : TimerTask() {
                override fun run() {
                    dialog?.dismiss()
                    timer.cancel()
                }
            }, 5000)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}