package com.practice.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;


@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class UserModel {

	@Inject 
	private String haddress;
	
	@Inject
	private String cnumber;
	
	@Inject
	private String uname;

	public String getHaddress() {
		return haddress;
	}

	public String getCnumber() {
		return cnumber;
	}

	public String getUname() {
		return uname;
	}
	



	
}