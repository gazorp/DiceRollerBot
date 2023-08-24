package com.github.diceroller.encryption

class VigenereEncryptor(private val key: String) : Encryptor {

    override fun encrypt(text: String): String {
        return text.mapIndexed { i, char ->
            val keyChar = key[i % (key.length - 1)]

            when (val mappedChar = abcMap[char]) {
                null -> char
                else -> abc[(mappedChar + abcMap[keyChar]!!) % abcMap.size]
            }
        }.joinToString("")
    }

    override fun decrypt(text: String): String {
        return text.mapIndexed { i, char ->
            val keyChar = key[i % (key.length - 1)]

            when (val alpha = abcMap[char]) {
                null -> char
                else -> abc[(alpha - abcMap[keyChar]!! + abcMap.size) % abcMap.size]
            }
        }.joinToString("")
    }

    companion object {
        private const val abc =
            "абвгдежзийклмнопрстуфхцчшщъыьэюя" +
                "АБВГДЕЁЗЖИКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
                "abcdefghijklmnopqrstuvwxyz" +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "1234567890" +
                "./ -:&,"
        private val abcMap = abc.mapIndexed { i, c -> c to i }.toMap()
    }
}