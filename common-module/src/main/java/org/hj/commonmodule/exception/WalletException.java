package org.hj.commonmodule.exception;

import lombok.Getter;


@Getter
public class WalletException extends  RuntimeException {

    private final ErrorStatus errorStatus;

    public WalletException(ErrorStatus errorStatus) {
        super(errorStatus.getDefaultMessage());
        this.errorStatus = errorStatus;
    }

    // 검증 실패 공동
    public static WalletException validationFailed() {
        return new WalletException(ErrorStatus.VALIDATION_FAILED);
    }
}
