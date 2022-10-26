package com.practice.core.models.impl;

import com.practice.core.models.OsgiConfig;

import org.osgi.service.component.annotations.Activate;
// import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@Component(service = OsgiConfig.class, immediate = true)
@Designate(ocd = OsgiConfigImpl.ServiceConfig.class)
public class OsgiConfigImpl implements OsgiConfig {

    @ObjectClassDefinition(name = "Practice Code-OSGI Configuration", description = "OSGI configuration")

    public @interface ServiceConfig {

        @AttributeDefinition(name = "Service Name", description = "Enter Service Name", type = AttributeType.STRING)
        public String serviceName() default "Practice code Service";

        @AttributeDefinition(name = "Service Count", description = "Add Service Count", type = AttributeType.INTEGER)
        int getServiceCount() default 5;

        @AttributeDefinition(name = "Live Data", description = "Check this to get live data", type = AttributeType.BOOLEAN)
        boolean getLiveData() default false;

        @AttributeDefinition(name = "Countries", description = "Enter country locales which you want to run this service", type = AttributeType.STRING)
        String[] getCountriesName() default { "En", "Es" };

        @AttributeDefinition(name = "Run Modes", description = "Select Run Mode", type = AttributeType.STRING, options = {
                @Option(label = "Author", value = "author"),
                @Option(label = "Publish", value = "publish"),
                @Option(label = "Both", value = "both")
        })
        String getRunModes() default "both";

    }

    private String serviceName;
    private int serviceCount;
    private boolean liveData;
    private String[] countries;
    private String runModes;

    @Activate
    protected void activate(ServiceConfig serviceConfig) {

        serviceName = serviceConfig.serviceName();
        serviceCount = serviceConfig.getServiceCount();
        liveData = serviceConfig.getLiveData();
        countries = serviceConfig.getCountriesName();
        runModes = serviceConfig.getRunModes();
    }

    @Override
    public String getServiceName() {

        return serviceName;
    }

    @Override
    public int getServiceCount() {

        return serviceCount;
    }

    @Override
    public boolean isLiveData() {

        return liveData;
    }

    @Override
    public String[] getCountries() {

        return countries;
    }

    @Override
    public String getRunModes() {

        return runModes;
    }

}
