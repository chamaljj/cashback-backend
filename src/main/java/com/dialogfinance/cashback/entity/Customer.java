package com.dialogfinance.cashback.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="Customers")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Customer extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "customer_id")
    private long customerId;

    @Column(name="del_flag")
    private String delFlag;

    @Column(name="active_status")
    private String status;

    @Column(name="cashback_id")
    private int cashbackId;


    public Customer() {
    }

    public Customer(long id,long customerId, String delFlag, String status,int cashbackId) {
        this.id = id;
        this.customerId = customerId;
        this.delFlag = delFlag;
        this.status = status;
        this.cashbackId = cashbackId;
    }

}
