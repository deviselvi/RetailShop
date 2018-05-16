package com.retail.ref.data;

public enum UserTypeEnum {
	
	 Employee(1L ,"Employee"),
	 Affliated(2L , "Affliated Employee"),
	 Privileged(3L , "Previleged User");

    private final Long userTypeCode;
    private final String userTypename;

    UserTypeEnum(Long userTypeCode, String userTypename) {
		this.userTypeCode=userTypeCode;
		this.userTypename =userTypename;
	}

	public Long getUserTypeode() {
		return userTypeCode;
	}

	public String getUserTypename() {
		return userTypename;
	}
	
	public UserTypeEnum fromUserTypeName(String userTypename){
		return UserTypeEnum.valueOf(userTypename);
	}
	
}
