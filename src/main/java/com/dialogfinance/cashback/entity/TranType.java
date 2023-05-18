package com.dialogfinance.cashback.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name="tranTypes")
public class TranType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name="tranId")
    private int tranTypeId ;

    @Column(name="typeName")
    private String typeName;


    public TranType() {
    }

    public TranType(long id, int tranTypeId, String typeName) {
        this.id = id;
        this.tranTypeId = tranTypeId;
        this.typeName = typeName;
    }
}
