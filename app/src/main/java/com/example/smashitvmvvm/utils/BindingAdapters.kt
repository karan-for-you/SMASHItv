package com.example.smashitvmvvm.utils

import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.BindingAdapter
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

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

        @JvmStatic @BindingAdapter("onBottomMenuItemChanged")
        fun onMenuItemChanged(view : BottomNavigationView, listener : BottomNavigationView.OnNavigationItemSelectedListener){
            view.setOnNavigationItemSelectedListener(listener)
        }
    }
}