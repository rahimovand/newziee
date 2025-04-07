package com.example.newziee.logic

fun String.isNotEmptyAndNotBlank(): Boolean {
   return (this.isNotBlank() && this.isNotEmpty())
}

/*
2 ta String qabul qilsin
agar bo'sh joyi mavjud bo'lsa
ortga qaytsin va bo'sh joy mavjud
joy qizil qilib qilib ko'rsatilsin
agar bo'lmasa listdan ma'lumotlar olib kelinsin birhillik tekshirilsin
mobodo bir hil bo'lmasa
listlarga saqlanib olinsin
hamda zudlik bilan ekranda ko'rsatilsin
yo'qsa yana bir bor qizil ko'rsatilsin + toast ekranda chiqarilsin
 */

fun myChecker(
    value1: String,
    value2: String,
    checkerName: (Boolean) -> Unit,
    checkerNumber: (Boolean) -> Unit
    ) {

}
