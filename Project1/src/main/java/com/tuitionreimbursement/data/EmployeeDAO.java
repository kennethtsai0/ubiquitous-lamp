package com.tuitionreimbursement.data;

import com.tuitionreimbursement.beans.Employee;

public interface EmployeeDAO {
	public Employee getEmployee(String username, String pass);
}
