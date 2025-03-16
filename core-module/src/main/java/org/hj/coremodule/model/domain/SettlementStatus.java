package org.hj.coremodule.model.domain;

/**
 * PENDING: 정산을 진행 중인 상태 -- 정산이 시작됨
 * COMPLETED: 정산이 정상적으로 완료된 상태
 * FAILED: 오류 등으로 정산이 실패한 상태
 */
public enum SettlementStatus {
    PENDING,
    COMPLETED,
    FAILED
}
