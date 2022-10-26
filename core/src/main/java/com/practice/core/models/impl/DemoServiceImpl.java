package com.practice.core.models.impl;
	
	  import com.practice.core.models.ResolverUtil;
    import com.practice.core.survices.DemoService;

	import com.day.cq.wcm.api.Page;
	import com.day.cq.wcm.api.PageManager;
	import org.apache.sling.api.resource.LoginException;
	import org.apache.sling.api.resource.ResourceResolver;
	import org.apache.sling.api.resource.ResourceResolverFactory;
	import org.apache.sling.jcr.api.SlingRepository;
	import org.osgi.service.component.ComponentContext;
	import org.osgi.service.component.annotations.*;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import javax.jcr.RepositoryException;
	import javax.jcr.Session;
	import java.util.Iterator;
	import java.util.List;
//DemoService it is the interface 
	   @Component(service = DemoService.class,immediate = true,name = "Hari")
	    public class DemoServiceImpl implements DemoService {
	    private static final Logger LOG= LoggerFactory.getLogger(DemoServiceImpl.class);

	    @Reference
	    private ResourceResolverFactory resourceResolverFactory;
        //ResourceResolverFactory it is the predefined survice for that we have use the @Refernce 
	    //it is object for that the survice
	    @Reference
	    private SlingRepository slingRepository;

	    @Activate
	    public void activate(ComponentContext componentContext){
	        LOG.info("\n ==============INSIDE ACTIVATE================");
LOG.info("\n {} = {} ",componentContext.getBundleContext().getBundle().getBundleId(),componentContext.getBundleContext().getBundle().getSymbolicName());
	    }

	    @Deactivate
	    public void deactivate(ComponentContext componentContext){
	        LOG.info("\n ==============INSIDE DEACTIVATE================");
	    }

	    @Modified
	    public void modified(ComponentContext componentContext){
	        LOG.info("\n ==============INSIDE MODIFIED================");
	    }
        //ResolverUtil purpose is to give permissions to the fuction which are stored  in the resourceResolver object based on these object we can adapt the page
	    //resourceresolver have the permissions what we have to do
	    //pagemanager have both permissions and pagemanager properties
	    //page have permissions,pagemanagerproperties among those we have take getpage among those 
	    //Iterator<Page> it is the data type for page
	    //return is for returning
	    @Override
	    public Iterator<Page>  getPages(){
	        try {
	            ResourceResolver resourceResolver= ResolverUtil.newResolver(resourceResolverFactory);
	            PageManager pageManager=resourceResolver.adaptTo(PageManager.class);
	            Page page=pageManager.getPage("/content/we-retail/language-masters");
	            Iterator<Page> pages=page.listChildren();
	            return pages;
	        } catch (LoginException e) {
	            LOG.info("\n Login Exception {} ",e.getMessage());
	        }
	        return null;
	    }

	


}

