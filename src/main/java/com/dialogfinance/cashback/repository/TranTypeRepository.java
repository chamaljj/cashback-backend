package com.dialogfinance.cashback.repository;

import com.dialogfinance.cashback.entity.Merchant;
import com.dialogfinance.cashback.entity.TranType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranTypeRepository extends JpaRepository<TranType, Long> {
}
