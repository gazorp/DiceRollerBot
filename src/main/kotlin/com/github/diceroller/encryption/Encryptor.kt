package com.github.diceroller.encryption

interface Encryptor {

    fun encrypt(text: String): String

    fun decrypt(text: String): String
}