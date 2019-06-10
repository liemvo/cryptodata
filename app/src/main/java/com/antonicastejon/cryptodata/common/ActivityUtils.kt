package com.antonicastejon.cryptodata.common

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.replaceFragment(@IdRes where: Int, fragment: androidx.fragment.app.Fragment, tag: String) {
    supportFragmentManager.beginTransaction()
            .replace(where, fragment, tag)
            .commit()
}