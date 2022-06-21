package com.ilhamhadisyah.suitmediatest.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Response(

    @field:SerializedName("per_page")
    val perPage: Int? = null,

    @field:SerializedName("total")
    val total: Int? = null,

    @field:SerializedName("data")
    val data: List<GuestModel>? = null,

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null,

    @field:SerializedName("support")
    val support: Support? = null
) : Parcelable

@Parcelize
data class Support(

    @field:SerializedName("text")
    val text: String? = null,

    @field:SerializedName("url")
    val url: String? = null
) : Parcelable

@Parcelize
@Entity(tableName = "guest")
data class GuestModel(

    @field:SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: Int? = null,

    @field:SerializedName("last_name")
    @ColumnInfo(name = "last_name")
    val lastName: String? = null,

    @field:SerializedName("avatar")
    @ColumnInfo(name = "avatar")
    val avatar: String? = null,

    @field:SerializedName("first_name")
    @ColumnInfo(name = "first_name")
    val firstName: String? = null,

    @field:SerializedName("email")
    @ColumnInfo(name = "email")
    val email: String? = null
) : Parcelable
