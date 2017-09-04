package com.flowergarden.flowers;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.flowergarden.properties.FreshnessInteger;

@XmlRootElement
@XmlType(propOrder = {"spike"})
public class Rose extends GeneralFlower {

	@XmlElement
	private boolean spike;

	public Rose() {
		super(30, 30, new FreshnessInteger(1));
		this.spike = true;
	}

	public Rose(boolean spike, int lenght, float price, FreshnessInteger fresh){
		super(lenght, price, fresh);
		this.spike = spike;
		
	}

	public boolean getSpike(){
		return spike;
	}
}
