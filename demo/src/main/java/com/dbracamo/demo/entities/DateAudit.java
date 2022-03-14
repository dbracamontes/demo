package com.dbracamo.demo.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import lombok.Data;

/**
 * 
 * @author dbracamo
 * Using @MappedSuperclass, you create a non-entity super class and you can create entity subclasses 
 * that inherit this super class. With this annotation, a separate table for each subclass
 * is created. However, a table is not created for the super class itself.
 *
 */
@EntityListeners(DateAuditListener.class)
@MappedSuperclass
@Data
public class DateAudit {
	
	/**
	 * We can now map the JDBC Types TIME, DATE, and TIMESTAMP to the java.time types
	 *  – LocalTime, LocalDate, and LocalDateTime
	 */
	@Column(name = "created_at", columnDefinition = "TIMESTAMP")
	private LocalDateTime createdAt;

	@Column(name = "created_by")
	private String createdBy;
	
	/**
	 * We can now map the JDBC Types TIME, DATE, and TIMESTAMP to the java.time types
	 *  – LocalTime, LocalDate, and LocalDateTime
	 */
	@Column(name = "updated_at", columnDefinition = "TIMESTAMP")
	private LocalDateTime updatedAt;
	
	@Column(name = "updated_by")
	private String updatedBy;

}
