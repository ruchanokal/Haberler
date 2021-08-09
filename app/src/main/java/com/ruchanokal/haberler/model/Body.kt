package com.ruchanokal.haberler.model

import java.io.Serializable


data class Body (val p: String,
                val h3 : String,
                val image : String,
                val imageSize : String) : Serializable {
}