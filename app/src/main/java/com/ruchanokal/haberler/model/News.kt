package com.ruchanokal.haberler.model

import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class News(
    val category: String,
    val title: String,
    val spot: String,
    val redirects:  Boolean,
    val isAdvertorial: Boolean,
    val publishDate: String,
    val id: Integer,
    val imageUrl: String,
    val videoUrl: String,
    val webUrl: String,
    val commentCount: Integer,
    val imageSize: String,
    val body : List<Body>,
    val related: List<Object>,
    val emoji: Emoji
) : Serializable {


}