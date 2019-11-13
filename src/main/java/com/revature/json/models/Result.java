package com.revature.json.models;

public class Result {
	private String status;
	private String error_message;
	private Integer duration;

	public Result() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Result)) {
			return false;
		}
		Result other = (Result) obj;
		if (this.duration == null) {
			if (other.duration != null) {
				return false;
			}
		}
		else if (!this.duration.equals(other.duration)) {
			return false;
		}
		if (this.error_message == null) {
			if (other.error_message != null) {
				return false;
			}
		}
		else if (!this.error_message.equals(other.error_message)) {
			return false;
		}
		if (this.status == null) {
			if (other.status != null) {
				return false;
			}
		}
		else if (!this.status.equals(other.status)) {
			return false;
		}
		return true;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public String getStatus() {
		return this.status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
			+ ((this.duration == null) ? 0 : this.duration.hashCode());
		result = prime * result + ((this.error_message == null) ? 0
			: this.error_message.hashCode());
		result = prime * result
			+ ((this.status == null) ? 0 : this.status.hashCode());
		return result;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Result [status=" + this.status + ", error_message="
			+ this.error_message + ", duration=" + this.duration + "]";
	}
}
