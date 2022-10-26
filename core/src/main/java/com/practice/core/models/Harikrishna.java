package com.practice.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class)
public class Harikrishna {
	Logger LOG = LoggerFactory.getLogger(Harikrishna.class);
	@Inject @Optional
    private String title1;
    @Inject @Optional 
    private String title2;
    @Inject @Optional 
    private int title3;
    
    
    
    
    @PostConstruct
    protected void init() {
  title3=Integer.parseInt(title1)/Integer.parseInt(title2);
    }

	public int getTitle4() {
		return title3;
	}

	public void setTitle4(int title4) {
		this.title3 = title4;
	}

    

	
      
    }