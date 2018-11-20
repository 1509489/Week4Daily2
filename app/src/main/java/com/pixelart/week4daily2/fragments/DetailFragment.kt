package com.pixelart.week4daily2.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pixelart.week4daily2.R

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        return view
    }


}
