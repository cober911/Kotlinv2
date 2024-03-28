package main.kotlin.СontactBook

class Help: Command {
    override fun isValid(): Boolean {
        return true
    }
    fun run() {
        println("exit для выхода")
        println("add для добавления контакта")
        println("get для получения контактов")
        println("show для получения контакта по имени")
        println("find для поиска контакта по номеру телефона или почте")
        println("export для сохранения контактов в базу данных")
    }
}