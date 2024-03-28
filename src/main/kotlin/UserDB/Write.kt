package main.kotlin.UserDB


    interface Write {
        fun writeName(name: String)
        fun writePhone(array: MutableList<String>)
        fun writeEmail(array: MutableList<String>)
    }
