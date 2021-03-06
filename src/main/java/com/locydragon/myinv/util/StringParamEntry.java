package com.locydragon.myinv.util;

import java.util.*;

public class StringParamEntry implements Map.Entry<Float,String> {
	private Float key = (float)0;
	private String value = null;
	@Override
	public Float getKey() {
		return this.key;
	}

	@Override
	public String getValue() {
		return this.value;
	}

	@Override
	public String setValue(String value) {
		this.value = value;
		return value;
	}

	public Float setKey(Float key) {
		this.key = key;
		return key;
	}

	public static boolean startsWithIgnoreCase(String string, String prefix) {
		if (string.length() < prefix.length()) {
			return false;
		}
		return string.regionMatches(true, 0, prefix, 0, prefix.length());
	}
}
