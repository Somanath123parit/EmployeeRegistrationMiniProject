package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.exception.EmployeeNotFoundException;
import com.nt.repo.EmployeeRepository;


@Service
public class EmployeeServiceImpli implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	public Integer saveEmployee(Employee e) {
	    e=repo.save(e);
		return e.getEmpId();
	}

	public List<Employee> getAllEmployees() {

		List<Employee> list=repo.findAll();
		return list;
	}

	public void deleteEmployee(Integer id) {
		
      repo.delete(getOneEmployee(id));
	}

	
	public Employee getOneEmployee(Integer id) {
		/*
		 * Optional<Employee> opt=repo.findById(id); if(opt.isPresent()) { Employee
		 * e=opt.get(); return e; } else { throw new
		 * EmployeeNotFoundException("Employee "+id+" not Exist"); }
		 */
		return repo.findById(id).orElseThrow(
				()-> new EmployeeNotFoundException("EMPLOYEE '"+id+"' NOT EXIST")
				);
	}
	public void updateEmployee(Employee e) {	
		if(e.getEmpId()!=null && repo.existsById(e.getEmpId()))
			repo.save(e);
		else 
			throw new EmployeeNotFoundException("EMPLOYEE '"+e.getEmpId()+"' NOT EXIST");
	}
	@Override
	public Page<Employee> getAllEmployees(Pageable pageable) {
		Page<Employee> page=repo.findAll(pageable);
		return page;
	}

}
