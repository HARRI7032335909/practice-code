package com.practice.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
// import org.eclipse.jetty.security.LoggedOutAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TopHeaderNavigation {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Inject
    Resource componentResource;

    @Inject
    private List<Resource> topNavigationHeader;

    private List<TopMainNavigation> topHeaderList = new ArrayList<>();

    /**
     * @return List<TopMainNavigation> return the topHeaderList
     */
    public List<TopMainNavigation> getTopHeaderList() {
        return topHeaderList;
    }

    /**
     * @param topHeaderList the topHeaderList to set
     */
    public void setTopHeaderList(List<TopMainNavigation> topHeaderList) {
        this.topHeaderList = topHeaderList;
    }

    @PostConstruct
    protected void init() {

        if (!topNavigationHeader.isEmpty()) {
            logger.info("It went to TopHeaderNavigation");
            for (Resource resource : topNavigationHeader) {
                TopMainNavigation navHeader = resource.adaptTo(TopMainNavigation.class);
                topHeaderList.add(navHeader);
            }
        }
    }

}
