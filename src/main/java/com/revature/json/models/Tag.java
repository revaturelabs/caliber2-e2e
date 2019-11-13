package com.revature.json.models;

public class Tag {
	private String name;
	private Integer line;

	public Tag() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Tag)) {
			return false;
		}
		Tag other = (Tag) obj;
		if (this.line == null) {
			if (other.line != null) {
				return false;
			}
		}
		else if (!this.line.equals(other.line)) {
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
		return true;
	}

	public Integer getLine() {
		return this.line;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result =
			prime * result + ((this.line == null) ? 0 : this.line.hashCode());
		result =
			prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Tag [name=" + this.name + ", line=" + this.line + "]";
	}
}
