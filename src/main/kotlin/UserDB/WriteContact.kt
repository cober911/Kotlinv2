package main.kotlin.UserDB


import java.io.File

class WriteContact : Write {
    val filesDir = "src/main/kotlin/UserDB/"
    override fun writeName(name: String) {
        val text = "User: $name\n"
        File(filesDir, "usersDB.txt").appendText(text)
    }

    override fun writePhone(array: MutableList<String>) {
        for (i in array) {
            val text = "Phone: $i\n"
            File(filesDir, "usersDB.txt").appendText(text)
        }
    }

    override fun writeEmail(array: MutableList<String>) {
        for (i in array) {
            val text = "eMail: $i\n"
            File(filesDir, "usersDB.txt").appendText(text)
        }
    }
}
