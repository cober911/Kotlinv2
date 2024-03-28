
/*
Написать программу, которая обрабатывает
введённые пользователем в консоль команды:
• exit
• help
• add <Имя> phone <Номер телефона>
• add <Имя> email <Адрес электронной
почты>
После выполнения команды, кроме команды
exit, программа ждёт следующую команду
 */


var users = mutableMapOf<String?, List<String?>>()

fun main() {
    users.put("Ada", arrayListOf("5551234", "ada@example.com"))
    println("Введите help для получения списка команд")
    start()
}

fun start(){
    val input = readlnOrNull()?.lowercase() //чтение из консоли
    when {
        input == "exit" ->  println("Конец программы")
        input == "help" ->  help()
        input == "add" ->  add()
        input == "get" ->  printPhoneBook()
        else ->
        {
            println("Некорректный ввод")
            help()
        }
    }
}

fun help(){
    println("exit для выхода")
    println("add для добавления контакта")
    println("get для получения контактов")
    start()
}

fun add(){
    val name = addName()
    println("Введите phone если хотите добавить номер телефона \nВведите email если хотите добавить почту")
    val input = readlnOrNull()?.lowercase() //чтение из консоли

    when {
        input == "exit"-> println("Выход")
        input == "phone"-> addPhoneBook(name, addPhone())
        input == "email"-> addPhoneBook(name, addEmail())
    }
}

/**
 * Метод возвращает телефонную книгу
 */
fun getPhoneBook(): MutableMap<String?, List<String?>> {
    return users
}

fun printPhoneBook(){
    for (user in users){
        println("")
        println("name: " + user.key)
        for (i in user.value){
            println(i)
        }
    }
}

/**
 * Метод добавляет контакт в телефонную книгу
 * если ктонтакт уже существует то в существующий контакт добавляется новый номер телефона и почта
 */
fun addPhoneBook(name: String?, contact: String?){
    val contacts= arrayListOf(contact)
    for (user in users) {
        if (user.key == name) users[name] = users[name]!! + contacts
        else users.put(name, contacts)
        printPhoneBook()
    }
}

/**
 * Метод проверяет введённое значение пользователем
 * добавляет полученное значение в переменную phone
 */
fun addPhone(): String?{
    println("Введите номер телефона")
    var phone = readlnOrNull()
    while (phone?.matches(Regex("""[0-9+]+""")) == false){
        println("Некорректный ввод номера телефона")
        phone = readlnOrNull()
    }
    return phone
}

// #region: проверка, рефакторинг и добавление имени
fun addName(): String {
    println("Введите имя контакта")
    var name = readLine()

    while (name?.matches(Regex("""[A-Za-z а-яёА-ЯЁ]+""")) == false){
        println("Некорректный ввод имени")
        name = readLine()
    }
    val refactorName = funRefactorName(name)
    return refactorName

}

fun funRefactorName(name: String?): String{
    val refactorName = name?.lowercase()?.trim()
    return buildString {
        append(refactorName?.substring(0, 1)?.toUpperCase())
        append(refactorName?.substring(1, refactorName.length))
    }
}

// #endregion

/**
 * Метод проверяет введённое значение пользователем
 * добавляет полученное значение в переменную email
 */

fun addEmail():String? {
    println("Введите почту")
    var email = readlnOrNull()
    while(email?.matches(Regex("""[_A-Za-z0-9-]+@[_A-Za-z0-9-.]+\.[A-Za-z0-9-.]+""")) == false){
        println("Некорректный ввод")
        email = readlnOrNull()
    }
    return email
}
