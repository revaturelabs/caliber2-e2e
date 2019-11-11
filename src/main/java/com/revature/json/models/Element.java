package com.revature.json.models;

import java.util.Arrays;

public class Element {

	private Integer line;
	private String name;
	private String description;
	private String type;
	private String keyword;
	private Step[] steps;

	private Tag[] tags;

	public Element() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Element)) {
			return false;
		}
		Element other = (Element) obj;
		if (this.description == null) {
			if (other.description != null) {
				return false;
			}
		}
		else if (!this.description.equals(other.description)) {
			return false;
		}
		if (this.keyword == null) {
			if (other.keyword != null) {
				return false;
			}
		}
		else if (!this.keyword.equals(other.keyword)) {
			return false;
		}
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
		if (!Arrays.equals(this.steps, other.steps)) {
			return false;
		}
		if (!Arrays.equals(this.tags, other.tags)) {
			return false;
		}
		if (this.type == null) {
			if (other.type != null) {
				return false;
			}
		}
		else if (!this.type.equals(other.type)) {
			return false;
		}
		return true;
	}

	public String getDescription() {
		return this.description;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public Integer getLine() {
		return this.line;
	}

	public String getName() {
		return this.name;
	}

	public Step[] getSteps() {
		return this.steps;
	}

	public Tag[] getTags() {
		return this.tags;
	}

	public String getType() {
		return this.type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
			+ ((this.description == null) ? 0 : this.description.hashCode());
		result = prime * result
			+ ((this.keyword == null) ? 0 : this.keyword.hashCode());
		result =
			prime * result + ((this.line == null) ? 0 : this.line.hashCode());
		result =
			prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + Arrays.hashCode(this.steps);
		result = prime * result + Arrays.hashCode(this.tags);
		result =
			prime * result + ((this.type == null) ? 0 : this.type.hashCode());
		return result;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSteps(Step[] steps) {
		this.steps = steps;
	}

	public void setTags(Tag[] tags) {
		this.tags = tags;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Element [line=" + this.line + ", name=" + this.name
			+ ", description=" + this.description + ", type=" + this.type
			+ ", keyword=" + this.keyword + ", steps="
			+ Arrays.toString(this.steps) + ", tags="
			+ Arrays.toString(this.tags) + "]";
	}
}
