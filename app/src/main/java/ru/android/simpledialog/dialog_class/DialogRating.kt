package ru.android.simpledialog.dialog_class

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import ru.android.simpledialog.R

class DialogRating : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val view = LayoutInflater.from(context).inflate(R.layout.fragment_rating_dialog, null)
            builder.setView(view)
            builder.setTitle("Rate yourself")
                .setIcon(R.drawable.ic_baseline_star_purple500_24)
                .setPositiveButton("accept") { dialog, _ ->
                    dialog.dismiss()
                }
                .setNegativeButton("decline") { dialog, _ ->
                    dialog.dismiss()
                }
            builder.create()
            builder.show()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}