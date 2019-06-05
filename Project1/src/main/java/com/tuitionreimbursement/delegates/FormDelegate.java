package com.tuitionreimbursement.delegates;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuitionreimbursement.beans.Form;
import com.tuitionreimbursement.data.FormDAO;
import com.tuitionreimbursement.data.FormOracle;
import com.tuitionreimbursement.utils.JsonParseUtil;
import com.tuitionreimbursement.utils.LogUtil;

public class FormDelegate implements FrontControllerDelegate {

	private Logger log = Logger.getLogger(FormDelegate.class);
	private ObjectMapper om = new ObjectMapper();
	private FormDAO fo = new FormOracle();
	
	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String path = (String) req.getAttribute("path");
		log.trace("path: "+path);
		if(path==null||"".equals(path))
			collectionOperations(req,resp);
//		else {
//			try {
//				bookTimes(req,resp,Integer.parseInt(path.toString()));
//			} catch(NumberFormatException e) {
//				resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
//			}
//		}
	}
//	private void bookTimes(HttpServletRequest req, HttpServletResponse resp, int bookId) throws IOException {
//		log.trace("Operating on a specific book with id: "+bookId);
//		PrintWriter writer = resp.getWriter();
//		Form f;
//		BufferedReader bf;
//		StringBuilder sb;
//		switch(req.getMethod()) {
//		case "GET":
//			f = bs.getBookById(bookId);
//			resp.getWriter().write(om.writeValueAsString(f));
//			return;
//		case "PUT":
//			// Update the book in the database
//			f = JsonParseUtil.parseJsonInput(req.getInputStream(), Book.class, resp);
//			bs.updateBook(f);
//			writer.write(om.writeValueAsString(f));
//			return;
//		case "DELETE":
//			f = JsonParseUtil.parseJsonInput(req.getInputStream(), Book.class, resp);
//			log.trace(f);
//			bs.deleteBook(f);
//			resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
//			return;
//		default:
//			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
//		}
//	}

	private void collectionOperations(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		switch(req.getMethod()) {
		case "GET": 
			log.trace("Retrieving all forms from the database");
			Set<Form> forms = fo.getForms();
			resp.getWriter().write(om.writeValueAsString(forms));
			return;
		case "POST": 
			log.trace("Post called with form");
			Form f = JsonParseUtil.parseJsonInput(req.getInputStream(), Form.class, resp);
			log.trace(f);
			if(f==null)
				return;
			try {
				// Add the book to the database
				log.trace("Adding form to the database: "+f);
				fo.addForm(f);
				resp.setStatus(HttpServletResponse.SC_CREATED);
				resp.getWriter().write(om.writeValueAsString(f));
			} catch(Exception e) {
				LogUtil.logException(e, FormDelegate.class);
				resp.sendError(HttpServletResponse.SC_CONFLICT);
			}
			return;
		default: resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		}
	}

}
