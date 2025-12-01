package com.vvuono.noto.utils.content

import android.content.Context
import android.os.Environment
import com.vvuono.noto.utils.util.toNotoImageFileName
import java.io.File
import java.util.Date

fun Context.createNotoImageFile(): File {
    val filename = Date().toNotoImageFileName()
    val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    return File.createTempFile(filename, ".jpg", storageDir)
}