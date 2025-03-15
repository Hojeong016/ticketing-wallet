package org.hj.commonmodule.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseStatus {
    SUCCESS(HttpStatus.OK,"성공했습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
