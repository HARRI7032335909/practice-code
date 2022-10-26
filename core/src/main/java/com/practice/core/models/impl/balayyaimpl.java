package com.practice.core.models.impl;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import com.practice.core.models.balayya;
@Model(adaptables=Resource.class,
adapters=balayya.class)

public class balayyaimpl implements balayya{
	
	
	@Inject
	private String fname;
	
	@Inject
	private String linkURL;
	
	@Inject
	private String lname;
	
	
	
	

	@Override
	public String getFirtsname() {
		// TODO Auto-generated method stub
		return fname;
	}

	@Override
	public String getLink() {
		// TODO Auto-generated method stub
		return linkURL;
	}

	@Override
	public String getSecondname() {
		// TODO Auto-generated method stub
		return lname;
	}

}
