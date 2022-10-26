package com.practice.core.models.impl;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.sling.models.annotations.Model;

import com.practice.core.models.Slingmodel;

@Model(adaptables=Resource.class)
public class SlingmodelImpl implements Slingmodel {
	
	@Inject
	String title1;
	
	@Inject
	String id;
	
	@Inject
	String title2;

	@Override
	public String getTitle1() {
		// TODO Auto-generated method stub
		return title1;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getTitle2() {
		// TODO Auto-generated method stub
		return title2;
	}

}
