package com.example.rockstars.common

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.entity.Entity

/**
 * Created by Festus Kiambi on 7/3/19.
 */

class RockstarDiffCallBack : DiffUtil.ItemCallback<Entity.RockStar>(){
    override fun areItemsTheSame(oldItem: Entity.RockStar, newItem: Entity.RockStar): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Entity.RockStar, newItem: Entity.RockStar): Boolean {
        return oldItem.id == newItem.id
    }

}