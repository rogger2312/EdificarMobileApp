package com.example.edifikarmobileapp.service

import android.content.Context
import android.content.DialogInterface
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.os.Handler
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.SeekBar
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.LinkedHashMap
import android.net.Uri
import android.util.TypedValue
import java.text.ParseException

object Helper {

    val TAG = Helper::class.java.simpleName

    fun isOnline(): Boolean {
        try {
            val timeoutMs = 5000
            val sock = Socket()
            val sockaddr = InetSocketAddress("8.8.8.8", 53)
            sock.connect(sockaddr, timeoutMs)
            sock.close()

            return true
        } catch (e: IOException) {
            return false
        }
    }

    fun getBitmap(context: Context, drawable: Int, width: Int, height: Int): Bitmap {
        val icon = BitmapFactory.decodeResource(context.resources, drawable)
        return Bitmap.createScaledBitmap(icon, width, height, false)
    }

    fun getMarkerBitmap(context: Context, drawable: Int): Bitmap {
        val icon = BitmapFactory.decodeResource(context.resources, drawable)
        return Bitmap.createScaledBitmap(icon, 100, 100, false)
    }

    fun bitMapToBase64(bitmap: Bitmap): String {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos)
        val b = baos.toByteArray()
        return Base64.encodeToString(b, Base64.DEFAULT)
    }


}

