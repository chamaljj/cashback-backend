package com.dialogfinance.cashback.controller;


import com.dialogfinance.cashback.entity.Cashback;
import com.dialogfinance.cashback.entity.Customer;
import com.dialogfinance.cashback.entity.Merchant;
import com.dialogfinance.cashback.exception.ResourceNotFoundException;
import com.dialogfinance.cashback.repository.MerchantRepository;
import com.dialogfinance.cashback.requests.CustomerRequest;
import com.dialogfinance.cashback.requests.MerchantRequest;
import com.dialogfinance.cashback.service.MerchantService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private MerchantRepository merchantRepository;

    @GetMapping("/merchants")
    public List<Merchant> findAllMerchant(){
        return merchantService.findAllMerchant();
    }

    @GetMapping("/merchants/{id}")
    public ResponseEntity<?> findCustomerById(@PathVariable("id") Long id){
        Merchant merchantEntity = merchantService.findMerchantById(id);
        return ResponseEntity.ok(merchantEntity);
    }

    @PostMapping("/merchants")
    public Map<String, Object> saveMerchant(@RequestBody MerchantRequest merchantRequest){
        Map<String, Object> response = new HashMap<>();

        try{
            log.info("Save a merchant wise cashback Successfully ...");

            Merchant merchant = merchantService.saveMerchant(merchantRequest);
            response.put("STATUS","SUCCESS");
            response.put("MESSAGE", "YOU ADDED SUCCESSFULLY");
            response.put("DATA", merchant);
            log.info("Add new Merchant Details : "+merchant);

        } catch (Exception e) {
            log.error("Save a merchant wise cashback Unsuccessfully ..."+e);

            response.put("STATUS", "FAILED");
            response.put("MESSAGE", e);
        }
        return response;

    }

    @PutMapping("/merchants/{id}")
    @PreAuthorize("hasRole('Super Admin') or hasRole('Admin')")
    public ResponseEntity<Merchant> updateCustomer(@PathVariable Long id, @RequestBody Merchant merchantDetails) {

        log.info("Update a merchant wise cashback Successfully ... "+id);

        Merchant updateMerchant = merchantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Merchant not exist with id: " + id));
        updateMerchant.setMid(merchantDetails.getMid());
        updateMerchant.setStatus(merchantDetails.getStatus());
        updateMerchant.setCashbackId(merchantDetails.getCashbackId());
        merchantRepository.save(updateMerchant);

        log.info("Update Merchant id : " +id+ " Details : "+updateMerchant);

        return ResponseEntity.ok(updateMerchant);
    }

    @DeleteMapping("/merchants/{id}")
    @PreAuthorize("hasRole('Super Admin')")
    public void deleteMerchant(@PathVariable("id") Long id){

        Optional<Merchant> deleteMerchant= merchantRepository.findById(id);
        log.info("Deleted a merchant wise cashback Successfully  {}",deleteMerchant.toString());

        merchantService.deleteMerchant(id);
    }
}
