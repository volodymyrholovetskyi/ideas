package com.vholvetskyi.ideas.handlers;

import com.vholvetskyi.ideas.input.UserInputCommand;

public interface CommandHandler {

    void handle(UserInputCommand command);

    boolean supports(String name);
}
