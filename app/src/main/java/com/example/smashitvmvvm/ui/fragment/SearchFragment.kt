package com.example.smashitvmvvm.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.smashitvmvvm.R
import com.example.smashitvmvvm.databinding.SearchFragmentBinding
import com.example.smashitvmvvm.ui.base.BaseFragment
import okhttp3.internal.userAgent

class SearchFragment : BaseFragment() {

    lateinit var searchFragmentBinding: SearchFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.search_fragment,
            container,
            false
        )
        return searchFragmentBinding.root
    }

    override fun setupViews(view: View) {

    }
}