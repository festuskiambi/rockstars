package com.example.rockstars.home.ui


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.rockstars.R
import com.example.rockstars.home.viewmodel.HomeViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onStart() {
        super.onStart()
        observeViewModel()
    }

    private fun observeViewModel() {
println("message")
        viewModel.rockStarsList.observe(
            viewLifecycleOwner,
            Observer { rockStarList ->
                Log.d("mess", rockStarList.size.toString())
                println(rockStarList.first())
            }
        )
    }


}
