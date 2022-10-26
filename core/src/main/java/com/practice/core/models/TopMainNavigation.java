package com.practice.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TopMainNavigation {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Inject
    private String topNavHeaderText;

    @Inject
    private String topNavHeaderLinkUrl;

    @Inject
    private String topNavIconPath;

    public String getTopNavIconPath() {
        return topNavIconPath;
    }

    public void setTopNavIconPath(String topNavIconPath) {
        this.topNavIconPath = topNavIconPath;
    }

    /**
     * @return String return the topNavHeaderText
     */
    public String getTopNavHeaderText() {
        return topNavHeaderText;
    }

    /**
     * @param topNavHeaderText the topNavHeaderText to set
     */
    public void setTopNavHeaderText(String topNavHeaderText) {
        this.topNavHeaderText = topNavHeaderText;
    }

    /**
     * @return String return the topNavHeaderLinkUrl
     */
    public String getTopNavHeaderLinkUrl() {
        return topNavHeaderLinkUrl;
    }

    /**
     * @param topNavHeaderLinkUrl the topNavHeaderLinkUrl to set
     */
    public void setTopNavHeaderLinkUrl(String topNavHeaderLinkUrl) {
        this.topNavHeaderLinkUrl = topNavHeaderLinkUrl;
    }

}
