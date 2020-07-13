package com.example.smashitvmvvm.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.smashitvmvvm.R
import com.example.smashitvmvvm.databinding.SearchFragmentBinding
import com.example.smashitvmvvm.databinding.SettingsFrargmentBinding
import com.example.smashitvmvvm.ui.base.BaseFragment

class SettingsFragment : BaseFragment() {
    lateinit var settingsFragmentBinding: SettingsFrargmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingsFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.settings_frargment,
            container,
            false
        )
        return settingsFragmentBinding.root
    }

    override fun setupViews(view: View) {

    }
}