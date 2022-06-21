package com.ilhamhadisyah.suitmediatest.utils

import android.widget.ImageView
import com.bumptech.glide.Glide


fun String.isPalindrome(): Boolean {
    var i = 0
    var j = this.length - 1

    while (i < j) {
        if (this[i] != this[j]) {
            return false
        }
        i++
        j--
    }
    return true
}

fun ImageView.loadUrl(url:String){
    Glide.with(this).clear(this)
    Glide.with(this).load(url).into(this)
}