package com.vholvetskyi.ideas;

import com.vholvetskyi.ideas.input.UserInputCommand;

public interface CommandHandler {

    void handle(UserInputCommand command);

    boolean supports(String name);
}
