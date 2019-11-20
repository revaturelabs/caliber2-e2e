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

	public int getBatchid() {
		return batchid;
	}

	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}

	public String getTrainingname() {
		return trainingname;
	}

	public void setTrainingname(String trainingname) {
		this.trainingname = trainingname;
	}

	public String getTrainingtype() {
		return trainingtype;
	}

	public void setTrainingtype(String trainingtype) {
		this.trainingtype = trainingtype;
	}

	public String getSkilltype() {
		return skilltype;
	}

	public void setSkilltype(String skilltype) {
		this.skilltype = skilltype;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getCotrainer() {
		return cotrainer;
	}

	public void setCotrainer(String cotrainer) {
		this.cotrainer = cotrainer;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getLocationid() {
		return locationid;
	}

	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}

	public int getStartdate() {
		return startdate;
	}

	public void setStartdate(int startdate) {
		this.startdate = startdate;
	}

	public int getEnddate() {
		return enddate;
	}

	public void setEnddate(int enddate) {
		this.enddate = enddate;
	}

	public int getGoodgrade() {
		return goodgrade;
	}

	public void setGoodgrade(int goodgrade) {
		this.goodgrade = goodgrade;
	}

	public int getPassinggrade() {
		return passinggrade;
	}

	public void setPassinggrade(int passinggrade) {
		this.passinggrade = passinggrade;
	}

	public int getTraineecount() {
		return traineecount;
	}

	public void setTraineecount(int traineecount) {
		this.traineecount = traineecount;
	}

	public int getWeeks() {
		return weeks;
	}

	public void setWeeks(int weeks) {
		this.weeks = weeks;
	}

	@Override
	public String toString() {
		return "Batch [batchid=" + batchid + ", trainingname=" + trainingname
			+ ", trainingtype=" + trainingtype + ", skilltype=" + skilltype
			+ ", trainer=" + trainer + ", cotrainer=" + cotrainer
			+ ", location=" + location + ", locationid=" + locationid
			+ ", startdate=" + startdate + ", enddate=" + enddate
			+ ", goodgrade=" + goodgrade + ", passinggrade=" + passinggrade
			+ ", traineecount=" + traineecount + ", weeks=" + weeks + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batchid;
		result =
			prime * result + ((cotrainer == null) ? 0 : cotrainer.hashCode());
		result = prime * result + enddate;
		result = prime * result + goodgrade;
		result =
			prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + locationid;
		result = prime * result + passinggrade;
		result =
			prime * result + ((skilltype == null) ? 0 : skilltype.hashCode());
		result = prime * result + startdate;
		result = prime * result + traineecount;
		result = prime * result + ((trainer == null) ? 0 : trainer.hashCode());
		result = prime * result
			+ ((trainingname == null) ? 0 : trainingname.hashCode());
		result = prime * result
			+ ((trainingtype == null) ? 0 : trainingtype.hashCode());
		result = prime * result + weeks;
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
		Batch other = (Batch) obj;
		if (batchid != other.batchid)
			return false;
		if (cotrainer == null) {
			if (other.cotrainer != null)
				return false;
		}
		else if (!cotrainer.equals(other.cotrainer))
			return false;
		if (enddate != other.enddate)
			return false;
		if (goodgrade != other.goodgrade)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		}
		else if (!location.equals(other.location))
			return false;
		if (locationid != other.locationid)
			return false;
		if (passinggrade != other.passinggrade)
			return false;
		if (skilltype == null) {
			if (other.skilltype != null)
				return false;
		}
		else if (!skilltype.equals(other.skilltype))
			return false;
		if (startdate != other.startdate)
			return false;
		if (traineecount != other.traineecount)
			return false;
		if (trainer == null) {
			if (other.trainer != null)
				return false;
		}
		else if (!trainer.equals(other.trainer))
			return false;
		if (trainingname == null) {
			if (other.trainingname != null)
				return false;
		}
		else if (!trainingname.equals(other.trainingname))
			return false;
		if (trainingtype == null) {
			if (other.trainingtype != null)
				return false;
		}
		else if (!trainingtype.equals(other.trainingtype))
			return false;
		if (weeks != other.weeks)
			return false;
		return true;
	}

}
