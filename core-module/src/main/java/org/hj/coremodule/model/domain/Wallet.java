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
    private Long orderId;
    private BigDecimal amount;
    private SettlementStatus settlementStatus;
    private LocalDateTime settlementDate;
    private LocalDateTime failedDate;


    public void completeSettlement(){
        this.settlementStatus = SettlementStatus.COMPLETED;
        this.settlementDate = LocalDateTime.now();

        // 이벤트 발송?>>>
    }

    public void failedSettlement(){
        this.settlementStatus =SettlementStatus.FAILED;
        this.failedDate = LocalDateTime.now();
    }

    @Builder
    public Wallet(Long walletId,
                  Long orderId,
                  BigDecimal amount,
                  SettlementStatus settlementStatus) {
        this.id = walletId;
        this.orderId = orderId;
        this.amount = amount;
        this.settlementStatus = settlementStatus;
    }

}
