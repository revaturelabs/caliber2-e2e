package com.revature.entity;

public class Trainee {
	private int traineeid;
	private String resourceid;
	private String name;
	private String email;
	private String trianingstatus;
	private int batchid;
	private String phonenumber;
	private String skypeid;
	private String recruitername;
	private String college;
	private String degree;
	private String major;
	private String techscreenername;
	private int techscreenscore;
	private String projectcompletion;
	private String flagstatus;
	private String flagnotes;
	private String flagauthoer;
	private String flagtimestamp;

	public Trainee() {
		super();
	}

	public Trainee(int traineeid, String resourceid, String name, String email,
		String trianingstatus, int batchid, String phonenumber, String skypeid,
		String recruitername, String college, String degree, String major,
		String techscreenername, int techscreenscore, String projectcompletion,
		String flagstatus, String flagnotes, String flagauthoer,
		String flagtimestamp) {
		super();
		this.traineeid = traineeid;
		this.resourceid = resourceid;
		this.name = name;
		this.email = email;
		this.trianingstatus = trianingstatus;
		this.batchid = batchid;
		this.phonenumber = phonenumber;
		this.skypeid = skypeid;
		this.recruitername = recruitername;
		this.college = college;
		this.degree = degree;
		this.major = major;
		this.techscreenername = techscreenername;
		this.techscreenscore = techscreenscore;
		this.projectcompletion = projectcompletion;
		this.flagstatus = flagstatus;
		this.flagnotes = flagnotes;
		this.flagauthoer = flagauthoer;
		this.flagtimestamp = flagtimestamp;
	}

	public int getTraineeid() {
		return traineeid;
	}

	public void setTraineeid(int traineeid) {
		this.traineeid = traineeid;
	}

	public String getResourceid() {
		return resourceid;
	}

	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTrianingstatus() {
		return trianingstatus;
	}

	public void setTrianingstatus(String trianingstatus) {
		this.trianingstatus = trianingstatus;
	}

	public int getBatchid() {
		return batchid;
	}

	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getSkypeid() {
		return skypeid;
	}

	public void setSkypeid(String skypeid) {
		this.skypeid = skypeid;
	}

	public String getRecruitername() {
		return recruitername;
	}

	public void setRecruitername(String recruitername) {
		this.recruitername = recruitername;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getTechscreenername() {
		return techscreenername;
	}

	public void setTechscreenername(String techscreenername) {
		this.techscreenername = techscreenername;
	}

	public int getTechscreenscore() {
		return techscreenscore;
	}

	public void setTechscreenscore(int techscreenscore) {
		this.techscreenscore = techscreenscore;
	}

	public String getProjectcompletion() {
		return projectcompletion;
	}

	public void setProjectcompletion(String projectcompletion) {
		this.projectcompletion = projectcompletion;
	}

	public String getFlagstatus() {
		return flagstatus;
	}

	public void setFlagstatus(String flagstatus) {
		this.flagstatus = flagstatus;
	}

	public String getFlagnotes() {
		return flagnotes;
	}

	public void setFlagnotes(String flagnotes) {
		this.flagnotes = flagnotes;
	}

	public String getFlagauthoer() {
		return flagauthoer;
	}

	public void setFlagauthoer(String flagauthoer) {
		this.flagauthoer = flagauthoer;
	}

	public String getFlagtimestamp() {
		return flagtimestamp;
	}

	public void setFlagtimestamp(String flagtimestamp) {
		this.flagtimestamp = flagtimestamp;
	}

	@Override
	public String toString() {
		return this.getName() + " " + this.getEmail() + " "
			+ this.getTrianingstatus() + " " + this.getPhonenumber() + " "
			+ this.getSkypeid() + " " + this.getResourceid() + " "
			+ this.getRecruitername() + " " + this.getCollege() + " "
			+ this.getDegree() + "/" + this.getMajor() + " "
			+ this.getTechscreenername() + " " + this.getProjectcompletion();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batchid;
		result = prime * result + ((college == null) ? 0 : college.hashCode());
		result = prime * result + ((degree == null) ? 0 : degree.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
			+ ((flagauthoer == null) ? 0 : flagauthoer.hashCode());
		result =
			prime * result + ((flagnotes == null) ? 0 : flagnotes.hashCode());
		result =
			prime * result + ((flagstatus == null) ? 0 : flagstatus.hashCode());
		result = prime * result
			+ ((flagtimestamp == null) ? 0 : flagtimestamp.hashCode());
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
			+ ((phonenumber == null) ? 0 : phonenumber.hashCode());
		result = prime * result
			+ ((projectcompletion == null) ? 0 : projectcompletion.hashCode());
		result = prime * result
			+ ((recruitername == null) ? 0 : recruitername.hashCode());
		result =
			prime * result + ((resourceid == null) ? 0 : resourceid.hashCode());
		result = prime * result + ((skypeid == null) ? 0 : skypeid.hashCode());
		result = prime * result
			+ ((techscreenername == null) ? 0 : techscreenername.hashCode());
		result = prime * result + techscreenscore;
		result = prime * result + traineeid;
		result = prime * result
			+ ((trianingstatus == null) ? 0 : trianingstatus.hashCode());
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
		Trainee other = (Trainee) obj;
		if (batchid != other.batchid)
			return false;
		if (college == null) {
			if (other.college != null)
				return false;
		}
		else if (!college.equals(other.college))
			return false;
		if (degree == null) {
			if (other.degree != null)
				return false;
		}
		else if (!degree.equals(other.degree))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		}
		else if (!email.equals(other.email))
			return false;
		if (flagauthoer == null) {
			if (other.flagauthoer != null)
				return false;
		}
		else if (!flagauthoer.equals(other.flagauthoer))
			return false;
		if (flagnotes == null) {
			if (other.flagnotes != null)
				return false;
		}
		else if (!flagnotes.equals(other.flagnotes))
			return false;
		if (flagstatus == null) {
			if (other.flagstatus != null)
				return false;
		}
		else if (!flagstatus.equals(other.flagstatus))
			return false;
		if (flagtimestamp == null) {
			if (other.flagtimestamp != null)
				return false;
		}
		else if (!flagtimestamp.equals(other.flagtimestamp))
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		}
		else if (!major.equals(other.major))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		if (phonenumber == null) {
			if (other.phonenumber != null)
				return false;
		}
		else if (!phonenumber.equals(other.phonenumber))
			return false;
		if (projectcompletion == null) {
			if (other.projectcompletion != null)
				return false;
		}
		else if (!projectcompletion.equals(other.projectcompletion))
			return false;
		if (recruitername == null) {
			if (other.recruitername != null)
				return false;
		}
		else if (!recruitername.equals(other.recruitername))
			return false;
		if (resourceid == null) {
			if (other.resourceid != null)
				return false;
		}
		else if (!resourceid.equals(other.resourceid))
			return false;
		if (skypeid == null) {
			if (other.skypeid != null)
				return false;
		}
		else if (!skypeid.equals(other.skypeid))
			return false;
		if (techscreenername == null) {
			if (other.techscreenername != null)
				return false;
		}
		else if (!techscreenername.equals(other.techscreenername))
			return false;
		if (techscreenscore != other.techscreenscore)
			return false;
		if (traineeid != other.traineeid)
			return false;
		if (trianingstatus == null) {
			if (other.trianingstatus != null)
				return false;
		}
		else if (!trianingstatus.equals(other.trianingstatus))
			return false;
		return true;
	}

}
