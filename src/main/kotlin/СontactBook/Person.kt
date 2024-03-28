package main.kotlin.СontactBook

/**
 * Класс Person представляет собой запись о человеке.
 * Этот класс содержит поля:
 *  name – имя человека
 *  phone – номер телефона
 *  email – адрес электронной почты
 */

data class Person (
    private val name: String = "",
    private val phone: MutableList <String> = mutableListOf(),
    private val email: MutableList <String> = mutableListOf()
    ) {


    fun getName(): String {
        return name
    }

    fun getPhone(): MutableList<String>{
        return phone
    }

    fun getMail(): MutableList<String>{
        return email
    }

    fun addEmail(arg: String) {
        email.add(arg)
    }

    fun addPhone(arg: String){
        phone.add(arg)
    }

    private fun jsonPhone(): String{
        var str = "\"phones\": ["

        for (i in phone){
            if (phone.indexOf(i) != phone.size-1) {
                str = "$str\"$i\","
            }else{
                str = "$str\"$i\""
            }
        }
        return "$str]"
    }

    private fun jsonMail(): String{
        var str = "\"emails\": ["


        for (i in email){
            if (email.indexOf(i) != email.size-1){
                str = "$str\"$i\","
            }else{
                str = "$str\"$i\""
            }
        }

        return "$str]"
    }

    override fun toString(): String {
        return "{\"name\": \"$name\", ${jsonPhone()},${jsonMail()}}"
    }
}