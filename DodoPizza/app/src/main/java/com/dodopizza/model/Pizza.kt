package com.dodopizza.model

import java.util.UUID

data class Pizza(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val imageRes: Int,
    val description: String,
    val price: String
)
