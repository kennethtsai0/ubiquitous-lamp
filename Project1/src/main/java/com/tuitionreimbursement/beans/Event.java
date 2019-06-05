package com.tuitionreimbursement.beans;

public class Event {
	private Integer id;
	private String event;
	private Integer coverage;
	private Integer passing;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public Integer getCoverage() {
		return coverage;
	}
	public void setCoverage(Integer coverage) {
		this.coverage = coverage;
	}
	public Integer getPassing() {
		return passing;
	}
	public void setPassing(Integer passing) {
		this.passing = passing;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coverage == null) ? 0 : coverage.hashCode());
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((passing == null) ? 0 : passing.hashCode());
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
		Event other = (Event) obj;
		if (coverage == null) {
			if (other.coverage != null)
				return false;
		} else if (!coverage.equals(other.coverage))
			return false;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (passing == null) {
			if (other.passing != null)
				return false;
		} else if (!passing.equals(other.passing))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", event=" + event + ", coverage=" + coverage + ", passing=" + passing + "]";
	}
	
}
