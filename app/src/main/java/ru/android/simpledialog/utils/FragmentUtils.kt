package ru.android.simpledialog.utils

import androidx.fragment.app.FragmentActivity
import ru.android.simpledialog.dialog_class.*

fun FragmentActivity.showDialogOneButton() {
    val dialog = DialogWarningOneButton()
    val manager = supportFragmentManager
    dialog.show(manager, "dialogOne")
}

fun FragmentActivity.showDialogTwoButton() {
    val dialog = DialogWarningTwoButton()
    val manager = supportFragmentManager
    dialog.show(manager, "dialogTwo")
}

fun FragmentActivity.showDialogThreeButton() {
    val dialog = DialogWarningThreeButton()
    val manager = supportFragmentManager
    dialog.show(manager, "dialogThree")
}

fun FragmentActivity.showDialogList() {
    val dialog = DialogList()
    val manager = supportFragmentManager
    dialog.show(manager, "dialogList")
}

fun FragmentActivity.showDialogListSwitch() {
    val dialog = DialogListSwitch()
    val manager = supportFragmentManager
    dialog.show(manager, "dialogListSwitch")
}

fun FragmentActivity.showDialogListChoice() {
    val dialog = DialogListChoice()
    val manager = supportFragmentManager
    dialog.show(manager, "dialogListChoice")
}

fun FragmentActivity.showDialogAutomaticClosing() {
    val dialog = DialogAutomaticClosing()
    val manager = supportFragmentManager
    dialog.show(manager, "dialogAutomaticClosing")
}

fun FragmentActivity.showDialogRating() {
    val dialog = DialogRating()
    val manager = supportFragmentManager
    dialog.show(manager, "dialogConnection")
}

fun FragmentActivity.showDialogConnection() {
    val dialog = DialogConnectionActivity()
    val manager = supportFragmentManager
    dialog.show(manager, "dialogConnection")
}