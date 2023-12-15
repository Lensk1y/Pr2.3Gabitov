fun main(args: Array<String>) {
    val alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
    println("Введите текст для шифровки/дешифровки:")
    val text = readLine()!!.toLowerCase()
    println("Введите ключевое слово:")
    val keyword = readLine()!!.toLowerCase()

    println("Зашифровать или расшифровать? (з/р)")
    when (readLine()!!.toLowerCase()) {
        "з" -> {
            val encryptedText = encrypt(text, keyword, alphabet)
            println("Зашифрованный текст: $encryptedText")
        }
        "р" -> {
            val decryptedText = decrypt(text, keyword, alphabet)
            println("Расшифрованный текст: $decryptedText")
        }
        else -> println("Некорректный ввод")
    }
}

fun encrypt(text: String, keyword: String, alphabet: String): String {
    var result = ""
    var keywordIndex = 0
    for (char in text) {
        if (char in alphabet) {
            val shift = alphabet.indexOf(keyword[keywordIndex % keyword.length]) + 1
            val newIndex = (alphabet.indexOf(char) + shift) % alphabet.length
            result += alphabet[newIndex]
            keywordIndex++
        } else {
            result += char
        }
    }
    return result
}

fun decrypt(text: String, keyword: String, alphabet: String): String {
    var result = ""
    var keywordIndex = 0
    for (char in text) {
        if (char in alphabet) {
            val shift = alphabet.indexOf(keyword[keywordIndex % keyword.length]) + 1
            val newIndex = (alphabet.indexOf(char) - shift + alphabet.length) % alphabet.length
            result += alphabet[newIndex]
            keywordIndex++
        } else {
            result += char
        }
    }
    return result
}