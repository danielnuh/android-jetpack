package com.e.list.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "movie")
@Parcelize
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id:String,

    @ColumnInfo(name = "title")
    var title:String,

    @ColumnInfo(name = "description")
    var description:String,

    @ColumnInfo(name = "date")
    var date:String,

    @ColumnInfo(name = "image")
    var image:String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite:Boolean = false,
):Parcelable
