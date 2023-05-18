package com.dialogfinance.cashback.repository;

import com.dialogfinance.cashback.entity.Cashback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashbackRepository extends JpaRepository<Cashback, Long> {



}
