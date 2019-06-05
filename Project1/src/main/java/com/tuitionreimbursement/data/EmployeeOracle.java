package com.tuitionreimbursement.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.tuitionreimbursement.beans.Employee;
import com.tuitionreimbursement.utils.ConnectionUtil;
import com.tuitionreimbursement.utils.LogUtil;

public class EmployeeOracle implements EmployeeDAO {
	private static Logger log = Logger.getLogger(EmployeeOracle.class);
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	@Override
	public Employee getEmployee(String username, String pass) {
		Employee em = null;
		log.trace("Retrieve user from database.");
		try(Connection conn = cu.getConnection()){
			String sql = "select empid, firstname, lastname, username, pass, title, id_dep, reportsto, id_dep, emp_type "
					+ "from employee where username=? and pass=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, pass);
			ResultSet rs = pstm.executeQuery();
			System.out.println(rs);
			if(rs.next())
			{
				log.trace("Employee found.");
				em = new Employee();
				em.setId(rs.getInt("empid"));
				em.setFirstname(rs.getString("firstname"));
				em.setLastname(rs.getString("lastname"));
				em.setUsername(username);
				em.setPass(pass);
				em.setTitle(rs.getString("title"));
				em.setIdDep(rs.getInt("id_dep"));
				em.setReportsto(rs.getInt("reportsto"));
				em.setReimbursementLeft(rs.getInt("id_dep"));
				em.setEmpType(rs.getInt("emp_type"));
			}
		}
		catch(Exception e)
		{
			LogUtil.logException(e, EmployeeOracle.class);
		}
		return em;
	}

}
