package com.example.newziee.logic


import com.example.newziee.data.contact


fun String.isNotEmptyAndNotBlank(): Boolean {
    return (this.isNotBlank() && this.isNotEmpty())
}

fun checkAndSaveData(value1: String, value2: String): contact {

    val name = value1.replace(" ", "")
    val number = value2.replace(" ", "")

    return contact(name = name, number = number)

}
