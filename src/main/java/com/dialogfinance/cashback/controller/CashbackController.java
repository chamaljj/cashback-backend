package com.dialogfinance.cashback.controller;

import com.dialogfinance.cashback.entity.Cashback;
import com.dialogfinance.cashback.entity.Customer;
import com.dialogfinance.cashback.exception.ResourceNotFoundException;
import com.dialogfinance.cashback.repository.CashbackRepository;
import com.dialogfinance.cashback.requests.CashbackRequest;
import com.dialogfinance.cashback.service.CashbackService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@Slf4j
public class CashbackController  {

    @Autowired
    private CashbackService cashbackService;

    @Autowired
    private CashbackRepository cashbackRepository;


    @GetMapping("/cashbacks")
    public List<Cashback> findAllCashback(){
        return cashbackService.findAllCashback();
    }


    @PostMapping("/cashbacks")
    public Map<String, Object> saveCashback(@RequestBody CashbackRequest cashbackRequest) {
        Map<String, Object> response = new HashMap<>();
        try {

            log.info("Save a cashback Successfully ...");

            Cashback cashback = cashbackService.saveCashback(cashbackRequest);
            response.put("STATUS", "SUCCESS");
            response.put("MESSAGE", "YOU ADDED SUCCESSFULLY");
            response.put("DATA", cashback);

            log.info("Add new Cashback Details : "+cashback);

        } catch (Exception e) {

            log.error("Not save cashback unfortunately...", e);

            response.put("STATUS", "FAILED");
            response.put("MESSAGE", e);
        }
        return response;
    }


    @PutMapping("/cashbacks/{id}")
    @PreAuthorize("hasRole('Super Admin') or hasRole('Admin')")
    public ResponseEntity<Cashback> updateCashback(@PathVariable Long id, @RequestBody Cashback cashbackDetails) {

        log.info("Update cashback Successfully with id: " + id);

        Cashback updateCashback = cashbackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cashback not exist with id: " + id));
        updateCashback.setTranType(cashbackDetails.getTranType());
        updateCashback.setMerchant(cashbackDetails.getMerchant());
        updateCashback.setMinAMT(cashbackDetails.getMinAMT());
        updateCashback.setMaxAMT(cashbackDetails.getMaxAMT());
        updateCashback.setRate(cashbackDetails.getRate());
        updateCashback.setStartDate(cashbackDetails.getStartDate());
        updateCashback.setEndDate(cashbackDetails.getEndDate());
        updateCashback.setCount(cashbackDetails.getCount());
        updateCashback.setCustomer(cashbackDetails.getCustomer());
        updateCashback.setStatus(cashbackDetails.getStatus());
        cashbackRepository.save(updateCashback);

        log.info("Update Cashback id : " +id+ " Details : "+updateCashback);


        return ResponseEntity.ok(updateCashback);
    }

    @DeleteMapping("/cashbacks/{id}")
    @PreAuthorize("hasRole('Super Admin')")
    public void deleteCashback(@PathVariable("id") Long id){

        Optional<Cashback> deleteCashback= cashbackRepository.findById(id);
        log.info("Deleted cashback Successfully  {}",deleteCashback.toString());


        cashbackService.deleteCashback(id);
    }

}







