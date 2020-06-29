package com.example.smashitvmvvm.utils

import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.BindingAdapter

class BindingAdapters {
    companion object{
        @JvmStatic @BindingAdapter("onNameChangedListener")
        fun onNameChanged(view : EditText, listener : TextWatcher){
            view.addTextChangedListener(listener)
        }

        @JvmStatic @BindingAdapter("onEmailChangedListener")
        fun onEmailChanged(view : EditText, listener : TextWatcher){
            view.addTextChangedListener(listener)
        }


        @JvmStatic @BindingAdapter("onPasswordTextListener")
        fun onPasswordChanged(view : EditText, listener : TextWatcher){
            view.addTextChangedListener(listener)
        }
    }
}