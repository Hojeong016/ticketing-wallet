package org.hj.coremodule.model.domain;

import lombok.AccessLevel;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 순수 자바 객체로 관리
 */
public class Wallet {

    private Long id;
    private Long paymentId;
    private Long orderId;
    private BigDecimal amount;

    @Setter(AccessLevel.PRIVATE)
    private String settlementStatus;
    private LocalDateTime settlementDate;

}
