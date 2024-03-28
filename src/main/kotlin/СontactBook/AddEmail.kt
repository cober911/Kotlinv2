package main.kotlin.СontactBook

class AddEmail(var email: String): Command {

    override fun isValid(): Boolean {
        return email.matches(Regex("""[_A-Za-z0-9-]+@[_A-Za-z0-9-.]+\.[A-Za-z0-9-.]+"""))
    }
    fun run(person: Person){
        person.addEmail(email)
    }
}