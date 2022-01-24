package com.hibernate.inheritance.tableperclass;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="MANAGER")
@AttributeOverrides({  
    @AttributeOverride(name="employeeId", column=@Column(name="id")),  
    @AttributeOverride(name="sal", column=@Column(name="sal")),  
    @AttributeOverride(name="name", column=@Column(name="name"))  
})
public class Manager extends Employee {

	@Column
	private double incentive;

	public Manager(String name, double sal, double incentive) {
		super(name, sal);
		this.incentive = incentive;
	}

	public double getIncentive() {
		return incentive;
	}

	public void setIncentive(double incentive) {
		this.incentive = incentive;
	}
	
}
