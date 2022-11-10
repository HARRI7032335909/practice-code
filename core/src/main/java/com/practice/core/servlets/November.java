package com.practice.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

@Component(service=Servlet.class,immediate=true,
property= {
"sling.servlet.methods=" +  HttpConstants.METHOD_GET , 
"sling.servlet.resourceTypes=" + "practice-code/components/page",
"sling.servlet.selectors="+"green",

}

)
public class November  extends SlingSafeMethodsServlet {

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		ResourceResolver resourceResolver=request.getResourceResolver();
		
		response.setHeader("Content-Type", "text/html");
		response.getWriter().print("hello from resource based servlet");
		
	}

	
}
