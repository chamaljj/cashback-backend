package com.dialogfinance.cashback.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="Merchants")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Merchant extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="mid")
    private String mid ;

    @Column(name="del_flag")
    private String delFlag;

    @Column(name="active_status",nullable = false)
    private String status;

    @Column(name ="cashback_id")
    private int cashbackId;

    public Merchant() {
    }

    public Merchant(long id,String mid, String delFlag, String status,int cashbackId) {
        this.id = id;
        this.mid = mid;
        this.delFlag = delFlag;
        this.status = status;
        this.cashbackId = cashbackId;

    }

}
