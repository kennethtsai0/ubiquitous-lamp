package com.tuitionreimbursement.beans;

public class Department {
	private Integer id;
	private String departmentname;
	private Integer idDepHead;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public Integer getIdDepHead() {
		return idDepHead;
	}
	public void setIdDepHead(Integer idDepHead) {
		this.idDepHead = idDepHead;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentname == null) ? 0 : departmentname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idDepHead == null) ? 0 : idDepHead.hashCode());
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
		Department other = (Department) obj;
		if (departmentname == null) {
			if (other.departmentname != null)
				return false;
		} else if (!departmentname.equals(other.departmentname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idDepHead == null) {
			if (other.idDepHead != null)
				return false;
		} else if (!idDepHead.equals(other.idDepHead))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentname=" + departmentname + ", idDepHead=" + idDepHead + "]";
	}
	
}
