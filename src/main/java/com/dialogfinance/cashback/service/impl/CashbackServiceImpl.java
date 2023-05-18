package com.dialogfinance.cashback.service.impl;

import com.dialogfinance.cashback.entity.Cashback;
import com.dialogfinance.cashback.entity.Customer;
import com.dialogfinance.cashback.repository.CashbackRepository;
import com.dialogfinance.cashback.repository.UserRepository;
import com.dialogfinance.cashback.requests.CashbackRequest;
import com.dialogfinance.cashback.requests.CustomerRequest;
import com.dialogfinance.cashback.service.CashbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CashbackServiceImpl implements CashbackService {


    private final CashbackRepository cashbackRepository;


    public CashbackServiceImpl(CashbackRepository cashbackRepository) {
        this.cashbackRepository = cashbackRepository;
    }

    @Override
    public List<Cashback> findAllCashback() {
        return cashbackRepository.findAll();
    }

    @Override
    public Cashback findCashbackById(Long id) {
        cashbackRepository.findById(id).isPresent();
           return cashbackRepository.findById(id).get();

    }
    @Override
    public Cashback saveCashback(CashbackRequest cashbackRequest){
        Cashback cashback = new Cashback();
        cashback.setId(cashbackRequest.getId());
        cashback.setTranType(cashbackRequest.getTranType());
        cashback.setMerchant(cashbackRequest.getMerchant());
        cashback.setMinAMT(cashbackRequest.getMinAMT());
        cashback.setMaxAMT(cashbackRequest.getMaxAMT());
        cashback.setRate(cashbackRequest.getRate());
        cashback.setStartDate(cashbackRequest.getStartDate());
        cashback.setEndDate(cashbackRequest.getEndDate());
        cashback.setCount(cashbackRequest.getCount());
        cashback.setCustomer(cashbackRequest.getCustomer());
        cashback.setStatus(cashbackRequest.getStatus());

        return cashbackRepository.save(cashback);
    }



    @Override
    public Cashback updateCashback(Cashback cashbackEntity, Long id) {
        return null;
    }

    @Override
    public void deleteCashback(Long id) {

        cashbackRepository.deleteById(id);
    }

}
