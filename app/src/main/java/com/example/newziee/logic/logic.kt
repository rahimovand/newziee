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

fun replacerFunction(value1: String, value2: String, contact: contact): Boolean {
    if (value1 == contact.name && value2 == contact.number) {
        return false
    }
    if (value1.isEmpty() || value2.isEmpty()) {
        return false
    } else {
        return true
    }
}