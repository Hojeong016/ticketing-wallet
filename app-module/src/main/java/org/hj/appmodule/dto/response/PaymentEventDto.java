package org.hj.appmodule.dto.response;

import lombok.Getter;

import java.math.BigDecimal;


/**
 * 결제 이벤트를 전달받기 위한 DTO 클래스
 *
 * 멱등성 키 : orderId
 * orderId를 기준으로 중복 여부를 확인할 예정입니다.
 */
@Getter
public class PaymentEventDto {

    private Long orderId;
    private BigDecimal amount;

}
