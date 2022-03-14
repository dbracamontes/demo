package com.dbracamo.demo.entities;

import javax.persistence.PrePersist;

public class DateAuditListener {

	@PrePersist
	public void prePersist(DateAudit audit) {
		audit.setCreatedAt(null);
	}
	
}
