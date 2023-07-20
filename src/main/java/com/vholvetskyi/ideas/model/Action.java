package com.vholvetskyi.ideas.model;

import java.util.Arrays;
import java.util.Objects;

public enum Action {
    ADD("add"), LIST("list");

    private final String value;
    Action(String value) {
        this.value = value;
    }

    public static Action of(String value) {
        return Arrays.stream(values())
                .filter(a -> Objects.equals(a.value, value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown action: " + value));
    }
}
