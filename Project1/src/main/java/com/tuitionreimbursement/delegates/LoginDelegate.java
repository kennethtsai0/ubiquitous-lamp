package com.tuitionreimbursement.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuitionreimbursement.beans.Employee;
import com.tuitionreimbursement.data.EmployeeDAO;
import com.tuitionreimbursement.data.EmployeeOracle;

public class LoginDelegate implements FrontControllerDelegate {
	private Logger log = Logger.getLogger(LoginDelegate.class);
	private EmployeeDAO ed = new EmployeeOracle();
	private ObjectMapper om = new ObjectMapper();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		log.trace(req.getMethod() + " received by login delegate");
		HttpSession session = req.getSession();
		switch (req.getMethod()) {
		case "GET":
			
			checkLogin(req, resp);
			break;
		case "POST":
			// logging in
			Employee emp = (Employee) session.getAttribute("loggedEmployee");
			if (emp != null) {
				respondWithEmployee(resp, emp);
			} else {
				checkLogin(req, resp);
			}
			break;
		case "DELETE":
			// logging out
			session.invalidate();
			// disassociates an id with a session and response says to delete cookie
			log.trace("Employee logged out");
			break;
		default:
			break;
		}
	}

	private void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		log.trace("Logging in!");
		HttpSession session = req.getSession();
		Employee e = (Employee) session.getAttribute("loggedEmployee");
		if (e != null) {
			respondWithEmployee(resp, e);
		} else {

			// Need to see if we are an employee. Then we need to see if we are a customer.
			// Then we need to store that information in the session object.
			System.out.println(req);
			String username = req.getParameter("user");
			String password = req.getParameter("pass");
			log.trace((username + " " + password));
			e = ed.getEmployee(username, password);
			if (e != null) {
				log.trace("employee being added to session");
				session.setAttribute("loggedEmployee", e);
			}
			if (e == null) {
				resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No user found with those credentials");
			} else {
				respondWithEmployee(resp, e);
			}
		}
	}

	private void respondWithEmployee(HttpServletResponse resp, Employee emp) throws IOException {
		resp.setStatus(HttpServletResponse.SC_OK);
		String e = om.writeValueAsString(emp);
		StringBuilder sb = new StringBuilder("{\"employee\":");
		sb.append(e);
		sb.append("}");
		resp.getWriter().write(sb.toString());
	}

}
