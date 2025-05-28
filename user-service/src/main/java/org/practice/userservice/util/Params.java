package org.practice.userservice.util;

import lombok.Getter;

@Getter
public enum Params {

    BEARER_PREFIX("Bearer "),
    USER_NAME("username");

    public final String value;

    Params(String value) {
        this.value = value;
    }


}
