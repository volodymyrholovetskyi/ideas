package com.vholvetskyi.ideas.model;

import java.util.Objects;

public enum Action {
    ADD("add"), LIST("list");

    private final String value;
    Action(String value) {
        this.value = value;
    }

    public static Action of(String value) {
        for (Action action : values()) {
            if (Objects.equals(action.value, value)) {
                return action;
            }
        }
        throw new IllegalArgumentException("Unknown action: " + value);
    }
}
