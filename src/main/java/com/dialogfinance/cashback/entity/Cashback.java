package com.dialogfinance.cashback.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="cashbacks")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Cashback extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cashback_id")
    private long id;

    @Column(name="tran_type")
    private String tranType;

    @Column(name="merchant")
    private String merchant;

    @Column(name="minAmt")
    private int minAMT;

    @Column(name="maxAmt")
    private int maxAMT;

    @Column(name="rate")
    private float rate;

    @Column(name="startDate")
    private String startDate;

    @Column(name="endDate")
    private String endDate;

    @Column(name="count")
    private int count;

    @Column(name="customer")
    private String customer;

    @Column(name="status")
    private String status;

    @Column(name="initiator")
    private String initiator;

    @Column(name="onus_offus")
    private String onus_offus;

    @Column(name="mcc")
    private String mcc;

    @Column(name="country_code")
    private String country_code;

    @Column(name="cashback_fixed_amt")
    private String cashback_fixed_amt;

    @Column(name="channel")
    private String channel;

    @Column(name="mid")
    private String mid;

    @Column(name="del_flag")
    private String del_flag;


    public Cashback() {
    }

    public Cashback(long id, String tranType, String merchant, int minAMT, int maxAMT, float rate, String startDate, String endDate, int count, String customer, String status,String cashback_fixed_amt, String del_flag) {
        this.id = id;
        this.tranType = tranType;
        this.merchant = merchant;
        this.minAMT = minAMT;
        this.maxAMT = maxAMT;
        this.rate = rate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.count = count;
        this.customer = customer;
        this.status = status;
        this.cashback_fixed_amt = cashback_fixed_amt;
        this.del_flag = del_flag;
    }




}
