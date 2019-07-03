package com.example.rockstars.home.ui

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
import com.example.rockstars.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.item_rockstar.view.*

/**
 * Created by Festus Kiambi on 7/3/19.
 */
class RockStarListAdapter(private val viewModel: HomeViewModel) :
    ListAdapter<Entity.RockStar, RockStarListAdapter.NoteViewHolder>(RockstarDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NoteViewHolder(
            inflater.inflate(R.layout.item_rockstar, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        getItem(position).let { rockStar ->
            holder.name.text = rockStar.name
            holder.status.text = rockStar.about
            Glide.with(holder.picture)
                .load(rockStar.picture)
                .into(holder.picture)

            holder.favorite.setOnClickListener {
                viewModel.addBookMark(rockStar)
            }
        }
    }

    class NoteViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val picture: ImageView = view.iv_profile
        val name: TextView = view.tv_name
        val status: TextView = view.tv_status
        val favorite: ImageView = view.iv_favorite
    }
}