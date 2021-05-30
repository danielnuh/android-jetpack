package com.e.submission1.data.network.response

import com.google.gson.annotations.SerializedName

data class TvShowDetailResponse(
	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("first_air_date")
	val firstAirDate: String,

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("poster_path")
	val posterPath: String,

	@field:SerializedName("original_name")
	val originalName: String,
)