package com.example.domain.entity

/**
 * Created by Festus Kiambi on 7/1/19.
 */
sealed class Entity {

    data class RockStar(
        val id: String,
        val index: Int,
        val name: String,
        val picture: String,
        val about: String
    ) : Entity()

    data class User(
        val id: Int,
        val name: String,
        val picture: String
    ) : Entity()
}