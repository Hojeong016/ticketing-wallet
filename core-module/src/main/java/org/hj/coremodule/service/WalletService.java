package org.hj.coremodule.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hj.commonmodule.exception.WalletException;
import org.hj.coremodule.model.domain.SettlementStatus;
import org.hj.coremodule.model.domain.Wallet;
import org.hj.coremodule.repository.WalletRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;

    /**
     * 1) Wallet의 상태를 확인 (PENDING인지 검증).
     * 3) 정산 완료 후 Wallet 상태를 COMPLETED로 변경.
     * 4) DB에 최종 결과(상태) 저장.
     */
    @Transactional
    public void processSettlement(Wallet wallet) {

        if (wallet.getSettlementStatus() != SettlementStatus.PENDING) {
            throw WalletException.validationFailed();
        }

        //성공 시
        wallet.completeSettlement();
        walletRepository.save(wallet);

    }
}
