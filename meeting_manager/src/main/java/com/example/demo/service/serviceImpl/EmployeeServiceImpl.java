package com.example.demo.service.serviceImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@Service(value = "EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeedao;
	

	@Override
	public Employee findById(Integer id) {
		return employeedao.findByEmployeeId(id);
	}

	@Override
	public Employee findByName(String employeename) {
		return employeedao.findByEmployeeName(employeename);
	}

	@Override
	public Employee add(Employee employee) {
		return employeedao.save(employee);
	}

	@Override
	public void delEmployee(Integer id) {
		employeedao.deleteById(id);
	}

	@Override
	public Page<Employee> fy(int ys, int hs) {// 显示行数
		Pageable pageable = new PageRequest(ys, hs);
		Page<Employee> page = employeedao.findAll(pageable);
		return page;
	}
	

	@Override
	public List<Employee> getUsers(Employee employee) {
		return employeedao.findAll(new Specification<Employee>() {
			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate pc = cb.conjunction();
				if (employee != null) {
					if (employee.getEmployeeName() != null && !(employee.getEmployeeName().equals(""))) {
						pc.getExpressions().add(cb.like(root.get("password"), "%" + employee.getEmployeePassword() + "%"));
					}
					if (null != employee.getEmployeePassword() && !(employee.getEmployeePassword().equals(""))) {
						pc.getExpressions().add(cb.like(root.get("username"), "%" + employee.getEmployeePassword() + "%"));
					}
				}
				return pc;
			}
		});

	}

	@Override
	public List<Employee> findAll() {
		return employeedao.findAll();
	}

	@Override
	public Integer getPage(int count) {
		return (int) employeedao.count();
	}

	@Override
	public Employee findByEmployeeNameAndEmployeePassword(Employee employee) {
		return employeedao.findByemployeeNameAndemployeePassword(employee);
	}

	public Integer count() {
		
		return (int) employeedao.count();
	}

}
