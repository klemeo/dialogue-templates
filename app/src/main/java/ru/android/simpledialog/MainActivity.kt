package ru.android.simpledialog

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialogOneButton.setOnClickListener {
            val dialog = DialogWarningOneButton()
            val manager = supportFragmentManager
            dialog.show(manager, "dialogOne")
        }

        dialogTwoButton.setOnClickListener {
            val dialog = DialogWarningTwoButton()
            val manager = supportFragmentManager
            dialog.show(manager, "dialogTwo")
        }
        dialogThreeButton.setOnClickListener {
            val dialog = DialogWarningThreeButton()
            val manager = supportFragmentManager
            dialog.show(manager, "dialogThree")
        }
        dialogList.setOnClickListener {
            val dialog = DialogList()
            val manager = supportFragmentManager
            dialog.show(manager, "dialogList")
        }
        dialogListSwitch.setOnClickListener {
            val dialog = DialogListSwitch()
            val manager = supportFragmentManager
            dialog.show(manager, "dialogListSwitch")
        }
        dialogListChoice.setOnClickListener {
            val dialog = DialogListChoice()
            val manager = supportFragmentManager
            dialog.show(manager, "dialogListChoice")
        }
        dialogAutomaticClosing.setOnClickListener {
            val dialog = DialogAutomaticClosing()
            val manager = supportFragmentManager
            dialog.show(manager, "dialogAutomaticClosing")
        }
        dialogRating.setOnClickListener {
            showDialogRating()
        }
        dialogConnection.setOnClickListener {
            val dialog = DialogConnectionActivity()
            val manager = supportFragmentManager
            dialog.show(manager, "dialogConnection")
        }
    }

    private fun showDialogRating() {
        val alertDialog = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.fragment_rating_dialog, null)
        alertDialog.setView(view)
        alertDialog.setTitle("Rate yourself")
            .setIcon(R.drawable.ic_baseline_star_purple500_24)
            .setPositiveButton("accept") { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton("decline") { dialog, _ ->
                dialog.dismiss()
            }
        alertDialog.create()
        alertDialog.show()
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

class DialogWarningOneButton : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Warning!")
                .setMessage("Error")
                .setIcon(R.drawable.ic_baseline_dangerous_24)
                .setPositiveButton("ok") { dialog, _ ->
                    dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}

class DialogWarningTwoButton : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Info!")
                .setMessage("Take part in the survey?")
                .setIcon(R.drawable.ic_baseline_info_24)
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

class DialogList : DialogFragment() {

    private val sound = arrayOf("moo", "woof", "meow")

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("What sound does a cow make?")
                .setIcon(R.drawable.ic_baseline_campaign_24)
                .setItems(sound) { dialog, _ ->
                    dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}

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

class DialogListChoice : DialogFragment() {

    private val sound = arrayOf("moo", "woof", "meow")
    private val checkedItems = booleanArrayOf(false, false, false)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("What sound does a cow make?")
                .setIcon(R.drawable.ic_baseline_campaign_24)
                .setMultiChoiceItems(sound, checkedItems) { _, which, isChecked ->
                    checkedItems[which] = isChecked
                    val name = sound[which] // Get the clicked item
                    Toast.makeText(activity, name, Toast.LENGTH_LONG).show()
                }
                .setPositiveButton("accept") { _, _ ->
                    for (i in sound.indices) {
                        val checked = checkedItems[i]
                        if (checked) {
                            Log.i("Dialog", sound[i])
                        }
                    }
                }
                .setNegativeButton("decline") { dialog, _ ->
                    dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}

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