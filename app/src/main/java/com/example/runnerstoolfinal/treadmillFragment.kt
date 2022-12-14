package com.example.runnerstoolfinal

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.TextUtils.split
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_treadmill.*
import android.widget.Toast

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
        treadCalculate.setOnClickListener {
            val minutes = R.id.editMinutes
            val seconds = R.id.editSeconds
            val total = 3600 / (minutes*60 + seconds)

            mph.visibility = View.VISIBLE
            mph.setText(total)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TreadmillViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



}