package com.practice.core.models.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

public class ResolverUtil {
// this is vimp practiceServiceUser this which name you are you are given in the configurations
	public static final String PRACTICE_SERVICE_USER = "practiceServiceUser";

	public static ResourceResolver newResolver(ResourceResolverFactory resolverFactory) throws LoginException {

		final Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put(ResourceResolverFactory.SUBSERVICE, PRACTICE_SERVICE_USER);

		ResourceResolver resolver = resolverFactory.getServiceResourceResolver(paramMap);
		return resolver;

	}

}
