package com.example.futurev1

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    var name : String? = null,
    var description : String? = null,
    var iconUrl : String? = null,
    var serviceUrl: String? = null,
)
