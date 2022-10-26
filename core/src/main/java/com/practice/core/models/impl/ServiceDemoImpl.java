//package com.practice.core.models.impl;
//
//// import java.util.Iterator;
//
//import javax.annotation.PostConstruct;
//// import javax.inject.Inject;
//
//// import com.day.cq.wcm.api.Page;
//// import com.adobe.cq.wcm.core.components.models.Page;
//import com.practice.core.models.DemoService;
//// import com.practice.core.models.DemoServiceB;
//import com.practice.core.models.ServiceDemo;
//
//import org.apache.sling.api.SlingHttpServletRequest;
//import org.apache.sling.models.annotations.DefaultInjectionStrategy;
//import org.apache.sling.models.annotations.Model;
//import org.apache.sling.models.annotations.injectorspecific.OSGiService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//@Model(adaptables = SlingHttpServletRequest.class, adapters = ServiceDemo.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
//public class ServiceDemoImpl implements ServiceDemo {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceDemoImpl.class);
//
//    @OSGiService
//    DemoService demoService;
//
//    @PostConstruct
//    protected void init() {
//
//    }
//
//    @Override
//    public String getStringFromService() {

   