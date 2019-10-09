package com.ril.base.dto;

/**
 * <p>
 * WXXYYYZZZ for error codes
 * 
 * W: 1-6 Error Type e.g 1 - System, 2 - Business, 3 - Success, 4 - DAO/Database
 * (JPA/Hibernate/JDBC), 5 - Communication (Messaging, Web, Email etc.), 6 -
 * IO/File System
 * 
 * XX: 00-07 Sub System e.g 00 - Common, 01 - Framework, 02 - Core, 03 - CFS, 04
 * - EBS, 05 - SSR, 06 - MDS, 07 VAS
 *
 * YYY: 001-013 Module Information e.g 1) For Framework 001-User, 002-UserGroup,
 * 003-Organization, 004-Data Scope, 005-Roles , 006-Resources 007-Service,
 * 008-Function, 009-Configuration, 010-setting, 011-Business Units,
 * 012-Reference Data, 013-Multilingual
 * 
 * 2) For Core: 001-Reference Data, 002-Carder, 003-Carrier Visit, 004-Carrier
 * Service, 005-Vessel, 006-Vessel Visit, 007-Vessel Service, 008-Rail, 009-Rail
 * visit, 010-Rail Service, 011-Equipment, 012-SSR
 * 
 * ZZZ: Incremental sequence from 001 For Error Type 2 - Business, module
 * suffix: 800-999 - for Validation Errors For Error Type 3 - Success, module
 * suffix: 800-999 - for Warnings
 * </p>
 * 
 */
public interface ResultCode {

	/**
	 * return http status
	 * 
	 * @return int code
	 */
	public int getHttpStatus();

	/**
	 * return result code
	 * 
	 * @return int code
	 */
	public int getResultCode();

	/**
	 * return message
	 * 
	 * @return int code
	 */
	public String getMessage();

}
