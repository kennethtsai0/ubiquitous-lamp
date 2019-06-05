package com.tuitionreimbursement.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.tuitionreimbursement.beans.Event;
import com.tuitionreimbursement.utils.ConnectionUtil;
import com.tuitionreimbursement.utils.LogUtil;

public class EventOracle implements EventDAO {
	private static Logger log = Logger.getLogger(EmployeeOracle.class);
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

	@Override
	public Event getEvent(String s) {
		Event ev = null;
		log.trace("Retrieving event from database.");
		try(Connection conn = cu.getConnection()){
			String sql = "select eventid, coverage, passing from event where event =?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, s);
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
			{
				log.trace("Offer found.");
				ev = new Event();
				ev.setId(rs.getInt("eventid"));
				ev.setEvent(s);
				ev.setCoverage(rs.getInt("coverage"));
				ev.setPassing(rs.getInt("passing"));
			}
		}
		catch(Exception e)
		{
			LogUtil.logException(e, EventOracle.class);
		}
		
		return ev;
	}
}
