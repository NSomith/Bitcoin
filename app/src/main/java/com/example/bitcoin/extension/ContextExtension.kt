package com.example.bitcoin.extension

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

fun Context.getCompatColor(@ColorRes res:Int) =ContextCompat.getColor(this,res)

fun Context.getCompatDrawable(@DrawableRes res:Int) =ContextCompat.getDrawable(this,res)