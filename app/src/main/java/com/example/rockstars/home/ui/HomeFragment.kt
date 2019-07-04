package com.example.rockstars.home.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.rockstars.R
import com.example.rockstars.common.util.NetworkConnectivity
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
        if (NetworkConnectivity(context!!).isConnected()) {
            initView()
        } else {
            Toast.makeText(context, "Check your network connection and retry", Toast.LENGTH_SHORT).show()
        }

    }

    private fun initView() {
        setupAdapter()
        observeViewModel()
        fragment_home_swipe_to_refresh.setOnRefreshListener {
            viewModel.getRockStars()
        }
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
                fragment_home_swipe_to_refresh.isRefreshing = false
                adapter.submitList(rockStarList)
            }
        )
    }


}
