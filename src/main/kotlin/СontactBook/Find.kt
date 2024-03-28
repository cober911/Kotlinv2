package main.kotlin.СontactBook

class Find: Command {
    override fun isValid(): Boolean {
        return true
    }

    fun run(users: MutableList<Person>){
        println("Введите номер телефона или почту для поиска имени Контакта")
        val input = readln()
        for (user in users){
           if (user.getPhone().contains(input) == true || user.getMail().contains(input) == true){
               println(user)
           }
        }
    }
}