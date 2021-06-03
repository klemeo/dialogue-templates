package ru.android.simpledialog.dialog_class

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import ru.android.simpledialog.MainActivity
import ru.android.simpledialog.R

class DialogConnectionActivity : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Info!")
                .setMessage("Take part in the survey?")
                .setIcon(R.drawable.ic_baseline_info_24)
                .setPositiveButton("accept") { dialog, _ ->
                    (activity as MainActivity?)!!.okClicked()
                    dialog.cancel()
                }
                .setNegativeButton("decline") { dialog, _ ->
                    (activity as MainActivity?)!!.cancelClicked()
                    dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}