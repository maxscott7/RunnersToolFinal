package com.example.runnerstoolfinal

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class treadmillFragment : Fragment() {

    companion object {
        fun newInstance() = treadmillFragment()
    }

    private lateinit var viewModel: TreadmillViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_treadmill, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TreadmillViewModel::class.java)
        // TODO: Use the ViewModel
    }

}