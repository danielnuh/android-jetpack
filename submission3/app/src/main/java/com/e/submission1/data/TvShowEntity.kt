package com.e.submission1.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class TvShowEntity(
    var id : String,
    var title : String,
    var description : String,
    var date: String,
    var image : String,
):Parcelable