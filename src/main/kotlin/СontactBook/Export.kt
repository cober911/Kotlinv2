package main.kotlin.СontactBook

import main.kotlin.UserDB.Write
import main.kotlin.UserDB.WriteContact
import java.io.File


class Export: Command {
    override fun isValid(): Boolean {
        return true
    }
    class Derived (b: Write) : Write by b

    fun safeText(users:  MutableList<Person>) {
        for (i in users) {
            val b = WriteContact()
            Derived(b).writeName(i.getName())
            Derived(b).writePhone(i.getPhone())
            Derived(b).writeEmail(i.getMail())

            File("src/main/kotlin/UserDB/", "usersDB.txt").appendText("\n")
        }
    }

    fun run(users:  MutableList<Person>){
        safeText(users)
        var text ="[\n"

        for (i in users){
            val user = i.toString()
            if (users.indexOf(i) != users.size-1) {
                text = "$text$user,\n"
            }else{
                text = "$text$user\n]"
            }
        }
        File("src/main/kotlin/UserDB/", "usersDB.json").writeText("")
        File("src/main/kotlin/UserDB/", "usersDB.json").appendText(text)
    }

}