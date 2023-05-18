package com.dialogfinance.cashback.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@MappedSuperclass
@EntityListeners(value = { AuditingEntityListener.class })
public abstract class Auditable<String> {

    @CreatedBy
    @Column(name="created_by", updatable=false)
    protected String createdBy;

    @CreationTimestamp
    @Column(name="created_dt", updatable =false)
    protected Timestamp createdDate;

    @LastModifiedBy
    @Column(name="modified_by")
    protected String modifiedBy;

    @LastModifiedDate
    @Column(name="modified_dt")
    protected Timestamp modifiedDate;

    public Auditable(String createdBy, Timestamp createdDate, String modifiedBy, Timestamp modifiedDate) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public Auditable() {
    }


}
