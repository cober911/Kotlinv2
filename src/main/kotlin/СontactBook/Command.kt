package main.kotlin.СontactBook

//— В каждом классе иерархии должна быть функция isValid(): Boolean, которая возвращает true, если команда введена
//с корректными аргументами. Проверку телефона и email нужно перенести в эту функцию.


sealed interface Command {
    fun isValid(): Boolean
}

