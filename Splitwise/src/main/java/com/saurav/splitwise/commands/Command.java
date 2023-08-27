package com.saurav.splitwise.commands;

import com.saurav.splitwise.exception.InvalidCommandException;

public interface Command {

    default void validateAndExecute(String input) throws InvalidCommandException {
        validate(input);
        execute(input);
    }

    void validate(String input) throws InvalidCommandException;

    void execute(String input);


}
