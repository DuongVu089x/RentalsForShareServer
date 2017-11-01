package com.rentalsforshare.common.util;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;


public class Constants {
	/** The Constant STR_FORMAT_DATE. */
	public static final String STR_FORMAT_DATE = "dd/MM/yyyy";

	/** The Constant STR_HEADER_AUTHORIZATION. */
	public static final String STR_HEADER_AUTHORIZATION = "authorization";

	/** The Constant STR_UNAUTHORIZED. */
	public static final String STR_UNAUTHORIZED = "You are not logged in";

	/** The Constant STR_FORBIDDEN. */
	public static final String STR_FORBIDDEN = "You don't have permission to access";

	/** The Constant STR_UPDATE_UNSUCCESS. */
	public static final String STR_UPDATE_UNSUCCESS = "Update unsucssess";

	/** The Constant STR_INSERT_SUCCESS. */
	public static final String STR_INSERT_SUCCESS = "Insert success";

	/** The Constant PAGE_SIZE. */
	public static final int PAGE_SIZE = 5;

	/** The Constant STR_PATH_NOT_FOUND. */
	public static final String STR_PATH_NOT_FOUND = "/404";

	/** The Constant STR_PATH_INTERNAL_SERVER_ERROR. */
	public static final String STR_PATH_INTERNAL_SERVER_ERROR = "/500";

	/** The Constant STR_PERCENT. */
	public static final String STR_PERCENT = "%";

	/** The Constant STR_ID. */
	public static final String STR_ID = "id";

	/** The Constant NUM_1. */
	public static final int NUM_1 = 1;

	/** The Constant STR_404_PAGE. */
	public static final String STR_404_PAGE = "404";

	/** The Constant STR_403_PAGE. */
	public static final String STR_403_PAGE = "403";
	
	
	public static final JSONObject MSG_MESSAGE= new JSONObject();
}
