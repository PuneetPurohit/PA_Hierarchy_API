package com.ril.base.controller;

import java.lang.reflect.Type;

import com.google.gson.Gson;


/**
 * Base class used for some generic methods
 * 
 *
 */
public class BaseAnalyticController {
	private Gson jsonConverter = new Gson();

	protected <T> T getPojoFromJson(String jsonString, Class<T> classType) {
		return jsonConverter.fromJson(jsonString, classType);
	}

	protected <T> String getJSonFromPojo(T pojo) {
		return jsonConverter.toJson(pojo);
	}

	protected <T> T getPojoFromJson(String jsonString, Type type) {
		return jsonConverter.fromJson(jsonString, type);
	}


}
