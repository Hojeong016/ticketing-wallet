package org.hj.appmodule.reposittory;

import lombok.RequiredArgsConstructor;
import org.hj.coremodule.model.domain.Wallet;
import org.hj.inframodule.domain.WalletEntity;
import org.hj.inframodule.repository.WalletJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *  사용자의 Wallet 정보를 가져와 "정산 시작"으로 변경 후 core로 전달하기 위해
 */
@Repository
@RequiredArgsConstructor
public class WalletRepository {

    private final WalletJpaRepository walletJpaRepository;


    public Wallet save(Wallet wallet) {
        WalletEntity entity = toEntity(wallet);
        WalletEntity savedEntity = walletJpaRepository.save(entity);
        return toDomain(savedEntity);
    }

    private Wallet toDomain(WalletEntity entity) {
        return Wallet.builder()
                .walletId(entity.getId())
                .paymentId(entity.getPaymentId())
                .orderId(entity.getOrderId())
                .amount(entity.getAmount())
                .settlementStatus(entity.getSettlementStatus())
                .settlementDate(entity.getSettlementDate())
                .build();
    }

    private WalletEntity toEntity(Wallet wallet) {
        return WalletEntity.builder()
                .walletId(wallet.getId())
                .orderId(wallet.getOrderId())
                .amount(wallet.getAmount())
                .settlementStatus(wallet.getSettlementStatus())
                .settlementDate(wallet.getSettlementDate())
                .build();
    }


}
