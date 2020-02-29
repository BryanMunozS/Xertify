package com.api.test.utils;
/**
 * 
 * @author Bryan Muñoz
 *
 */
public class ConstantsApi {

	public static final String URL_GET_MAP="/map_google";
	public static final String CONSTANTS_RETURN_MAP_HTML="map";
	public static final String HEADER_CONTENT_TYPE = "Content-Type";
	public static final String HEADER_APP_JSON = "application/json; charset=utf-8";
	public static final String HEADER_ACCEPT = "Accept";
	public static final String KEY_API_GOOGLE="";
	public static final int RESPONSE_CODE_BAD_REQUEST=400;
	public static final int RESPONSE_CODE_OK=200;
	public static final String URL_POST_CREATE_RECORD="/create_record";
	public static final String SERVICE_GET_ALL="/recordController/getAllRecords";
	public static final String MODEL_ATRIBUTE_LOCATION="locations";
	public static final String SERVICE_POST_CREATE_RECORD="/recordController/createRecord";
	public static final String SERVER="https://34.201.19.114:40003";
	
	//Messages
	public static final String MESSAGE_SUCCESSFUL= "Record created successfully";
	public static final String MESSAGE_FAIL= "Does not meet the necessary fields";
}
