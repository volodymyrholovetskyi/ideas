package com.vholvetskyi.ideas;

import com.vholvetskyi.ideas.handlers.CategoryCommandHandler;
import com.vholvetskyi.ideas.handlers.CommandHandler;
import com.vholvetskyi.ideas.handlers.HelpCommandHandler;
import com.vholvetskyi.ideas.handlers.QuiteCommandHandler;
import com.vholvetskyi.ideas.input.UserInputCommand;
import com.vholvetskyi.ideas.input.UserInputManager;
import com.vholvetskyi.ideas.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IdeasApplication {
    public static void main(String[] args) {
        new IdeasApplication().start();
    }
    private void start() {
        System.out.println("Start app..");

        boolean applicationLoop = true;

        UserInputManager userInputManager = new UserInputManager();
        List<CommandHandler> handlers = new ArrayList<>();
        handlers.add(new HelpCommandHandler());
        handlers.add(new QuiteCommandHandler());
        handlers.add(new CategoryCommandHandler());

        while (applicationLoop) {
            try {
                UserInputCommand userInputCommand = userInputManager.nextCommand();
                System.out.println(userInputCommand);

                Optional<CommandHandler> currentHandler = Optional.empty();
                for (CommandHandler handler : handlers) {
                    if (handler.supports(userInputCommand.getCommand())) {
                        currentHandler = Optional.of(handler);
                        break;
                    }
                }
                currentHandler
                        .orElseThrow(() -> new IllegalArgumentException("Unknown handler: " + userInputCommand.getCommand()))
                        .handle(userInputCommand);

            } catch (QuiteIdeasApplicationException e) {
                System.out.println("Quite...");
                applicationLoop = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
