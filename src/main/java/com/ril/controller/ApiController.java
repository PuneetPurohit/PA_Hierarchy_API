package com.ril.controller;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ril.base.controller.AbstractApiController;
import com.ril.base.dto.ApiResponseDto;
import com.ril.base.dto.ResponseDetailDto;
import com.ril.base.dto.ResponseObjectDto;
import com.ril.base.result.AnalyticErrorCodes;
import com.ril.base.result.AnalyticSuccessCodes;
import com.ril.dto.ModuleMasterDto;
import com.ril.exception.exception.PartnerAnalyticException;
import com.ril.service.UserAuthorizationService;
import com.ril.util.CommonUtil;

@RestController
@RequestMapping(path = "/api", 
					consumes = MediaType.APPLICATION_JSON, 
					produces = MediaType.APPLICATION_JSON, 
					method = {RequestMethod.GET, RequestMethod.POST})
@JsonFormat(shape=JsonFormat.Shape.ARRAY)
public class ApiController extends AbstractApiController{
	private static final Logger logger = LogManager.getLogger(ApiController.class);
	
	@Autowired
	private UserAuthorizationService userAuthorizationService;
	

	public UserAuthorizationService getUserAuthorizationService() {
		return userAuthorizationService;
	}


	public void setUserAuthorizationService(
			UserAuthorizationService userAuthorizationService) {
		this.userAuthorizationService = userAuthorizationService;
	}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/all-end-points/{roleType}",method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody ApiResponseDto<List<ModuleMasterDto>> allAuthEndPointUrls(HttpServletRequest request,HttpServletResponse response,@PathVariable("roleType") String roleType) throws Exception {
		
		String headers= request.getHeader(HttpHeaders.AUTHORIZATION);
		
		
		ApiResponseDto<List<ModuleMasterDto>> apiResponseDto = new ApiResponseDto<List<ModuleMasterDto>>();
		List<ModuleMasterDto> moduleMasterDto = new ArrayList<ModuleMasterDto>();
		
		ModuleMasterDto module=null;
		if(null != roleType){
			module=new ModuleMasterDto();
			module.setPartnerRoleType(roleType);
		}
		ResponseDetailDto responseDetailDto = new ResponseDetailDto();
		try{
			if (headers != null && headers.toLowerCase().startsWith("basic")) {
			    // Authorization: Basic base64credentials
			    String base64Credentials = headers.substring("Basic".length()).trim();
			    byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
			    String credentials = new String(credDecoded, StandardCharsets.UTF_8);
			    // credentials = username:password
			    final String[] values = credentials.split(":", 2);
			    /*response.setHeader("Access-Control-Allow-Origin","*");
				response.setHeader("Access-Control-Allow-Methods","GET, POST, DELETE, PUT");
				*/response.setContentType(MediaType.APPLICATION_JSON);
			    if(values[0].equals("pratham")&&values[1].equals("patil")){
			    	System.out.println("user is authorized");
			    	moduleMasterDto=userAuthorizationService.getAllAuthEndPointUrls(module);
			    	ResponseObjectDto successDetail = new ResponseObjectDto(null,
							CommonUtil.addArgumentInMessage(
									AnalyticSuccessCodes.FIND_API_FETCH_SUCCESS.getMessage(), Arrays.asList(new String[] { "PRM ID" })),
							AnalyticSuccessCodes.FIND_API_FETCH_SUCCESS.getResultCode());
					responseDetailDto.getSuccessDetail().add(successDetail);
					setResult(moduleMasterDto, HttpStatus.OK.value(), response, apiResponseDto, responseDetailDto);
					request.getServletContext().setAttribute("moduleMasterDto", moduleMasterDto);
			    }
			    else{
			    	//user is not authorized Error detail will be display here
			    	moduleMasterDto=null;
			    	ResponseObjectDto errorDetail = new ResponseObjectDto(null,
							CommonUtil.addArgumentInMessage(
									AnalyticErrorCodes.FIND_API_FETCH_SYSTEM_ERROR.getMessage(), Arrays.asList(new String[] { "PRM ID" })),
									AnalyticErrorCodes.FIND_API_FETCH_SYSTEM_ERROR.getResultCode());
					responseDetailDto.getErrorDetail().add(errorDetail);
					setResult(moduleMasterDto, HttpStatus.UNAUTHORIZED.value(), response, apiResponseDto, responseDetailDto);
			    }
			   
			}
			 else{
			    	//user is not authorized Error detail will be display here
			    	moduleMasterDto=null;
			    	ResponseObjectDto errorDetail = new ResponseObjectDto(null,
							CommonUtil.addArgumentInMessage(
									AnalyticErrorCodes.FIND_API_FETCH_SYSTEM_ERROR.getMessage(), Arrays.asList(new String[] { "PRM ID" })),
									AnalyticErrorCodes.FIND_API_FETCH_SYSTEM_ERROR.getResultCode());
					responseDetailDto.getErrorDetail().add(errorDetail);
					setResult(moduleMasterDto, HttpStatus.FORBIDDEN.value(), response, apiResponseDto, responseDetailDto);
			    }
		
		
		}catch(PartnerAnalyticException pae){
			handleAnalyticException(response, apiResponseDto, pae, null);
		}
		
		return apiResponseDto;
	}	
	
	@Autowired
	Environment environment;

	@GetMapping("/")
	public String health() {
		return "I am Ok";
	}

	@GetMapping("/backend")
	public String backend() {
		System.out.println("Inside MyRestController::backend...");

		String serverPort = environment.getProperty("local.server.port");

		System.out.println("Port : " + serverPort);
		
		return "Hello form Backend!!! " + " Host : localhost " + " :: Port : " + serverPort;
	}
	
}
