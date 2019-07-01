package com.example.data.datamodels

import com.squareup.moshi.Json

data class ApiRockStar(

	@Json(name="name")
	val name: String? = null,

	@Json(name="about")
	val about: String? = null,

	@Json(name="index")
	val index: Int? = null,

	@Json(name="_id")
	val id: String? = null,

	@Json(name="picture")
	val picture: String? = null
)