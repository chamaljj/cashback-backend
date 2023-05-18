package com.dialogfinance.cashback.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MerchantRequest {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("mid")
    private String mid ;

    @JsonProperty("del_flag")
    private String delFlag;

    @JsonProperty("status")
    private String status;

    @JsonProperty("cashback_id")
    private int cashbackId;
}
