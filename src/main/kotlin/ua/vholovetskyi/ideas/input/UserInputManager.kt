package ua.vholovetskyi.ideas.input

import java.util.Scanner

class UserInputManager {

    private val scanner: Scanner = Scanner(System.`in`)

    fun nextCommand(): UserInputCommand {
        return UserInputCommand(scanner.nextLine())
    }
}