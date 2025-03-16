package org.hj.commonmodule.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorStatus {

    VALIDATION_FAILED("VALIDATION_FAILED","Validation failed");

    private final String code;
    private final String defaultMessage;
}
