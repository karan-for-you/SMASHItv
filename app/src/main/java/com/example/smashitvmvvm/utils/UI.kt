package com.example.smashitvmvvm.utils

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.smashitvmvvm.R
import com.bumptech.glide.Glide
import java.lang.reflect.Field


/**
 * Created by karanjeet on 22/10/19
 */
class UI {

    companion object {
        fun showToast(message: String, context: Context, customFlag: Boolean): Toast? {
            val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
            return toast
        }

        fun showToast(@StringRes resId: Int, context: Context, customFlag: Boolean): Toast? {
            val toast = Toast.makeText(context, resId, Toast.LENGTH_SHORT)
            return toast
        }

        fun showLongToast(message: String, context: Context, customFlag: Boolean): Toast? {
            val toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
            return toast
        }

        fun showLongToast(@StringRes resId: Int, context: Context, customFlag: Boolean): Toast? {
            val toast = Toast.makeText(context, resId, Toast.LENGTH_LONG)
            return toast
        }

        fun hideSoftKeyboard(activity: Activity) {
            var view = activity.currentFocus
            if (view == null) view = View(activity)
            val im = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            im.hideSoftInputFromWindow(view.windowToken, 0)
        }

        fun showSoftKeyboard(activity: Activity) {
            var view = activity.currentFocus
            if (view == null) view = View(activity)
            val im = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            im.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }


        fun showProgressBar(context: Context): AlertDialog {
            val builder = AlertDialog.Builder(context)
            val dialog = builder.create()
            val dialogLayout: View =
                LayoutInflater.from(context).inflate(R.layout.progress_layout, null)
            dialog.setView(dialogLayout)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(false)
            dialog.setCanceledOnTouchOutside(false)
            return dialog
        }

        fun showProgressBar(context: Context, text: String): AlertDialog {
            val builder = AlertDialog.Builder(context)
            val dialog = builder.create()
            val dialogLayout: View =
                LayoutInflater.from(context).inflate(R.layout.progress_layout, null)
            val text1 = dialogLayout.findViewById(R.id.loading_msg) as TextView
            text1.text = text
            dialog.setView(dialogLayout)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(false)
            dialog.setCanceledOnTouchOutside(false)
            return dialog
        }

        fun showProgressBar(context: Context, resId: Int): AlertDialog {
            val builder = AlertDialog.Builder(context)
            val dialog = builder.create()
            val dialogLayout: View =
                LayoutInflater.from(context).inflate(R.layout.progress_layout, null)
            val text1 = dialogLayout.findViewById(R.id.loading_msg) as TextView
            text1.text = context.getString(resId)
            dialog.setView(dialogLayout)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(false)
            dialog.setCanceledOnTouchOutside(false)
            return dialog
        }

        fun showSmashiProgressBar(context: Context): AlertDialog {
            val builder = AlertDialog.Builder(context)
            val dialog = builder.create()
            val dialogLayout: View =
                LayoutInflater.from(context).inflate(R.layout.hammer_layout, null)
            val smashiLoader: ImageView = dialogLayout.findViewById(R.id.ivHammerLoader)
            Glide.with(context).asGif().load(R.drawable.mallet_spinning)
                .into(smashiLoader)
            dialog.setView(dialogLayout)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(false)
            dialog.setCanceledOnTouchOutside(false)
            return dialog
        }

        fun showSmashiProgressBar(context: Context, text: String): AlertDialog {
            val builder = AlertDialog.Builder(context)
            val dialog = builder.create()
            val dialogLayout: View =
                LayoutInflater.from(context).inflate(R.layout.hammer_layout, null)
            val smashiLoader: ImageView = dialogLayout.findViewById(R.id.ivHammerLoader)
            Glide.with(context).asGif().load(R.drawable.mallet_spinning)
                .into(smashiLoader)
            //val text1 : TextView = dialogLayout.findViewById(R.id.loading_msg)
            //text1.text = text
            dialog.setView(dialogLayout)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(false)
            dialog.setCanceledOnTouchOutside(false)
            return dialog
        }

        fun showSmashiProgressBar(context: Context, resId: Int): AlertDialog {
            val builder = AlertDialog.Builder(context)
            val dialog = builder.create()
            val dialogLayout: View =
                LayoutInflater.from(context).inflate(R.layout.hammer_layout, null)
            val smashiLoader: ImageView = dialogLayout.findViewById(R.id.ivHammerLoader)
            Glide.with(context).asGif().load(R.drawable.mallet_spinning)
                .into(smashiLoader)
            //val text1 = dialogLayout.findViewById(R.id.loading_msg) as TextView
            //text1.text = context.getString(resId)
            dialog.setView(dialogLayout)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(false)
            dialog.setCanceledOnTouchOutside(false)
            return dialog
        }

        fun setMarqueeSpeed(textView: TextView, speed: Float, isSpeedMultiplier: Boolean) {
            try {
                val f: Field = textView::class.java.getDeclaredField("mMarquee")
                f.isAccessible = true
                val marquee: Any = f.get(textView)!!
                val mf: Field = marquee.javaClass.getDeclaredField("mScrollUnit")
                mf.isAccessible = true
                var newSpeed = speed
                if (isSpeedMultiplier) {
                    newSpeed = mf.getFloat(marquee) * speed
                }
                mf.setFloat(marquee, newSpeed)
                Logger.logDebug(
                    UI::class.java.simpleName,
                    "$textView marquee speed set to $newSpeed"
                )
            } catch (e: Exception) { // ignore, not implemented in current API level
            }
        }

    }

}