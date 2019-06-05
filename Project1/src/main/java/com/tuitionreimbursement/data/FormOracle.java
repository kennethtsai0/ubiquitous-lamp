package com.tuitionreimbursement.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.tuitionreimbursement.beans.Form;
import com.tuitionreimbursement.utils.ConnectionUtil;
import com.tuitionreimbursement.utils.LogUtil;

public class FormOracle implements FormDAO {
	private static Logger log = Logger.getLogger(FormOracle.class);
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	@Override
	public void addForm(Form f) {
		Connection conn = cu.getConnection();
		try {
			log.trace("Creating form");
			conn.setAutoCommit(false);
			String sql = "insert into rform(id_emp, id_event, date, location, description, cost, justification, hierarchy) "
					+ " values (?,?,?,?,?,?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, f.getIdEmployee());
			pstm.setInt(2, f.getIdEvent());
			pstm.setString(3, f.getDate());
			pstm.setString(3, f.getLocation());
			pstm.setString(4, f.getDescription());
			pstm.setDouble(5, f.getCost());
			pstm.setString(6, f.getJustification());
			pstm.setInt(7, f.getHierarchy());
			int result = pstm.executeUpdate();
			if(result!=1){
				log.warn("Form creation failed");
				conn.rollback();
			}
			else {
				log.trace("Form created");
				conn.commit();
			}
		}
		catch(SQLException e)
		{
			LogUtil.rollback(e,conn,FormOracle.class);
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				LogUtil.logException(e,FormOracle.class);
			}
		}
	}

	@Override
	public Set<Form> getForms() {
		Set<Form> formList = new HashSet<Form>();
		log.trace("retrieving all offers from database.");
		try (Connection conn = cu.getConnection()) {
			String sql = "select *"
					+ " from offers";

			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Form f = new Form();
				f.setId(rs.getInt("eventid"));
				f.setIdEmployee(rs.getInt("id_emp"));
				f.setIdEvent(rs.getInt("id_event"));
				f.setDate(rs.getString("date"));
				f.setLocation(rs.getString("location"));
				f.setDescription(rs.getString("description"));
				f.setCost(rs.getDouble("cost"));
				f.setJustification(rs.getString("justification"));
				f.setGrade(rs.getInt("grade"));
				f.setStatus(rs.getString("status"));
				f.setHierarchy(rs.getInt("hierarchy"));
				formList.add(f);
			}
		} catch (Exception e) {
			LogUtil.logException(e, FormOracle.class);
		}
		return formList;
	}
//	@Override
//	public void updateForm(Form f) {
//		log.trace("updating book in database: " + f);
//		Connection conn = cu.getConnection();
//		try {
//			conn.setAutoCommit(false);
//			String sql = "update form set datetime=?, location=?, description=?, cost=?, justification=?, grade=?, status=?" + " where id=?";
//
//			PreparedStatement pstm = conn.prepareStatement(sql);
//			pstm.setString(1, f.getIsbn10());
//			pstm.setString(2, f.getIsbn13());
//			pstm.setString(3, f.getTitle());
//			pstm.setDouble(4, f.getPrice());
//			pstm.setInt(5, f.getStock());
//			pstm.setString(6, f.getCover());
//			pstm.setInt(7, f.getId());
//
//			int result = pstm.executeUpdate();
//
//			if (result == 1) {
//				log.trace("Book updated");
//				removeAuthors(conn, f.getId());
//				removeGenres(conn, f.getId());
//
//				log.trace("Adding authors to book_author");
//				int numberInserted = addAuthors(conn, f.getId(), f.getAuthors());
//				if (f.getAuthors() != null && numberInserted != f.getAuthors().size()) {
//					log.warn("Rolling back book insertion.");
//					conn.rollback();
//					return;
//				} else {
//					log.trace("Book associated with all authors!");
//				}
//				log.trace("Adding genres to book_genre");
//				numberInserted = addGenres(conn, f.getId(), f.getGenres());
//				if (f.getGenres() != null && numberInserted != f.getGenres().size()) {
//					log.warn("Rolling back book insertion.");
//					conn.rollback();
//					return;
//				} else {
//					log.trace("Book associated with all genres!");
//				}
//				log.trace("Operations complete.");
//				conn.commit();
//			}
//		} catch (SQLException e) {
//			LogUtil.rollback(e, conn, FormOracle.class);
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				LogUtil.logException(e, FormOracle.class);
//			}
//		}
//	}
}
