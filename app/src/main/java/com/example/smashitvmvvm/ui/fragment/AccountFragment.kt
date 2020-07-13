package com.example.smashitvmvvm.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.smashitvmvvm.R
import com.example.smashitvmvvm.databinding.AccountFragmentBinding
import com.example.smashitvmvvm.ui.base.BaseFragment

class AccountFragment : BaseFragment() {

    lateinit var accountFragmentBinding: AccountFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        accountFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.account_fragment,
            container,
            false
        )
        return accountFragmentBinding.root
    }

    override fun setupViews(view: View) {
        TODO("Not yet implemented")
    }
}