package main.kotlin.СontactBook

class Add : Command {

    override fun isValid(): Boolean {
        return true
    }

    fun run(book: ContactsBook) {
        val users = book.getUsers()

        val name = addName()

        // Создаем нового пользователя с введенным именем
        val newUser = addNewPerson(name)

        // Проверяем, существует ли пользователь с таким именем
        val existingUser = users.find { it.getName() == name }

        if (existingUser != null) {
            // Если пользователь существует, обновляем его данные
            updatePerson(existingUser, book)
        } else {
            // Если пользователь не существует, добавляем нового пользователя
            book.addUser(newUser)

            // Запрашиваем у пользователя телефоны и адреса электронной почты
            updatePerson(newUser, book)
        }
    }
}

private fun updatePerson(user: Person, book: ContactsBook) {
    println("Введите phone если хотите добавить номер телефона \nВведите email если хотите добавить почту")
    val reader = book.readCommand()

    when (reader) {
        is AddPhone -> {
            if (reader.isValid()) {
                reader.run(user)
            } else {
                println("Некорректный ввод: должны только числа")
            }
        }

        is AddEmail -> {
            if (reader.isValid()){
                reader.run(user)
            }else{
                println("Некорректный ввод: пример mail@mail.ru")
            }
        }

        is Exit -> {}

        else -> {
            println("Ошибка ввода. попробуйте еще раз или введите exit для выхода")
        }
    }
}

private fun addNewPerson(name: String): Person {
    return Person(name)
}

private fun addName(): String {
    println("Введите имя контакта")
    var name = readln()
    while (!name.matches(Regex("""[A-Za-z а-яёА-ЯЁ]+"""))) {
        println("Некорректный ввод имени")
        name = readln()
    }
    val refactorName = funRefactorName(name)
    return refactorName
}

private fun funRefactorName(name: String): String {
    val refactorName = name.trim().replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    return refactorName
}
