package com.vvuono.noto.utils.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.toNotoFileTimestamp(): String {
    return SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(this)
}

fun Date.toNotoImageFileName(): String {
    return "noto_${toNotoFileTimestamp()}"
}