package com.oc.safetyalerts.util;

import java.io.UnsupportedEncodingException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	/**
	 * @param mvcResult
	 * @return
	 * @throws JSONException
	 * @throws UnsupportedEncodingException
	 */
	public static int asIntFieldJson(MvcResult mvcResult,String filed ) throws JSONException, UnsupportedEncodingException {
		return new JSONObject(mvcResult.getResponse().getContentAsString()).getInt(filed);
	}
	
	public static String asStringFieldJson(MvcResult mvcResult,String filed ) throws JSONException, UnsupportedEncodingException {
		return new JSONObject(mvcResult.getResponse().getContentAsString()).getString(filed);
	}

}
