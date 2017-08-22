package com.flowergarden.properties;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class FreshnessInteger implements Freshness<Integer>, Comparable<FreshnessInteger> {

	private Integer freshness;
	
	@Override
	public Integer getFreshness() {
		return freshness;
	}
	
	public FreshnessInteger(Integer freshness){
		this.freshness = freshness;
	}
	
	public FreshnessInteger(){
		
	}

	@Override
	public int compareTo(FreshnessInteger o) {
		if (freshness > o.getFreshness()) return 1;
		if (freshness < o.getFreshness()) return -1;
		return 0;
	}

}
