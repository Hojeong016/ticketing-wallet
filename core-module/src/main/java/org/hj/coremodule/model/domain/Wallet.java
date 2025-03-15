package org.hj.coremodule.model.domain;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 순수 자바 객체로 관리
 */
@Getter
public class Wallet {
    private Long id;
    private Long paymentId;
    private Long orderId;
    private BigDecimal amount;
    private String settlementStatus;
    private LocalDateTime settlementDate;

    @Builder
    public Wallet(Long walletId,
                  Long paymentId,
                  Long orderId,
                  BigDecimal amount,
                  String settlementStatus,
                  LocalDateTime settlementDate) {
        this.id = walletId;
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.settlementStatus = settlementStatus;
        this.settlementDate = settlementDate;
    }
}
