package com.tuitionreimbursement.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuitionreimbursement.beans.Event;
import com.tuitionreimbursement.data.EventDAO;
import com.tuitionreimbursement.data.EventOracle;

public class EventDelegate implements FrontControllerDelegate {

	private Logger log = Logger.getLogger(EventDelegate.class);
	private EventDAO eo = new EventOracle();
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String path = (String) req.getAttribute("path");
		// TuitionReimbursement/Event
		log.trace("Event delegate has been called");
		eventTimes(req, resp, path);
	}
	private void eventTimes(HttpServletRequest req, HttpServletResponse resp, String event) throws IOException {
		// GET, PUT, DELETE
		Event ev = eo.getEvent(event);
		switch(req.getMethod()) {
		case "GET": 
			resp.getWriter().write(om.writeValueAsString(ev));
		default: resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED); return;
		}
		
	}

}
