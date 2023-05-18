package com.dialogfinance.cashback.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CustomerRequest {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("customer_id")
    private int customerId;

    @JsonProperty("del_flag")
    private String delFlag;

    @JsonProperty("status")
    private String status;

    @JsonProperty("cashback_id")
    private int cashbackId;
}
