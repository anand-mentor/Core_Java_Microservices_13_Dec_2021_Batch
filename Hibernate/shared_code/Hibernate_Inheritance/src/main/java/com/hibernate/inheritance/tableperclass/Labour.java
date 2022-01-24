package com.hibernate.inheritance.tableperclass;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="LABOUR")
@AttributeOverrides({  
    @AttributeOverride(name="employeeId", column=@Column(name="id")),  
    @AttributeOverride(name="sal", column=@Column(name="sal")),  
    @AttributeOverride(name="name", column=@Column(name="name"))  
})
public class Labour extends Employee {

	@Column
	private double overtime;

	public Labour(String name, double sal, double overtime) {
		super(name, sal);
		this.overtime = overtime;
	}

	public double getOvertime() {
		return overtime;
	}

	public void setOvertime(double overtime) {
		this.overtime = overtime;
	}
	
}
