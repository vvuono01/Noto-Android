package com.vvuono.noto.utils.lifecycle

import androidx.lifecycle.MutableLiveData

fun MutableLiveData<Unit>.emit() {
    this.value = Unit
}
