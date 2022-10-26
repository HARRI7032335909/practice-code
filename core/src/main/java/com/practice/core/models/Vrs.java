
package com.practice.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class)
public class Vrs {
	@Inject @Optional
    private String title1;
    @Inject @Optional 
    private String title2;
    @Inject @Optional 
    private int title3;
    
    private int title4;
    
    
    @PostConstruct
    protected void init() {
  title4=Integer.parseInt(title1+title2)+ Integer.parseInt(title2);
    }

	public int getTitle4() {
		return title4;
	}

	public void setTitle4(int title4) {
		this.title4 = title4;
	}

    

	
      
    }


