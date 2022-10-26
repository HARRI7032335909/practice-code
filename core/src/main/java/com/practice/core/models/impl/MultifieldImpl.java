package com.practice.core.models.impl;

import com.practice.core.models.Multifield;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.*;

@Model(adaptables = SlingHttpServletRequest.class, adapters = Multifield.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultifieldImpl implements Multifield {
	private static final Logger LOG = LoggerFactory.getLogger(MultifieldImpl.class);

	@Inject
	Resource componentResource;
//gfgf
	// kjgjhjhhjb
	// jhgfhghj

	@ValueMapValue
	@Default(values = "AEM")
	private String authorname;
	@ValueMapValue
	private List<String> javatrainer;

	// dtytdyfkugjh
	@Override
	public String getHrName() {
		// TODO Auto-generated method stub
		return authorname;
	}

	@Override
	public List<String> getJavatrainerfun() {
		// TODO Auto-generated method stub
		return javatrainer;

	}

}
