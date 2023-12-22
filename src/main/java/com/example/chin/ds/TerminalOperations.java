package com.practice.chin.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TerminalOperations {

	public static void main(String[] args) {
		
		Employee e1 = new Employee("dffdgf",1,345);
		Employee e2 = new Employee("ere",2,4565);
		Employee e3 = new Employee("rerewr",3,5464);
		Employee e4 = new Employee("ewfr",3,3465);
		Employee e5 = new Employee("tewe",2,35634);
		Employee e6 = new Employee("werwe",3,354533);
		Employee e7 = new Employee("ewrr",2,344);
		Employee e8 = new Employee("abc",1,4344);
		List<Employee> list = new ArrayList<>();
		list.add(e8);
		list.add(e7);
		list.add(e6);
		list.add(e5);
		list.add(e4);
		list.add(e3);
		list.add(e2);
		list.add(e1);
		
		Map<Object, Long> map = list.stream().collect(Collectors.groupingBy(x->x.deptId, Collectors.counting()));
		System.out.println(map);
		Map<Object, List<Employee>> map2 = list.stream().sorted((emp1,emp2)->emp1.empId-emp2.empId).collect(Collectors.groupingBy(x->x.deptId));
		System.out.println(map2);
		System.out.println(list.stream().collect(Collectors. averagingInt(x->x.empId)));
		System.out.println(list.stream().collect(Collectors.maxBy((o1,o2)->o2.empId-o1.empId)));
		
		
		char c =Character.UNASSIGNED;
		
	}

}

class Employee{
	String name;
	int deptId;
	int empId;
	public Employee(String name, int deptId, int empId) {
		super();
		this.name = name;
		this.deptId = deptId;
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public int getDeptId() {
		return deptId;
	}
	public int getEmpId() {
		return empId;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", deptId=" + deptId + ", empId=" + empId + "]";
	}
	
}
