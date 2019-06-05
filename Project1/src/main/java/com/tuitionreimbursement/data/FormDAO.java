package com.tuitionreimbursement.data;

import java.util.Set;

import com.tuitionreimbursement.beans.Form;

public interface FormDAO {
	public void addForm(Form f);
	public Set<Form> getForms();
//	public void updateForm(Form f);
}
