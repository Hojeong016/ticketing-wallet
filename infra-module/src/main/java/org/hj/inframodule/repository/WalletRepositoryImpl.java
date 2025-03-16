package org.hj.inframodule.repository;

import org.hj.coremodule.model.domain.Wallet;
import org.hj.coremodule.repository.WalletRepository;
import org.hj.inframodule.domain.WalletEntity;


public class WalletRepositoryImpl implements WalletRepository {

    private WalletJpaRepository walletJpaRepository;

    @Override
    public Wallet findById(Long id) {
        return null;
    }

    @Override
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
