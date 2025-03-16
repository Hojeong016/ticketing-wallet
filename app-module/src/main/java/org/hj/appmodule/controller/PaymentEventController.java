package org.hj.appmodule.controller;

import lombok.RequiredArgsConstructor;
import org.hj.appmodule.dto.response.PaymentEventDto;
import org.hj.appmodule.service.PaymentEventHandler;
import org.hj.commonmodule.response.ApiResponse;
import org.hj.commonmodule.response.ResponseStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * payment 서버에서 이벤트를 받는 리스너 컨트롤러 입니다,
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/wallet/event")
public class PaymentEventController {

    private final PaymentEventHandler paymentEventHandler;

    /**
     * 결제 이벤트 수신 엔드포인트
     * 테스트 용도 : PaymentEvent 처리를 진행
     * 추후 카프카 연동 후 삭제 예정입니다.
     */
    @PostMapping("/payments")
    public ResponseEntity<ApiResponse<Void>> handlePaymentEvent(
            @RequestBody PaymentEventDto paymentEventDto) {

        paymentEventHandler.handleEvent(paymentEventDto);

        return ApiResponse.success(ResponseStatus.SUCCESS);
    }

    // payment server에 이벤트 전달 컨트롤러




}
