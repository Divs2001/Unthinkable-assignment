package com.divs.assignment.entity;

//import java.security.Timestamp; //wrong import

import java.sql.Timestamp; //this was the import which I had to use
//use this above import or the 3 imports just mentioned below

//import javax.persistence.Temporal;
//import java.util.Date;
//import static javax.persistence.TemporalType.TIMESTAMP;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@MappedSuperclass
@Data
@EntityListeners(value = { AuditingEntityListener.class })
public abstract class AuditableBase {

	@CreatedBy
	@Column(updatable = false)
	private String createdBy;

	@CreatedDate
	@Column(updatable = false)
//	@Temporal(TIMESTAMP)
//	private Date createdDt;
	private Timestamp createdDt;

	@LastModifiedBy
	private String modifiedBy;

	@LastModifiedDate
//	@Temporal(TIMESTAMP)
//	private Date modifiedDt;
	private Timestamp modifiedDt;

}
