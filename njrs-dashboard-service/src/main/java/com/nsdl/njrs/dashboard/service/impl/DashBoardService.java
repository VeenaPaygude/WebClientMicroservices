package com.nsdl.njrs.dashboard.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import com.nsdl.njrs.dashboard.common.CommonConstants;
import com.nsdl.njrs.dashboard.exception.NJRSException;
import com.nsdl.njrs.dashboard.service.IDashBoardService;

/**
 * @author Neosoft_VeenaP
 *
 */
@Service
public class DashBoardService implements IDashBoardService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DashBoardService.class);
	private static final String FAILURE_MESSAGE = "failed when fetching details : %s.";
	private static final String SUCCESS_MESSAGE = "success when fetching details : %s.";

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@Value("${search.service.name}")
	private String searchServiceName;

	@Value("${API.MIME}")
	private String header;

	/**
	 * REST TEMPLATE
	 * 
	 * @return ResponseEntity<String>
	 * @throws NJRSException
	 */
	@Override
	public ResponseEntity<String> getAllDocuments(String request) throws NJRSException {
		LOGGER.info("Starting getAllDocuments from DashBoardService with arguments :: requestData : " + request);
		String errorMessage = null;
		ResponseEntity<String> response = null;

		if (this.searchServiceName != null
				&& !this.searchServiceName.trim().equalsIgnoreCase(CommonConstants.INSTANCE.BLANK_STRING)
				&& request != null && !request.trim().equalsIgnoreCase(CommonConstants.INSTANCE.BLANK_STRING)) {
			ServiceInstance serviceInstance = loadBalancerClient.choose(this.searchServiceName);
			LOGGER.info("Fetched Service Instance URI :- " + serviceInstance.getUri());

			if (serviceInstance != null && serviceInstance.getUri() != null) {

				String baseUrl = serviceInstance.getUri().toString()
						.concat(CommonConstants.INSTANCE.FORWARD_SLASH_STRING).concat("getAllDocuments");
				LOGGER.info("BaseURL :- " + baseUrl);

				RestTemplate restTemplate = new RestTemplate();
				try {

					/** set headers **/
					HttpHeaders headers = new HttpHeaders();
					headers.set("Accept", "*/*");
					headers.setContentType(MediaType.APPLICATION_JSON);

					/** set body **/
					MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
					body.add("request", request);

					/** add body & headers to HTTPEntity **/
					HttpEntity<MultiValueMap<String, String>> requestbody = new HttpEntity<MultiValueMap<String, String>>(
							body, headers);

					response = restTemplate.postForEntity(baseUrl, requestbody, String.class);

				} catch (Exception ex) {
					ex.printStackTrace();
					LOGGER.error(FAILURE_MESSAGE);
				}
			} else {
				LOGGER.error(FAILURE_MESSAGE);
				throw new NJRSException(CommonConstants.INSTANCE.EMPTY_SERVICE_INSTANCE);
			}
			/** Check for success **/
			if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
				LOGGER.info("Getting the result successfully : " + response);
			} else {
				errorMessage = "httpResponse it may be bad request or internal server error";
			}
			if (errorMessage != null) {
				LOGGER.error(FAILURE_MESSAGE);
				throw new NJRSException(errorMessage);
			} else {
				LOGGER.info(SUCCESS_MESSAGE + " :: " + response.getBody());
			}
		} else {
			LOGGER.error(FAILURE_MESSAGE);
			throw new NJRSException(CommonConstants.INSTANCE.INVALID_INPUT);
		}
		LOGGER.info("Exiting from getAllDocuments from DashBoardService with return :: responseBody");
		return response;
	}

	/**
	 * WEB CLIENT
	 * 
	 * @return ResponseEntity<?>
	 * @throws NJRSException
	 */
	@Override
	public ResponseEntity<?> getAllDocumentsWebClient(String request) throws NJRSException {
		LOGGER.info("Starting getAllDocuments from DashBoardService with arguments :: requestData : " + request);
		String errorMessage = null;
		ResponseEntity<String> response = null;

		if (this.searchServiceName != null
				&& !this.searchServiceName.trim().equalsIgnoreCase(CommonConstants.INSTANCE.BLANK_STRING)
				&& request != null && !request.trim().equalsIgnoreCase(CommonConstants.INSTANCE.BLANK_STRING)) {
			ServiceInstance serviceInstance = loadBalancerClient.choose(this.searchServiceName);
			LOGGER.info("Fetched Service Instance URI :- " + serviceInstance.getUri());

			if (serviceInstance != null && serviceInstance.getUri() != null) {

				ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
						.codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(-1)).build();
				WebClient webClient = WebClient.builder().exchangeStrategies(exchangeStrategies)
						.baseUrl(serviceInstance.getUri().toString())
						.defaultHeader(HttpHeaders.CONTENT_TYPE, this.header).build();
				try {
					String result = webClient.post().uri("/getAllDocuments2").bodyValue(request).retrieve()
							.bodyToMono(String.class).block();
					if (result != null) {
						response = new ResponseEntity<String>(result, null, HttpStatus.OK);
					} else {
						response = new ResponseEntity<String>(null, null, HttpStatus.NO_CONTENT);
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					LOGGER.error(FAILURE_MESSAGE);
				}
			} else {
				LOGGER.error(FAILURE_MESSAGE);
				throw new NJRSException(CommonConstants.INSTANCE.EMPTY_SERVICE_INSTANCE);
			}

			if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
				LOGGER.info("Getting the result successfully : " + response);
			} else {
				errorMessage = "httpResponse it may be bad request or internal server error";
			}
			if (errorMessage != null) {
				LOGGER.error(FAILURE_MESSAGE);
				throw new NJRSException(errorMessage);
			} else {
				LOGGER.info(SUCCESS_MESSAGE + " :: " + response.getBody());
			}
		} else {
			LOGGER.error(FAILURE_MESSAGE);
			throw new NJRSException(CommonConstants.INSTANCE.INVALID_INPUT);
		}
		LOGGER.info("Exiting from getAllDocuments from DashBoardService with return :: responseBody");
		return response;
	}

}