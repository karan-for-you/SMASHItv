package com.example.smashitvmvvm.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.smashitvmvvm.R
import com.example.smashitvmvvm.databinding.HomeHolderFragmentBinding
import com.example.smashitvmvvm.ui.base.BaseFragment

class HomeFragment : BaseFragment() {

    lateinit var homeHolderFragmentBinding: HomeHolderFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeHolderFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )
        return homeHolderFragmentBinding.root
    }

    override fun setupViews(view: View) {

    }
}