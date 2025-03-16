package org.hj.inframodule.repository;

import lombok.RequiredArgsConstructor;
import org.hj.coremodule.model.domain.Wallet;
import org.hj.coremodule.repository.WalletRepository;
import org.hj.inframodule.domain.WalletEntity;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WalletRepositoryImpl implements WalletRepository {

    private final WalletJpaRepository walletJpaRepository;

    @Override
    public Wallet save(Wallet wallet) {
        WalletEntity entity = toEntity(wallet);
        WalletEntity savedEntity = walletJpaRepository.save(entity);
        return toDomain(savedEntity);
    }

    private Wallet toDomain(WalletEntity entity) {
        return Wallet.builder()
                .walletId(entity.getId())
                .orderId(entity.getOrderId())
                .amount(entity.getAmount())
                .settlementStatus(entity.getSettlementStatus())
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
