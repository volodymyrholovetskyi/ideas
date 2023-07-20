package com.vholvetskyi.ideas.input;

import com.vholvetskyi.ideas.model.Action;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInputCommandTest {

    @Test
    void should_build_correct_user_input_command() {
        //given
        String input = "category add CategoryName";

        //when
        UserInputCommand userInputCommand = new UserInputCommand(input);

        //then
        assertEquals("category", userInputCommand.getCommand());
        assertEquals(Action.ADD, userInputCommand.getAction());
        assertLinesMatch(List.of("CategoryName"), userInputCommand.getParam());
    }

    @Test
    void should_build_correct_user_input_command_with_multiple_params() {
        //given
        String input = "category add param1 param2 param3";

        //when
        UserInputCommand userInputCommand = new UserInputCommand(input);

        //then
        assertEquals("category", userInputCommand.getCommand());
        assertEquals(Action.ADD, userInputCommand.getAction());
        assertLinesMatch(List.of("param1", "param2", "param3"), userInputCommand.getParam());
    }

    @Test
    void should_build_correct_user_input_command_without_params() {
        //given
        String input = "category list";

        //when
        UserInputCommand userInputCommand = new UserInputCommand(input);

        //then
        assertEquals("category", userInputCommand.getCommand());
        assertEquals(Action.LIST, userInputCommand.getAction());
        assertEquals(0, userInputCommand.getParam().size());
    }


}