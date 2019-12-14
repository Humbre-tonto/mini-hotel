package com.informatique.gov.helpdesk.exception;


import lombok.Getter;

public enum ShowDogExceptionEnum {

 
  INTERNAL_EXCEPTION("INTERNAL_EXCEPTION", "", ""),
  UNSUPPORTED_OPERATION_EXCEPTION("UNSUPPORTED_OPERATION_EXCEPTION", "Trying to perform unsupported opperation : %s", "double check data provided"),
  FORBIDDEN_OPERATION_EXCEPTION	("FORBIDDEN_OPERATION_EXCEPTION", "Trying to perform an forbidden opperation : %s", "double check data provided"),
  MAL_FORMED_HTTP_REQUEST_EXCEPTION("MAL_FORMED_HTTP_REQUEST_EXCEPTION", "Request headers or body has a malformed values or content details: %s", "double check data provided"),
  RESOURCE_NOT_MODIFIED_EXCEPTION("RESOURCE_NOT_MODIFIED_EXCEPTION", "", ""),
  RESOURCE_MODIFIED_EXCEPTION("RESOURCE_MODIFIED_EXCEPTION", "The resource you are trying to update is already updated in another context", "refetch the data"),
  SINGLE_RESOURCE_MODIFIED_EXCEPTION("SINGLE_RESOURCE_MODIFIED_EXCEPTION", "The resource you are trying to update: %s with id : %s is already updated in another context real version is %s but expected is %s", "refetch the data"),
  RESOURCE_NOT_FOUND_EXCEPTION("RESOURCE_NOT_FOUND_EXCEPTION", "The resource or sub-resource you are trying to acess is not found, type: %s, id/serial/code : %s", "double check data provided"),
  RESOURCE_INEGRITY_EXCEPTION("RESOURCE_INEGRITY_EXCEPTION","The Resource you're trying to delete has dependant objects","Can't delete this resource"),
  ENTITY_NOT_FOUND_EXCEPTION("ENTITY_NOT_FOUND_EXCEPTION", "The entity you are trying to fetch/update is not found, type: %s, id/serial/code : %s", "double check data provided"),
  SINGLE_RESOURCE_NOT_FOUND_EXCEPTION("SINGLE_RESOURCE_NOT_FOUND_EXCEPTION", "The resource you are trying to update :%s with id %s is not found", "double check data provided"),
  PRE_CONDITION_REQUIRED("PRE_CONDITION_REQUIRED", "The etag header must have a the value of version of the targeted resource", "double check data provided"),
  SINGLE_RESOURCE_VERSION_NOT_PROVIDED_EXCEPTION("SINGLE_RESOURCE_VERSION_NOT_PROVIDED_EXCEPTION", "The version of %s with id %s must be provided", "double check data provided"),
  
  // Validation for custom Validation and validation annotation
  // TODO edit in exception description
  EXCEPTION_IN_VALIDATION("EXCEPTION_IN_VALIDATION", "Internal exception occured while validating", "double check data provided"),
  BLANK_VALUE("BLANK_VALUE", "NotBlank", "Target value is Blank", "double check data provided"),

  
  
  
  
  //============user errors
  	USER_NULL ("USER_NULL", "Target value is null", "Double check data"),
  	USER_EMAIL_ADDRESS_ALEARDY_EXISTS ("USER_EMAIL_ADDRESS_ALEARDY_EXISTS", "Target value is aleardy exists", "Double check data"),
    USER_CIVIL_ID_EXIST(" USER_CIVIL_ID_EXIST", "Target value is aleardy exists", "Double check data"),
  	USER_ORGANIZATION_UNIT_ID_NULL("USER_ORGANIZATION_UNIT_ID_NULL", "Target value is null", "Double check data"),
  	USER_ROLE_ID_NULL("USER_ROLE_ID_NULL", "Target value is null", "Double check data"),
    USER_LOGIN_NAME_EXISTS("USER_LOGIN_NAME_EXISTS", "Target value is aleardy exists", "Double check data"),
    USER_LOGIN_NAME_NOT_FOUND_LDAP("USER_LOGIN_NAME_NOT_FOUND_LDAP", "Target value is not exists ldap", "Double check data"),
	MOBILE_NUMBER1_EXIST("MOBILE_NUMBER1_EXIST", "Target value is aleardy exists", "Double check data");
	//==========end of user errors

    @Getter
    private String code;
    @Getter
    private String description;
    @Getter
    private String fixSuggestion;
    @Getter
    private String constraintCode;

    private ShowDogExceptionEnum(String code, String description, String fixSuggestion){
        this.code = code;
        this.description = description;
        this.fixSuggestion = fixSuggestion;
    }
    
    private ShowDogExceptionEnum(String code, String constraintCode, String description, String fixSuggestion){
        this.code = code;
        this.description = description;
        this.fixSuggestion = fixSuggestion;
        this.constraintCode = constraintCode;
    }

    public static ShowDogExceptionEnum getByCode(String code) {
		for (ShowDogExceptionEnum value : ShowDogExceptionEnum.values()) {
			if (value.getCode().equals(code)) {
				return value;
			}
		}
		throw new IllegalArgumentException("Unknown errorCode : " + code);
	}
    
    public static ShowDogExceptionEnum getByConstraintCode(String constraintCode) {
		for (ShowDogExceptionEnum value : ShowDogExceptionEnum.values()) {
			if (value.getConstraintCode() != null && value.getConstraintCode().equals(constraintCode)) {
				return value;
			}
		}
		throw new IllegalArgumentException("Unknown constraintCode : " + constraintCode);
	}

    
}
