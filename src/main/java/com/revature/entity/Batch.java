package com.revature.entity;

public class Batch {
	private int batchid;
	private String trainingname;
	private String trainingtype;
	private String skilltype;
	private String trainer;
	private String cotrainer;
	private String location;
	private int locationid;
	private int startdate;
	private int enddate;
	private int goodgrade;
	private int passinggrade;
	private int traineecount;
	private int weeks;

	public Batch() {
		super();
	}

	public Batch(int batchid, String trainingname, String trainingtype,
		String skilltype, String trainer, String cotrainer, String location,
		int locationid, int startdate, int enddate, int goodgrade,
		int passinggrade, int traineecount, int weeks) {
		super();
		this.batchid = batchid;
		this.trainingname = trainingname;
		this.trainingtype = trainingtype;
		this.skilltype = skilltype;
		this.trainer = trainer;
		this.cotrainer = cotrainer;
		this.location = location;
		this.locationid = locationid;
		this.startdate = startdate;
		this.enddate = enddate;
		this.goodgrade = goodgrade;
		this.passinggrade = passinggrade;
		this.traineecount = traineecount;
		this.weeks = weeks;
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
		Batch other = (Batch) obj;
		if (this.batchid != other.batchid) {
			return false;
		}
		if (this.cotrainer == null) {
			if (other.cotrainer != null) {
				return false;
			}
		}
		else if (!this.cotrainer.equals(other.cotrainer)) {
			return false;
		}
		if (this.enddate != other.enddate) {
			return false;
		}
		if (this.goodgrade != other.goodgrade) {
			return false;
		}
		if (this.location == null) {
			if (other.location != null) {
				return false;
			}
		}
		else if (!this.location.equals(other.location)) {
			return false;
		}
		if (this.locationid != other.locationid) {
			return false;
		}
		if (this.passinggrade != other.passinggrade) {
			return false;
		}
		if (this.skilltype == null) {
			if (other.skilltype != null) {
				return false;
			}
		}
		else if (!this.skilltype.equals(other.skilltype)) {
			return false;
		}
		if (this.startdate != other.startdate) {
			return false;
		}
		if (this.traineecount != other.traineecount) {
			return false;
		}
		if (this.trainer == null) {
			if (other.trainer != null) {
				return false;
			}
		}
		else if (!this.trainer.equals(other.trainer)) {
			return false;
		}
		if (this.trainingname == null) {
			if (other.trainingname != null) {
				return false;
			}
		}
		else if (!this.trainingname.equals(other.trainingname)) {
			return false;
		}
		if (this.trainingtype == null) {
			if (other.trainingtype != null) {
				return false;
			}
		}
		else if (!this.trainingtype.equals(other.trainingtype)) {
			return false;
		}
		if (this.weeks != other.weeks) {
			return false;
		}
		return true;
	}

	public int getBatchid() {
		return this.batchid;
	}

	public String getCotrainer() {
		return this.cotrainer;
	}

	public int getEnddate() {
		return this.enddate;
	}

	public int getGoodgrade() {
		return this.goodgrade;
	}

	public String getLocation() {
		return this.location;
	}

	public int getLocationid() {
		return this.locationid;
	}

	public int getPassinggrade() {
		return this.passinggrade;
	}

	public String getSkilltype() {
		return this.skilltype;
	}

	public int getStartdate() {
		return this.startdate;
	}

	public int getTraineecount() {
		return this.traineecount;
	}

	public String getTrainer() {
		return this.trainer;
	}

	public String getTrainingname() {
		return this.trainingname;
	}

	public String getTrainingtype() {
		return this.trainingtype;
	}

	public int getWeeks() {
		return this.weeks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.batchid;
		result = prime * result
			+ ((this.cotrainer == null) ? 0 : this.cotrainer.hashCode());
		result = prime * result + this.enddate;
		result = prime * result + this.goodgrade;
		result = prime * result
			+ ((this.location == null) ? 0 : this.location.hashCode());
		result = prime * result + this.locationid;
		result = prime * result + this.passinggrade;
		result = prime * result
			+ ((this.skilltype == null) ? 0 : this.skilltype.hashCode());
		result = prime * result + this.startdate;
		result = prime * result + this.traineecount;
		result = prime * result
			+ ((this.trainer == null) ? 0 : this.trainer.hashCode());
		result = prime * result
			+ ((this.trainingname == null) ? 0 : this.trainingname.hashCode());
		result = prime * result
			+ ((this.trainingtype == null) ? 0 : this.trainingtype.hashCode());
		result = prime * result + this.weeks;
		return result;
	}

	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}

	public void setCotrainer(String cotrainer) {
		this.cotrainer = cotrainer;
	}

	public void setEnddate(int enddate) {
		this.enddate = enddate;
	}

	public void setGoodgrade(int goodgrade) {
		this.goodgrade = goodgrade;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}

	public void setPassinggrade(int passinggrade) {
		this.passinggrade = passinggrade;
	}

	public void setSkilltype(String skilltype) {
		this.skilltype = skilltype;
	}

	public void setStartdate(int startdate) {
		this.startdate = startdate;
	}

	public void setTraineecount(int traineecount) {
		this.traineecount = traineecount;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public void setTrainingname(String trainingname) {
		this.trainingname = trainingname;
	}

	public void setTrainingtype(String trainingtype) {
		this.trainingtype = trainingtype;
	}

	public void setWeeks(int weeks) {
		this.weeks = weeks;
	}

	@Override
	public String toString() {
		return "Batch [batchid=" + this.batchid + ", trainingname="
			+ this.trainingname + ", trainingtype=" + this.trainingtype
			+ ", skilltype=" + this.skilltype + ", trainer=" + this.trainer
			+ ", cotrainer=" + this.cotrainer + ", location=" + this.location
			+ ", locationid=" + this.locationid + ", startdate="
			+ this.startdate + ", enddate=" + this.enddate + ", goodgrade="
			+ this.goodgrade + ", passinggrade=" + this.passinggrade
			+ ", traineecount=" + this.traineecount + ", weeks=" + this.weeks
			+ "]";
	}

}
