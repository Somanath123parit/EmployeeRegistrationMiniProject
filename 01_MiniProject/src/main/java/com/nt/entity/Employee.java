package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "emptab")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eid")
     private Integer empId;
	
	//latest updated
	@Column(name = "ename" ,length=50)
     private String empName;
     
	 @Column(name = "gen",length = 10)
	 private String empGen;
	 
	 @Column(name = "eaddr",length = 100,nullable = false )
     private String empAddr;
	 
	 @Column(name = "esal")
     private Double empSal;
	 
	 @Column(name = "dept",length = 10,nullable = false )
     private String dept;
}
