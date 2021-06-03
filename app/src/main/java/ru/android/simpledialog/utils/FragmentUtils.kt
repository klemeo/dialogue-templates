package ru.android.simpledialog.utils

import androidx.fragment.app.Fragment
import ru.android.simpledialog.dialog_class.*

fun Fragment.showDialogOneButton() {
    val dialog = DialogWarningOneButton()
    val manager = childFragmentManager
    dialog.show(manager, "dialogOne")
}

fun Fragment.showDialogTwoButton() {
    val dialog = DialogWarningTwoButton()
    val manager = childFragmentManager
    dialog.show(manager, "dialogTwo")
}

fun Fragment.showDialogThreeButton() {
    val dialog = DialogWarningThreeButton()
    val manager = childFragmentManager
    dialog.show(manager, "dialogThree")
}

fun Fragment.showDialogList() {
    val dialog = DialogList()
    val manager = childFragmentManager
    dialog.show(manager, "dialogList")
}

fun Fragment.showDialogListSwitch() {
    val dialog = DialogListSwitch()
    val manager = childFragmentManager
    dialog.show(manager, "dialogListSwitch")
}

fun Fragment.showDialogListChoice() {
    val dialog = DialogListChoice()
    val manager = childFragmentManager
    dialog.show(manager, "dialogListChoice")
}

fun Fragment.showDialogAutomaticClosing() {
    val dialog = DialogAutomaticClosing()
    val manager = childFragmentManager
    dialog.show(manager, "dialogAutomaticClosing")
}

fun Fragment.showDialogRating() {
    val dialog = DialogRating()
    val manager = childFragmentManager
    dialog.show(manager, "dialogConnection")
}

fun Fragment.showDialogConnection() {
    val dialog = DialogConnectionActivity()
    val manager = childFragmentManager
    dialog.show(manager, "dialogConnection")
}