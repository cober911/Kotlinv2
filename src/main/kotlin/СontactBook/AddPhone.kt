package main.kotlin.СontactBook

class AddPhone(var phone: String ):Command {
    override fun isValid(): Boolean {

        return phone.matches(Regex("""[0-9+]+"""))
    }
    fun run(person: Person){
        person.addPhone(phone)
    }
}