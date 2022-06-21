package com.ilhamhadisyah.suitmediatest.utils

import android.app.AlertDialog
import android.content.Context

class DialogHelper(private val activity: Context) {

    fun createDialog( title: String, message: String) {
        val builder: AlertDialog.Builder = activity.let {
            AlertDialog.Builder(it)
        }

        builder.setMessage(message)
            .setTitle(title)
            .setPositiveButton("Oke") { dialog, _ ->
                {
                    dialog.dismiss()
                }
            }

        val alert = builder.create()
        alert.show()

    }
}