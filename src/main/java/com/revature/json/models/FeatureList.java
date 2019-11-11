package com.revature.json.models;

import java.util.Arrays;

public class FeatureList {
	private Feature[] features;

	public FeatureList() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof FeatureList)) {
			return false;
		}
		FeatureList other = (FeatureList) obj;
		if (!Arrays.equals(this.features, other.features)) {
			return false;
		}
		return true;
	}

	public Feature[] getFeatures() {
		return this.features;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(this.features);
		return result;
	}

	public void setFeatures(Feature[] features) {
		this.features = features;
	}

	@Override
	public String toString() {
		return "FeatureList [features=" + Arrays.toString(this.features) + "]";
	}
}
