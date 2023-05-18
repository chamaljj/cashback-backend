package com.dialogfinance.cashback.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranTypeRequest {

    @JsonProperty("id")
    private long id;

    @JsonProperty("tranType_id")
    private int tranTypeId;

    @JsonProperty("tranType")
    private String typeName;

}
