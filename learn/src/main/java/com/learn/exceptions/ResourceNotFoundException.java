package com.learn.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	String resourceName;
	String resourceFeild;
	long fieldValue;
	public ResourceNotFoundException(String resourceName, String resourceFeild, long fieldValue) {
		super(
				String.format("%s not found with %s : %s",resourceName,resourceFeild,fieldValue)
				);
		this.resourceName = resourceName;
		this.resourceFeild = resourceFeild;
		this.fieldValue = fieldValue;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceFeild() {
		return resourceFeild;
	}
	public void setResourceFeild(String resourceFeild) {
		this.resourceFeild = resourceFeild;
	}
	public long getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(long fieldValue) {
		this.fieldValue = fieldValue;
	}
	
}
