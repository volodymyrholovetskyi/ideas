package ua.vholovetskyi.ideas

import ua.vholovetskyi.ideas.input.UserInputManager

class IdeasApplication {

}

fun main() {
    print("Start app..")

    var applicationLoop: Boolean = true

    var userInputManager = UserInputManager();
    while (true) {
        var userInputCommand = userInputManager.nextCommand()
        userInputManager.nextCommand();
        userInputCommand
    }


}