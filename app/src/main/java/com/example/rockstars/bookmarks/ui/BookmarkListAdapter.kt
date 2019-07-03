package com.example.rockstars.bookmarks.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entity.Entity
import com.example.rockstars.R
import com.example.rockstars.bookmarks.viewmodel.BookmarkViewModel
import com.example.rockstars.common.RockstarDiffCallBack
import kotlinx.android.synthetic.main.item_bookmark.view.*

/**
 * Created by Festus Kiambi on 7/3/19.
 */
class BookmarkListAdapter(private val viewModel: BookmarkViewModel) :
    ListAdapter<Entity.RockStar, BookmarkListAdapter.NoteViewHolder>(RockstarDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NoteViewHolder(
            inflater.inflate(R.layout.item_bookmark, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        getItem(position).let { rockStar ->
            holder.name.text = rockStar.name
            holder.status.text = rockStar.about
            Glide.with(holder.picture)
                .load(rockStar.picture)
                .into(holder.picture)
            holder.delete.setOnClickListener {
                viewModel.deleteBookmark(rockStar)
            }
        }
    }

    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val picture: ImageView = view.iv_bookmark_profile
        val name: TextView = view.tv_bookmark_name
        val status: TextView = view.tv_bookmark_status
        val delete: ImageView = view.iv_delete
    }
}
