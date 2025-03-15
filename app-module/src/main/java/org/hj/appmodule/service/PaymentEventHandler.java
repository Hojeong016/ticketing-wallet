package org.hj.appmodule.service;

import lombok.RequiredArgsConstructor;
import org.hj.appmodule.dto.response.PaymentEventDto;
import org.hj.appmodule.reposittory.WalletRepository;
import org.hj.coremodule.model.domain.Wallet;
import org.hj.coremodule.service.WalletService;
import org.springframework.stereotype.Service;


/**
 * eventKey 를 기반으로 중복 체크를 진행하는 service 클래스
 */
@Service
@RequiredArgsConstructor
public class PaymentEventHandler {

    private final WalletRepository walletRepository;
    private final WalletService walletService;

    /**
     * 중복 여부를 확인 합니다.
     * 월렛 entity 생성 합니다.
     * status를 PENDING 으로 save 합니다.
     * core 비즈니스 로직으로 해당 엔티티를 넘깁니다.
     */
    public void handleEvent(PaymentEventDto paymentEventDto) {
      // 중복 체크 호출

        //pendig 상태 저장 후 model 도메인을 비즈니스 로직으로 넘김
      walletService.processSettlement(
              walletRepository.save(
                      Wallet.builder()
                              .orderId(paymentEventDto.getOrderId())
                              .amount(paymentEventDto.getAmount())
                              .settlementStatus("PENDING")
                              .build()
              )
      );
    }
}
