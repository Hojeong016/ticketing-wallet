package org.hj.inframodule.repository;

import org.hj.inframodule.domain.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 3/16
 */
@Repository
public interface WalletJpaRepository extends JpaRepository<WalletEntity, Long> {


}
