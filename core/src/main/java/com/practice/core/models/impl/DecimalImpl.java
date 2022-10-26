package com.practice.core.models.impl;

// import javax.jcr.Node;

import com.practice.core.models.Decimal;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
// import org.osgi.resource.Resource;

@Model(adaptables = SlingHttpServletRequest.class, adapters = Decimal.class)
public class DecimalImpl implements Decimal {

    @ValueMapValue
    private double text;

    @Override
    public double getText() {
        // TODO Auto-generated method stub
        return text;
    }
}
