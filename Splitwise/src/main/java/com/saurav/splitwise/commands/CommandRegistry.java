package com.saurav.splitwise.commands;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandRegistry {

    private Map<String, Command> map;

    private CommandRegistry(){
        map = new HashMap<>();
    }

    private static CommandRegistry INSTANCE = new CommandRegistry();

    public static CommandRegistry getInstance(){
        return INSTANCE;
    }

    public void register(String commandName,Command command){
        map.put(commandName,command);
    }

    public Optional<Command> getCommand(String commandName){
        if(!StringUtils.hasLength(commandName) ) {
            return Optional.empty();
        }
        if(map.containsKey(commandName)){
            return Optional.of(map.get(commandName));
        }
        return Optional.empty();

    }
}
