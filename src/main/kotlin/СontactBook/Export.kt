package main.kotlin.СontactBook

import main.kotlin.UserDB.Write
import main.kotlin.UserDB.WriteContact
import java.io.File


class Export: Command {
    override fun isValid(): Boolean {
        return true
    }
    class Derived (b: Write) : Write by b

    fun safeText(users: MutableList<Person>) {
        val b = WriteContact()
        for (i in users) {
            Derived(b).writeName(i.getName())
            Derived(b).writePhone(i.getPhone())
            Derived(b).writeEmail(i.getMail())

            File("src/main/kotlin/UserDB/", "usersDB.txt").appendText("\n")
        }
    }

    fun run(users: MutableList<Person>) {
        safeText(users)

        val jsonContent = json {
            "users" to users.map {
                json {
                    "name" to it.getName()
                    "phone" to it.getPhone()
                    "email" to it.getMail()
                }
            }
        }.toString()

        File("src/main/kotlin/UserDB/", "usersDB.json").writeText(jsonContent)
    }
}

// Класс для представления JSON объектов
class JSONObject {
    private val map = mutableMapOf<String, Any?>()

    infix fun String.to(value: Any?) {
        map[this] = value
    }

    override fun toString(): String {
        val jsonString = StringBuilder()
        jsonString.append("{\n")
        map.entries.forEachIndexed { index, entry ->
            val (key, value) = entry
            jsonString.append("\"$key\":")
            when (value) {
                is String -> jsonString.append("\"$value\"")
                is Int, is Long, is Double, is Boolean -> jsonString.append(value)
                is JSONObject -> jsonString.append(value.toString())
                is List<*> -> {
                    val jsonArray = value.joinToString(prefix = "[", postfix = "]", separator = ",")
                    jsonString.append(jsonArray)
                }
            }
            if (index < map.size - 1)
                jsonString.append(",")
            jsonString.append("\n")
        }
        jsonString.append("}")
        return jsonString.toString()
    }
}

// Функция для создания JSON объекта
fun json(init: JSONObject.() -> Unit): JSONObject {
    val jsonObject = JSONObject()
    jsonObject.init()
    return jsonObject
}

