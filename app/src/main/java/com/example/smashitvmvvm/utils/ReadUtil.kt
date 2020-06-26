package com.example.smashitvmvvm.utils


import android.content.Context
import com.example.smashitvmvvm.R
import java.io.IOException
import java.io.InputStream


class ReadUtil {
    fun readJSONData(context: Context): String? {
        val inputStream: InputStream = context.resources.openRawResource(
            0)
        val byteArrayOutputStream: org.apache.commons.io.output.ByteArrayOutputStream =
            org.apache.commons.io.output.ByteArrayOutputStream()
        var i: Int
        try {
            i = inputStream.read()
            while (i != -1) {
                byteArrayOutputStream.write(i)
                i = inputStream.read()
            }
            inputStream.close()
        } catch (e: IOException) {
            Logger.logError(
                ReadUtil::class.java.simpleName,
                e.message!!
            )
        }
        return byteArrayOutputStream.toString()
    }
}