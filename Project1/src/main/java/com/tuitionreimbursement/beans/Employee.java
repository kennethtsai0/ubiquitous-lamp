package com.tuitionreimbursement.beans;

public class Employee {
	private Integer id;
	private String firstname;
	private String lastname;
	private String username;
	private String pass;
	private String title;
	private Integer reportsto;
	private Integer idDep;
	private double reimbursementLeft;
	private Integer empType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getReportsto() {
		return reportsto;
	}
	public void setReportsto(Integer reportsto) {
		this.reportsto = reportsto;
	}
	public Integer getIdDep() {
		return idDep;
	}
	public void setIdDep(Integer idDep) {
		this.idDep = idDep;
	}
	public double getReimbursementLeft() {
		return reimbursementLeft;
	}
	public void setReimbursementLeft(double reimbursementLeft) {
		this.reimbursementLeft = reimbursementLeft;
	}
	public Integer getEmpType() {
		return empType;
	}
	public void setEmpType(Integer empType) {
		this.empType = empType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empType == null) ? 0 : empType.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idDep == null) ? 0 : idDep.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		long temp;
		temp = Double.doubleToLongBits(reimbursementLeft);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((reportsto == null) ? 0 : reportsto.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empType == null) {
			if (other.empType != null)
				return false;
		} else if (!empType.equals(other.empType))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idDep == null) {
			if (other.idDep != null)
				return false;
		} else if (!idDep.equals(other.idDep))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (Double.doubleToLongBits(reimbursementLeft) != Double.doubleToLongBits(other.reimbursementLeft))
			return false;
		if (reportsto == null) {
			if (other.reportsto != null)
				return false;
		} else if (!reportsto.equals(other.reportsto))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", pass=" + pass + ", title=" + title + ", reportsto=" + reportsto + ", id_dep=" + idDep
				+ ", reimbursementLeft=" + reimbursementLeft + ", empType=" + empType + "]";
	}
	
}
	