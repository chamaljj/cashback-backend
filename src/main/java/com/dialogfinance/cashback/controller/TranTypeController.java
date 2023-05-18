package com.dialogfinance.cashback.controller;

import com.dialogfinance.cashback.entity.Cashback;
import com.dialogfinance.cashback.entity.TranType;
import com.dialogfinance.cashback.exception.ResourceNotFoundException;
import com.dialogfinance.cashback.repository.TranTypeRepository;
import com.dialogfinance.cashback.requests.TranTypeRequest;
import com.dialogfinance.cashback.service.TranTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;

@RestController
@RequestMapping("/api")
@Slf4j
public class TranTypeController {


    @Autowired
    private TranTypeService tranTypeService;

    @Autowired
    private TranTypeRepository tranTypeRepository;



    @GetMapping("/tranTypes")
    public List<TranType> findAllTranType(){
        return tranTypeService.findAllTranType();
    }

    @GetMapping("/tranType/{id}")
    public ResponseEntity<?> findTranTypeById(@PathVariable("tranTypeId") Long id){
        TranType tranTypeEntity = tranTypeService.findTranTypeById(id);
        return ResponseEntity.ok(tranTypeEntity);
    }

    @PostMapping("/tranTypes")
    @PreAuthorize("hasRole('Super Admin') or hasRole('Admin')")
    public Map<String, Object> saveTranType(@RequestBody TranTypeRequest tranTypeRequest) {
        Map<String, Object> response = new HashMap<>();
        try {
           log.info("Save a transaction type Successfully ...");

            TranType tranType = tranTypeService.saveTranType(tranTypeRequest);
            response.put("STATUS", "SUCCESS");
            response.put("MESSAGE", "YOU ADDED SUCCESSFULLY");
            response.put("DATA", tranType);
            log.info("Add new TranType Details : "+tranType);

        } catch (Exception e) {
         log.error("Save a transaction type Unsuccessfully ...");

            response.put("STATUS", "FAILED");
            response.put("MESSAGE", e);
        }
        return response;
    }

    @PutMapping("/tranTypes/{id}")
    @PreAuthorize("hasRole('Super Admin') or hasRole('Admin')")
    public ResponseEntity<TranType> updateTranType(@PathVariable Long id, @RequestBody TranType tranTypeDetails) {
        log.info("Update a transaction type Successfully ...id: " +id);
        TranType updateTranType = tranTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TranType not exist with id: " + id));
        updateTranType.setId(tranTypeDetails.getId());
        updateTranType.setTranTypeId(tranTypeDetails.getTranTypeId());
        updateTranType.setTypeName(tranTypeDetails.getTypeName());
        tranTypeRepository.save(updateTranType);
        log.info("Update TranType id : " +id+ " Details : "+updateTranType);
        return ResponseEntity.ok(updateTranType);
    }

    @DeleteMapping("/tranTypes/{id}")
    @PreAuthorize("hasRole('Super Admin')")
    public void deleteTranType(@PathVariable("id") Long id){

        Optional<TranType> deleteTranType = tranTypeRepository.findById(id);

        log.info("Deleted a TranType Successfully  {}",deleteTranType.toString());

        tranTypeService.deleteTranType(id);
    }
}
