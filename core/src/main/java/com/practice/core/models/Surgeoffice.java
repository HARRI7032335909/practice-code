package com.practice.core.models;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import com.adobe.cq.sightly.WCMUsePojo;
import com.practice.core.models.impl.model;
@Model (adaptables=Resource.class)
public class Surgeoffice extends WCMUsePojo {
	@Inject
private String title1;
	@Inject
	private String title2;
	private int title3;
	
	@Override
	public void activate() throws Exception {
		title3=Integer.parseInt(title1)/Integer.parseInt(title2);
	}
	public int getTitle3() {
		return title3;
	}
	public void gettTitle3(int title3) {
		this.title3=title3;
	}
	}