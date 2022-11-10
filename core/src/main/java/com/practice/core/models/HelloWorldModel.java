package com.practice.core.models;

import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;



import javax.annotation.PostConstruct;
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.settings.SlingSettingsService;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.practice.core.survices.NewService;

import java.util.Optional;
@Model(adaptables = Resource.class)

public class HelloWorldModel{
	
    @ValueMapValue(name=PROPERTY_RESOURCE_TYPE, injectionStrategy=InjectionStrategy.OPTIONAL)
    @Default(values="No resourceType")
     protected String resourceType;
    
    @OSGiService
    private SlingSettingsService settings;
    
    @SlingObject
    private Resource currentResource;
    
    @SlingObject
    private ResourceResolver resourceResolver;
    
    private String message;
    
     @OSGiService
     private NewService newservice;
    
    @PostConstruct
    protected void init() {
        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        String currentPagePath = Optional.ofNullable(pageManager)
                .map(pm -> pm.getContainingPage(currentResource))
                
                .map(Page::getPath).orElse("");

        message = "Hello World!\n"
            + "Resource type is: " + resourceType + "\n"
            + "Current page is:  " + currentPagePath + "\n"
            + "This is instance: " + settings.getSlingId() + "\n"+ newservice.getServiceMessage();
    }

    public String getMessage() {
    return message;
    }

}