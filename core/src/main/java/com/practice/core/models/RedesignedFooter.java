package com.practice.core.models;

import java.util.List;
import java.util.Map;

public interface RedesignedFooter {
	public String getSearchPlaceholder();

	public String getSearchIcon();

	public String getLinkText();

	public String getLinkUrl();

	public String getLinkIcon();

	public List<Map<String, String>> getAboutLinks();

	public List<Map<String, String>> getPhoneLinks();

	public List<Map<String, String>> getProductLinks();

	public List<Map<String, String>> getContactLinks();
}
