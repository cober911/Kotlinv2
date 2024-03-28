package main.kotlin.СontactBook

class GetContactsBook(val str: String):Command {
    fun run(users: MutableList<Person>){
        if (users.size>0) {
            for (user in users) {
                println(user)
            }
        } else{
            println("Список пуст")
        }
    }
    override fun isValid(): Boolean {
        return if (str == "get") true
        else false
    }
}