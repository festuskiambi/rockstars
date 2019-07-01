package com.example.data.datamodels

import com.squareup.moshi.Json

data class ApiRockStar(

	@Json(name="name")
	val name: String,

	@Json(name="about")
	val about: String,

	@Json(name="index")
	val index: Int,

	@Json(name="_id")
	val id: String,

	@Json(name="picture")
	val picture: String
)