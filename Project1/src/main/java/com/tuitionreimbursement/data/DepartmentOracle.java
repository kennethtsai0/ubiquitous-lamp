package com.tuitionreimbursement.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.tuitionreimbursement.beans.Department;
import com.tuitionreimbursement.utils.ConnectionUtil;
import com.tuitionreimbursement.utils.LogUtil;

public class DepartmentOracle implements DepartmentDAO {
	private static Logger log = Logger.getLogger(EmployeeOracle.class);
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	@Override
	public Department getDepartmentByID(int id) {
		Department d = null;
		log.trace("Retrieving department from database.");
		try(Connection conn = cu.getConnection()){
			String sql = "select department, id_dep_head "
					+ "from department where depid =?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
			{
				log.trace("Department found.");
				d = new Department();
				d.setId(id);
				d.setDepartmentname(rs.getString("department"));
				d.setIdDepHead(rs.getInt("id_dep_head"));
			}
		}
		catch(Exception e)
		{
			LogUtil.logException(e, DepartmentOracle.class);
		}
		
		return d;
	}

}
