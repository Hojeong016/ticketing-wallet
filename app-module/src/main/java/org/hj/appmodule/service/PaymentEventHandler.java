package org.hj.appmodule.service;

import lombok.RequiredArgsConstructor;
import org.hj.appmodule.dto.response.PaymentEventDto;
import org.hj.coremodule.model.domain.SettlementStatus;
import org.hj.coremodule.model.domain.Wallet;
import org.hj.coremodule.repository.WalletRepository;
import org.hj.coremodule.service.WalletService;
import org.springframework.stereotype.Service;


/**
 * 3/16
 * eventKey를 기반으로 중복 체크를 진행하는 Service 클래스.
 *
 * [프로세스]
 * 1) Redis로 1차 동시성(중복)
 * 2) 새로운 이벤트라면 DB에 PENDING 상태로 엔티티를 영속화 (처리 중 상태 기록)
 * 3) PENDING 엔티티를 기반으로 코어 비즈니스 로직 수행 후 COMPLETED 등 최종 상태를 DB에 반영
 *
 */
@Service
@RequiredArgsConstructor
public class PaymentEventHandler {

    private final WalletRepository walletRepository;
    private final WalletService walletService;

    /**
     * 중복 여부를 확인 합니다.
     * 월렛 entity 생성 합니다.
     * status를 PENDING 으로 변경
     * core 비즈니스 로직으로 해당 엔티티를 넘깁니다.
     */
    public void handleEvent(PaymentEventDto paymentEventDto) {
        // 중복 체크 호출

        //pending 상태 저장 후 model 도메인을 비즈니스 로직으로 넘김
      walletService.processSettlement(
                      Wallet.builder()
                              .orderId(paymentEventDto.getOrderId())
                              .amount(paymentEventDto.getAmount())
                              .settlementStatus(SettlementStatus.PENDING)
                              .build()
      );
    }
}
