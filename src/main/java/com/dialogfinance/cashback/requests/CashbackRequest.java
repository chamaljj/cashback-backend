package com.dialogfinance.cashback.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.sql.Timestamp;

@Getter
@Setter
public class CashbackRequest {

    @JsonProperty("cashback_id")
    private long id;

    @JsonProperty("tran_type")
    private String tranType;

    @JsonProperty("merchant")
    private String merchant;

    @JsonProperty("minAmt")
    private int minAMT;

    @JsonProperty("maxAmt")
    private int maxAMT;

    @JsonProperty("rate")
    private float rate;

    @JsonProperty("startDate")
    private String startDate;

    @JsonProperty("endDate")
    private String endDate;

    @JsonProperty("count")
    private int count;

    @JsonProperty("customer")
    private String customer;

    @JsonProperty("status")
    private String status;

    @JsonProperty("initiator")
    private String initiator;

    @JsonProperty("onus_offus")
    private String onus_offus;

    @JsonProperty("mcc")
    private String mcc;

    @JsonProperty("country_code")
    private String country_code;

    @JsonProperty("cashback_fixed_amt")
    private String cashback_fixed_amt;

    @JsonProperty("channel")
    private String channel;

    @JsonProperty("mid")
    private String mid;

    @JsonProperty("del_flag")
    private String del_flag;

}
