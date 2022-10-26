package com.practice.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;


@Component(
    immediate = true,
    service = Servlet.class,
    property = {
    	"sling.servlet.extensions=txt",
        "sling.servlet.paths=/bin/osgi", 
        "sling.servlet.paths=/bin/foo",
        "sling.servlet.methods=get"
    }
)
@Designate(ocd=SimpleServlet.Configuration.class)
public class SimpleServlet extends SlingSafeMethodsServlet {

    private static final long serialVersionUID = 1L;

    
    private boolean enabled;

    @Override
    protected void doGet(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        resp.setContentType("text/plain");
        out.write("hi this is Harikrishna today date is 11/10/2022");
    }

    @Activate
    @Modified
    protected void Activate(Configuration config) {
        enabled = config.enabled();
    }

    @ObjectClassDefinition(name = "hi this is Harikrishna")
    public @interface Configuration {
        @AttributeDefinition(
            name = "Enable",
            description = "Sample boolean property"
        )
        boolean enabled() default false;
    }
}
