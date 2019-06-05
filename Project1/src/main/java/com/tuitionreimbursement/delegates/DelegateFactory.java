package com.tuitionreimbursement.delegates;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

public class DelegateFactory {
	private static DelegateFactory df;
	private Map<String, FrontControllerDelegate> delegateMap;
	private DelegateFactory() {
		delegateMap = new HashMap<String, FrontControllerDelegate>();
		delegateMap.put("login", new LoginDelegate());
	}

	public static synchronized DelegateFactory getInstance() {
		if (df == null)
			df = new DelegateFactory();
		return df;
	}

	public FrontControllerDelegate getDelegate(String name) {
		FrontControllerDelegate fcd = delegateMap.get(name);
		if(fcd==null) {
			fcd = (req, resp) -> {
				resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			};
		}
		return fcd;
	}
}
