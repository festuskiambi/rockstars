package com.example.rockstars.bookmarks.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.rockstars.R
import com.example.rockstars.bookmarks.viewmodel.BookmarkViewModel
import kotlinx.android.synthetic.main.fragment_list_bookmark.*
import org.koin.android.viewmodel.ext.android.viewModel

class ListBookmarkFragment : Fragment() {

    private val viewModel: BookmarkViewModel by viewModel()
    lateinit var adapter: BookmarkListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_bookmark, container, false)
    }

    override fun onStart() {
        super.onStart()
        observeViewModel()
        setupAdapter()
    }

    private fun observeViewModel() {
        viewModel.bookmarkList.observe(
            viewLifecycleOwner,
            Observer { bookmarkList ->
                adapter.submitList(bookmarkList)
            }
        )
    }

    private fun setupAdapter() {
        adapter = BookmarkListAdapter(viewModel)
        rv_fragment_bookmarks.adapter = adapter
        rv_fragment_bookmarks.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }
}
