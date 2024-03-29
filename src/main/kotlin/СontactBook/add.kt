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
            // Если пользователь существует, выводим сообщение об ошибке
            println("Пользователь с таким именем уже существует.")
        } else {
            // Если пользователь не существует, добавляем нового пользователя
            book.addUser(newUser)

            // Запрашиваем номер телефона
            val phone = addPhone()
            newUser.addPhone(phone)

            // Запрашиваем адрес электронной почты
            val email = addEmail()
            newUser.addEmail(email)

            println("Контакт успешно добавлен.")
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

    private fun addPhone(): String {
        println("Введите номер телефона начиная с 8")
        var phone = readln()
        while (!phone.matches(Regex("""\d+"""))) {
            println("Некорректный ввод номера телефона")
            phone = readln()
        }
        return phone
    }

    private fun addEmail(): String {
        println("Введите адрес электронной почты")
        var email = readln()
        while (!email.matches(Regex("""[_A-Za-z0-9-]+@[_A-Za-z0-9-.]+\.[A-Za-z0-9-.]+"""))) {
            println("Некорректный ввод адреса электронной почты")
            email = readln()
        }
        return email
    }
}
