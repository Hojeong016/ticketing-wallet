package org.hj.inframodule.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hj.coremodule.model.domain.SettlementStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "wallet")
@Getter
@NoArgsConstructor
public class WalletEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wallet_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long paymentId;

    @Column(nullable = false)
    private Long orderId;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private SettlementStatus settlementStatus;

    /**
     * 비즈니스 로직에서 시간 생성
     */
    @Column(nullable = true)
    private LocalDateTime settlementDate;
    /**
     * 로깅용
     */
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;
    /**
     * 로깅용
     */
    @UpdateTimestamp
    @Column(nullable = true)
    private LocalDateTime updatedAt;

    @Builder
    public WalletEntity(Long walletId,Long orderId ,BigDecimal amount, SettlementStatus settlementStatus, LocalDateTime settlementDate) {
        this.id = null;
        this.amount = amount;
        this.settlementStatus = settlementStatus;
        this.settlementDate = settlementDate;
        this.orderId = orderId;
    }
}

