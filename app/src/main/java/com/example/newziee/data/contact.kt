package com.example.newziee.data

data class contact(
    val id: Int = 0,
    var name: String,
    var number: String
) {
    override fun equals(other: Any?): Boolean {
        if (other is contact) {
            if (this.name == other.name && this.number == other.number) return true
        }
        return false
    }
}