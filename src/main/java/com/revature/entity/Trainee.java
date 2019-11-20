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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Trainee other = (Trainee) obj;
		if (this.batchid != other.batchid) {
			return false;
		}
		if (this.college == null) {
			if (other.college != null) {
				return false;
			}
		}
		else if (!this.college.equals(other.college)) {
			return false;
		}
		if (this.degree == null) {
			if (other.degree != null) {
				return false;
			}
		}
		else if (!this.degree.equals(other.degree)) {
			return false;
		}
		if (this.email == null) {
			if (other.email != null) {
				return false;
			}
		}
		else if (!this.email.equals(other.email)) {
			return false;
		}
		if (this.flagauthoer == null) {
			if (other.flagauthoer != null) {
				return false;
			}
		}
		else if (!this.flagauthoer.equals(other.flagauthoer)) {
			return false;
		}
		if (this.flagnotes == null) {
			if (other.flagnotes != null) {
				return false;
			}
		}
		else if (!this.flagnotes.equals(other.flagnotes)) {
			return false;
		}
		if (this.flagstatus == null) {
			if (other.flagstatus != null) {
				return false;
			}
		}
		else if (!this.flagstatus.equals(other.flagstatus)) {
			return false;
		}
		if (this.flagtimestamp == null) {
			if (other.flagtimestamp != null) {
				return false;
			}
		}
		else if (!this.flagtimestamp.equals(other.flagtimestamp)) {
			return false;
		}
		if (this.major == null) {
			if (other.major != null) {
				return false;
			}
		}
		else if (!this.major.equals(other.major)) {
			return false;
		}
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		}
		else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.phonenumber == null) {
			if (other.phonenumber != null) {
				return false;
			}
		}
		else if (!this.phonenumber.equals(other.phonenumber)) {
			return false;
		}
		if (this.projectcompletion == null) {
			if (other.projectcompletion != null) {
				return false;
			}
		}
		else if (!this.projectcompletion.equals(other.projectcompletion)) {
			return false;
		}
		if (this.recruitername == null) {
			if (other.recruitername != null) {
				return false;
			}
		}
		else if (!this.recruitername.equals(other.recruitername)) {
			return false;
		}
		if (this.resourceid == null) {
			if (other.resourceid != null) {
				return false;
			}
		}
		else if (!this.resourceid.equals(other.resourceid)) {
			return false;
		}
		if (this.skypeid == null) {
			if (other.skypeid != null) {
				return false;
			}
		}
		else if (!this.skypeid.equals(other.skypeid)) {
			return false;
		}
		if (this.techscreenername == null) {
			if (other.techscreenername != null) {
				return false;
			}
		}
		else if (!this.techscreenername.equals(other.techscreenername)) {
			return false;
		}
		if (this.techscreenscore != other.techscreenscore) {
			return false;
		}
		if (this.traineeid != other.traineeid) {
			return false;
		}
		if (this.trianingstatus == null) {
			if (other.trianingstatus != null) {
				return false;
			}
		}
		else if (!this.trianingstatus.equals(other.trianingstatus)) {
			return false;
		}
		return true;
	}

	public int getBatchid() {
		return this.batchid;
	}

	public String getCollege() {
		return this.college;
	}

	public String getDegree() {
		return this.degree;
	}

	public String getEmail() {
		return this.email;
	}

	public String getFlagauthoer() {
		return this.flagauthoer;
	}

	public String getFlagnotes() {
		return this.flagnotes;
	}

	public String getFlagstatus() {
		return this.flagstatus;
	}

	public String getFlagtimestamp() {
		return this.flagtimestamp;
	}

	public String getMajor() {
		return this.major;
	}

	public String getName() {
		return this.name;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public String getProjectcompletion() {
		return this.projectcompletion;
	}

	public String getRecruitername() {
		return this.recruitername;
	}

	public String getResourceid() {
		return this.resourceid;
	}

	public String getSkypeid() {
		return this.skypeid;
	}

	public String getTechscreenername() {
		return this.techscreenername;
	}

	public int getTechscreenscore() {
		return this.techscreenscore;
	}

	public int getTraineeid() {
		return this.traineeid;
	}

	public String getTrianingstatus() {
		return this.trianingstatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.batchid;
		result = prime * result
			+ ((this.college == null) ? 0 : this.college.hashCode());
		result = prime * result
			+ ((this.degree == null) ? 0 : this.degree.hashCode());
		result =
			prime * result + ((this.email == null) ? 0 : this.email.hashCode());
		result = prime * result
			+ ((this.flagauthoer == null) ? 0 : this.flagauthoer.hashCode());
		result = prime * result
			+ ((this.flagnotes == null) ? 0 : this.flagnotes.hashCode());
		result = prime * result
			+ ((this.flagstatus == null) ? 0 : this.flagstatus.hashCode());
		result = prime * result + ((this.flagtimestamp == null) ? 0
			: this.flagtimestamp.hashCode());
		result =
			prime * result + ((this.major == null) ? 0 : this.major.hashCode());
		result =
			prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result
			+ ((this.phonenumber == null) ? 0 : this.phonenumber.hashCode());
		result = prime * result + ((this.projectcompletion == null) ? 0
			: this.projectcompletion.hashCode());
		result = prime * result + ((this.recruitername == null) ? 0
			: this.recruitername.hashCode());
		result = prime * result
			+ ((this.resourceid == null) ? 0 : this.resourceid.hashCode());
		result = prime * result
			+ ((this.skypeid == null) ? 0 : this.skypeid.hashCode());
		result = prime * result + ((this.techscreenername == null) ? 0
			: this.techscreenername.hashCode());
		result = prime * result + this.techscreenscore;
		result = prime * result + this.traineeid;
		result = prime * result + ((this.trianingstatus == null) ? 0
			: this.trianingstatus.hashCode());
		return result;
	}

	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFlagauthoer(String flagauthoer) {
		this.flagauthoer = flagauthoer;
	}

	public void setFlagnotes(String flagnotes) {
		this.flagnotes = flagnotes;
	}

	public void setFlagstatus(String flagstatus) {
		this.flagstatus = flagstatus;
	}

	public void setFlagtimestamp(String flagtimestamp) {
		this.flagtimestamp = flagtimestamp;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public void setProjectcompletion(String projectcompletion) {
		this.projectcompletion = projectcompletion;
	}

	public void setRecruitername(String recruitername) {
		this.recruitername = recruitername;
	}

	public void setResourceid(String resourceid) {
		this.resourceid = resourceid;
	}

	public void setSkypeid(String skypeid) {
		this.skypeid = skypeid;
	}

	public void setTechscreenername(String techscreenername) {
		this.techscreenername = techscreenername;
	}

	public void setTechscreenscore(int techscreenscore) {
		this.techscreenscore = techscreenscore;
	}

	public void setTraineeid(int traineeid) {
		this.traineeid = traineeid;
	}

	public void setTrianingstatus(String trianingstatus) {
		this.trianingstatus = trianingstatus;
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

}
