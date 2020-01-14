package com.nsdl.njrs.dashboard.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nsdl.njrs.dashboard.exception.NJRSException;

/**
 * @author Neosoft_VeenaP
 *
 */
@Service
public interface IDashBoardService {

	public ResponseEntity<String> getAllDocuments(String url) throws NJRSException;

	public ResponseEntity<?> getAllDocumentsWebClient(String request) throws NJRSException;

}
