package main.kotlin.СontactBook

/*
— Создайте иерархию sealed классов, которые представляют собой команды. В корне иерархии интерфейс Command.

— Функция main должна выглядеть следующем образом. Для каждой команды от пользователя:
Читаем команду с помощью функции readCommand
Выводим на экран получившийся экземпляр Command
Если isValid для команды возвращает false, выводим help. Если true, обрабатываем команду внутри when.

 */

fun main() {
    val book = ContactsBook()
    book.addUser(Person("bob", mutableListOf("1234"), mutableListOf("mail@mail.ru")))
    book.addUser(Person("lisa", mutableListOf("2345")))
    book.addUser(Person("Baki", mutableListOf(), mutableListOf("mail@gmail.com")))

    var status = true
    while (status) {
        val reader = book.readCommand()
        when (reader) {
            is Help -> {
                reader.run()
            }

            is GetContactsBook -> {
                reader.run(book.getUsers())
            }

            is Add -> {
                reader.run(book)
            }

            is Show -> {
                reader.run()
            }

            is Find -> {
                reader.run(book.getUsers())
            }

            is Export -> {
                reader.run(book.getUsers())
            }

            is Exit -> {
                status = false
            }

            else -> {
                println("Ошибка ввода")
            }
        }

    }
}