package com.revature.json.models;

import java.util.Arrays;

public class Feature {

	private Integer line;
	private Element[] elements;
	private String name;
	private String description;
	private String id;
	private String keyword;
	private String uri;

	public Feature() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Feature)) {
			return false;
		}
		Feature other = (Feature) obj;
		if (this.description == null) {
			if (other.description != null) {
				return false;
			}
		}
		else if (!this.description.equals(other.description)) {
			return false;
		}
		if (!Arrays.equals(this.elements, other.elements)) {
			return false;
		}
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		}
		else if (!this.id.equals(other.id)) {
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
		if (this.uri == null) {
			if (other.uri != null) {
				return false;
			}
		}
		else if (!this.uri.equals(other.uri)) {
			return false;
		}
		return true;
	}

	public String getDescription() {
		return this.description;
	}

	public Element[] getElements() {
		return this.elements;
	}

	public String getId() {
		return this.id;
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

	public String getUri() {
		return this.uri;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
			+ ((this.description == null) ? 0 : this.description.hashCode());
		result = prime * result + Arrays.hashCode(this.elements);
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result
			+ ((this.keyword == null) ? 0 : this.keyword.hashCode());
		result =
			prime * result + ((this.line == null) ? 0 : this.line.hashCode());
		result =
			prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result =
			prime * result + ((this.uri == null) ? 0 : this.uri.hashCode());
		return result;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setElements(Element[] elements) {
		this.elements = elements;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return "Feature [line=" + this.line + ", elements="
			+ Arrays.toString(this.elements) + ", name=" + this.name
			+ ", description=" + this.description + ", id=" + this.id
			+ ", keyword=" + this.keyword + ", uri=" + this.uri + "]";
	}
}
