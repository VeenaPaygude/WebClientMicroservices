package com.nsdl.njrs.dashboard.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.Produces;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsdl.njrs.dashboard.common.CommonConstants;
import com.nsdl.njrs.dashboard.exception.NJRSException;
import com.nsdl.njrs.dashboard.service.IDashBoardService;

import reactor.core.publisher.Mono;

/**
 * @author Neosoft_VeenaP
 *
 */
@RestController
public class DashboardController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DashboardController.class);
	private static final String FAILURE_MESSAGE = "failed when fetching details :: ";
	private static final String SUCCESS_MESSAGE = "Success when fetching details :: ";

	@Autowired
	private IDashBoardService IDashBoardService;

	/**
	 * @param request
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 * @throws NJRSException
	 * @throws JSONException
	 */
	@RequestMapping(value = "/getAllDocumentsRest", method = RequestMethod.POST)
	public ResponseEntity<?> getAllDocuments(@RequestParam String request)
			throws RestClientException, IOException, NJRSException, JSONException {

		LOGGER.info("Starting getAllDocuments() from DashboardController with arguments :: " + " request payload : "
				+ request);
		ResponseEntity<String> responseEntity = null;

		try {
			if (request != null && !request.trim().equalsIgnoreCase(CommonConstants.INSTANCE.BLANK_STRING)) {
				/** redirecting to search API **/

				responseEntity = IDashBoardService.getAllDocuments(request);

				LOGGER.info(SUCCESS_MESSAGE + "getAllDocuments ");
			} else {
				LOGGER.info(FAILURE_MESSAGE + "getAllDocuments ");
				throw new NJRSException(CommonConstants.INSTANCE.INVALID_INPUT);
			}
		} catch (NJRSException e) {
			LOGGER.error(FAILURE_MESSAGE + "getAllDocuments ");
			e.printStackTrace();
			throw new NJRSException(e.getMessage());
		}
		LOGGER.info("Exiting getAllDocuments() from DashboardController with  return type :: ResponseEntity");
		return responseEntity;
	}

	/**
	 * @param request
	 * @return
	 * @throws RestClientException
	 * @throws IOException
	 * @throws NJRSException
	 * @throws JSONException
	 */
	@RequestMapping(value = "/getAllDocuments", method = RequestMethod.POST)
	public ResponseEntity<?> getAllDocumentsWebClient(@RequestParam String request)
			throws RestClientException, IOException, NJRSException, JSONException {
		LOGGER.info("Starting getAllDocumentsWebClient() from DashboardController with arguments :: "
				+ " request payload : " + request);
		ResponseEntity<?> responseEntity = null;
		try {
			if (request != null && !request.trim().equalsIgnoreCase(CommonConstants.INSTANCE.BLANK_STRING)) {
				/** redirecting to search API **/

				responseEntity = IDashBoardService.getAllDocumentsWebClient(request);
				LOGGER.info(SUCCESS_MESSAGE + "getAllDocuments ");
			} else {
				LOGGER.info(FAILURE_MESSAGE + "getAllDocuments ");
				throw new NJRSException(CommonConstants.INSTANCE.INVALID_INPUT);
			}
		} catch (NJRSException e) {
			LOGGER.error(FAILURE_MESSAGE + "getAllDocuments ");
			e.printStackTrace();
			throw new NJRSException(e.getMessage());
		}
		LOGGER.info("Exiting getAllDocuments() from DashboardController with  return type :: ResponseEntity");
		return responseEntity;
	}

}
