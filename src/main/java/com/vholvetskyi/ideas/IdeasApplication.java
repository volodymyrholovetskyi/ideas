package com.vholvetskyi.ideas;

import com.vholvetskyi.ideas.input.UserInputCommand;
import com.vholvetskyi.ideas.input.UserInputManager;

public class IdeasApplication {
    public static void main(String[] args) {
        new IdeasApplication().start();
    }

    private void start() {
        System.out.println("Start app..");

        boolean applicationLoop = true;

        UserInputManager userInputManager = new UserInputManager();

        while (applicationLoop) {
            try {
                UserInputCommand userInputCommand = userInputManager.nextCommand();
                System.out.println(userInputCommand);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
