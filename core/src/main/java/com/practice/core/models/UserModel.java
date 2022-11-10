package com.practice.core.models;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class UserModel {

	@Inject @Named("title1")
	
	private String title;
	
	@Inject
	private String linkURL;
	
	@Inject
	private String title2;

	public String getTitle() {
		return title;
	}

	public String getLinkURL() {
		return linkURL;
	}

	public String getTitlehari() {
		return title2;
	}
	}