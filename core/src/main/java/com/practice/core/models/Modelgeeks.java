package com.practice.core.models;

import java.util.Iterator;

import javax.inject.Inject;

import com.day.cq.wcm.api.Page;
import com.practice.core.survices.DemoService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Filter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.practice.core.survices.DemoService;

@Model(adaptables = Resource.class)
public class Modelgeeks {
	//we can take data from the service(Demoservice.java) to inject in the in sling model by using annotation like as @Inject 
	@Inject
	DemoService demoService1;//Demoservice is service name $ demoservice is the variable name
	//this is the another way to take data  from the survices to sling modal by using the annotation like @OSGiServices
	@OSGiService @Filter("component.name=Vishnu")
	DemoService demoService2;
	//@Filters are used to when 2 implementation are there among those compiler will to take for ("component.name=Vishnu") this is given for clarification
	
	public Iterator<Page> getpaper(){
		String str="";
		Iterator<Page> pages=demoService1.getPages();
		return pages;
	}
}

		// Iterator<Page> it data type for the getpaper() method 


