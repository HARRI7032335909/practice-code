package com.practice.core.models.impl;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.practice.core.models.Venuanna;

@Model(adaptables=Resource.class,
adapters=Venuanna.class,
defaultInjectionStrategy =DefaultInjectionStrategy.OPTIONAL
)

public class Venuannaimpl implements Venuanna {
	
	@Inject
	private String title1;
	@Inject
	private String title2;
	@Inject
	private String title3;
	@Inject
	private String title4;
	@Inject
	private String title5;
	@Inject
	private String title6;

	@Override
	public String getHouseaddress() {
		// TODO Auto-generated method stub
		return title1;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return title2;
	}

	@Override
	public String getContactnumber() {
		// TODO Auto-generated method stub
		return title3;
	}

	@Override
	public String getRadio() {
		// TODO Auto-generated method stub
		return title4;
	}

	@Override
	public String getCheckbox() {
		// TODO Auto-generated method stub
		return title5;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return title6;
	}

}


