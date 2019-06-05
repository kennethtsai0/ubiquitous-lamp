package com.tuitionreimbursement.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuitionreimbursement.beans.Department;
import com.tuitionreimbursement.data.DepartmentDAO;
import com.tuitionreimbursement.data.DepartmentOracle;

public class DepartmentDelegate implements FrontControllerDelegate {
	private Logger log = Logger.getLogger(EventDelegate.class);
	private DepartmentDAO doracle = new DepartmentOracle();
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String path = (String) req.getAttribute("path");
		// TuitionReimbursement/Event
		log.trace("Event delegate has been called");
		depTimes(req, resp, Integer.parseInt(path.toString()));
	}
	private void depTimes(HttpServletRequest req, HttpServletResponse resp, int department) throws IOException {
		// GET, PUT, DELETE
		Department ev = doracle.getDepartmentByID(department);
		switch(req.getMethod()) {
		case "GET": 
			resp.getWriter().write(om.writeValueAsString(ev));
		default: resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED); return;
		}
		
	}

}
