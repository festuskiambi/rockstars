package com.example.rockstars.home.ui


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration

import com.example.rockstars.R
import com.example.rockstars.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()
    lateinit var adapter: RockStarListAdapter


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
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = RockStarListAdapter(viewModel)
        rv_fragment_home.adapter = adapter
        rv_fragment_home.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

    }

    private fun observeViewModel() {
        viewModel.rockStarsList.observe(
            viewLifecycleOwner,
            Observer { rockStarList ->
                adapter.submitList(rockStarList)
            }
        )
    }


}