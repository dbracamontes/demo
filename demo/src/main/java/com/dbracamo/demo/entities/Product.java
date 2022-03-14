package com.dbracamo.demo.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="product")
@Getter
@Setter
@ToString
@DynamicInsert
@DynamicUpdate
@SequenceGenerator(name="product_id_gen", allocationSize = 1)
public class Product extends DateAudit{
	
	@GeneratedValue(generator = "product_id_gen")
	@Id
	@Column(name="id")
	private Long id;

	@NotNull(message = "Name cannot be null")
	@Column(name="name")
	private String name;
	
	@NotNull(message = "Description cannot be null")
	@Column(name="description")
	private String description;
	
	@NotNull(message = "Price cannot be null")
	@Column(name="price")
	private Double price;
	
}

