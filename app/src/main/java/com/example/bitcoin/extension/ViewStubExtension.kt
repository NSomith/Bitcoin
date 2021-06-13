package com.example.bitcoin.extension

import android.view.ViewStub
import com.example.bitcoin.ui.LayoutViewState

fun ViewStub.inflate(layoutViewState: Boolean) {
    if (layoutViewState) {
        inflate()
    }
}