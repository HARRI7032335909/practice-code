package com.practice.core.models.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.day.cq.search.QueryBuilder;
// import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.practice.core.models.Author;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
// import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class, adapters = Author.class, resourceType = "/apps/practice-code/components/author", defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = "json") // Used to export the content as Json
@JsonRootName("Practice-details") // used to define the entire json data in root element
public class AuthorImpl implements Author {

    @ValueMapValue
    private String fname;
    @ValueMapValue
    private String lname;
    @OSGiService
    QueryBuilder queryBuilder;// default Osgi service
    @Inject
    @Named("jcr:lastModifiedBy")
    @Via("resource")
    private String modifiedBy;// throught the model we can call the that node property with user defined name

    @Override
    public String getFname() {
        // TODO Auto-generated method stub
        return fname;
    }

    @JsonProperty(value = "Non-getter") // to export non-getter methods as json format
    // @JsonIgnore // to ignore the value to export as json data
    public String getValue() {
        return "Hello This is non getter method";
    }

    @Override
    public String getLname() {
        // TODO Auto-generated method stub
        return lname;
    }

    @Override
    public String getLastModifiedBy() {
        // TODO Auto-generated method stub
        return modifiedBy;
    }

}