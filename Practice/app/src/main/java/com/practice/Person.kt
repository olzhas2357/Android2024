package com.practicebir

import java.io.Serializable

data class Person(
    val firstName: String,
    val lastName: String,
    val phone: String,
    val birthDay: String,
    val login: String,
    val password: String
) : Serializable

