package com.revature.json.models;

import java.util.Arrays;

public class Step {
	private Result result;
	private Integer line;
	private String name;
	private Match match;
	private String keyword;
	private Integer[] matchedColumns;

	public Step() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Step)) {
			return false;
		}
		Step other = (Step) obj;
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
		if (this.match == null) {
			if (other.match != null) {
				return false;
			}
		}
		else if (!this.match.equals(other.match)) {
			return false;
		}
		if (!Arrays.equals(this.matchedColumns, other.matchedColumns)) {
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
		if (this.result == null) {
			if (other.result != null) {
				return false;
			}
		}
		else if (!this.result.equals(other.result)) {
			return false;
		}
		return true;
	}

	public Integer getLine() {
		return this.line;
	}

	public Match getMatch() {
		return this.match;
	}

	public Integer[] getMatchedColumns() {
		return this.matchedColumns;
	}

	public String getName() {
		return this.name;
	}

	public Result getResult() {
		return this.result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
			+ ((this.keyword == null) ? 0 : this.keyword.hashCode());
		result =
			prime * result + ((this.line == null) ? 0 : this.line.hashCode());
		result =
			prime * result + ((this.match == null) ? 0 : this.match.hashCode());
		result = prime * result + Arrays.hashCode(this.matchedColumns);
		result =
			prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result
			+ ((this.result == null) ? 0 : this.result.hashCode());
		return result;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public void setMatchedColumns(Integer[] matchedColumns) {
		this.matchedColumns = matchedColumns;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Step [result=" + this.result + ", line=" + this.line + ", name="
			+ this.name + ", match=" + this.match + ", keyword=" + this.keyword
			+ ", matchedColumns=" + Arrays.toString(this.matchedColumns) + "]";
	}
}
