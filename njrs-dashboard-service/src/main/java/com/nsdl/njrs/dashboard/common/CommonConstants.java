package com.nsdl.njrs.dashboard.common;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public enum CommonConstants {

	INSTANCE;

	public final String BLANK_STRING = "";
	public final String SPACE_STRING = " ";
	public final String DOT_STRING = ".";
	public final String COMMA_STRING = ",";
	public final String DASH_STRING = "-";
	public final String HASH_STRING = "#";
	public final String COLON_STRING = ":";
	public final String UNDERSCORE_STRING = "_";
	public final String FORWARD_SLASH_STRING = "/";
	public final String BACKWARD_SLASH_STRING = "\\";
	public final String SINGLE_QOUTE_STRING = "'";
	public final String DOUBLE_QOUTE_STRING = "\"";
	public final String PIPE_STRING = "|";
	public final String NEWLINE_STRING = "\n";
	public final String TAB_STRING = "\t";
	public final String QUESTION_MARK_STRING = "?";
	public final String AMPERSAND_STRING = "&";
	public final String EQUALS_STRING = "=";
	public final String SYSTEM_STRING = "SYSTEM";
	public final String NSDL_STRING = "NSDL";
	public final String GSTN_STRING = "GSTN";
	public final String NIC_STRING = "NIC";
	public final String EWB_STRING = "EWB";
	public final String DEFAULT_STRING = "DEFAULT";
	public final String DEFAULT_ERROR_MESSAGE = "{\"error\":\"%s\"}";
	public final String DEFAULT_SUCCESS_MESSAGE = "{\"success\":\"%s\"}";
	public final String ERROR = "error";
	public final String SUCCESS = "success";
	public final String SYNCHRONOUS_STRING = "synchronous";

	public final DateTimeFormatter DTF_MM_yy = DateTimeFormatter.ofPattern("MM-yy");
	public final DateTimeFormatter DTF_MM_yyyy = DateTimeFormatter.ofPattern("MM-yyyy");
	public final DateTimeFormatter DTF_dd_MM_yy = DateTimeFormatter.ofPattern("dd-MM-yy");
	public final DateTimeFormatter DTF_dd_MM_yyyy = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	public final DateTimeFormatter DTF_dd_SLASH_MM_SLASH_yy = DateTimeFormatter.ofPattern("dd/MM/yy");
	public final DateTimeFormatter DTF_dd_SLASH_MM_SLASH_yyyy = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	public final DateTimeFormatter DTF_dd_MMM_yy = DateTimeFormatter.ofPattern("dd-MMM-yy");
	public final DateTimeFormatter DTF_dd_MMM_yyyy = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	public final DateTimeFormatter DTF_MM_dd_yy = DateTimeFormatter.ofPattern("MM-dd-yy");
	public final DateTimeFormatter DTF_MM_dd_yyyy = DateTimeFormatter.ofPattern("MM-dd-yyyy");
	public final DateTimeFormatter DTF_M_SLASH_d_SLASH_yy = DateTimeFormatter.ofPattern("M/d/yy");
	public final DateTimeFormatter DTF_MM_SLASH_dd_SLASH_yy = DateTimeFormatter.ofPattern("MM/dd/yy");
	public final DateTimeFormatter DTF_MM_SLASH_dd_SLASH_yyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	public final DateTimeFormatter DTF_yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd");
	public final DateTimeFormatter DTF_yyyMMddHHmmssSSS = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
	public final DateTimeFormatter DTF_ddMMyyyyHHmmssSSSSSS = DateTimeFormatter.ofPattern("ddMMyyyyHHmmssSSSSSS");

	public final DateFormat DF_MM_yyyy = new SimpleDateFormat("MM-yyyy");
	public final DateFormat DF_dd_MM_yyyy = new SimpleDateFormat("dd-MM-yyyy");
	public final DateFormat DF_dd_SLASH_MM_SLASH_yyyy = new SimpleDateFormat("dd/MM/yyyy");
	public final DateFormat DF_dd_MMM_yyyy = new SimpleDateFormat("dd-MMM-yyyy");
	public final DateFormat DF_dd_MMM_yy = new SimpleDateFormat("dd-MMM-yy");
	public final DateFormat DF_MM_SLASH_dd_SLASH_yyyy = new SimpleDateFormat("MM/dd/yyyy");
	public final DateFormat DF_yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
	public final DateFormat DF_yyyMMddHHmmssSSS = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	public final DateFormat DF_ddMMyyyyHHmmssSSSSSS = new SimpleDateFormat("ddMMyyyyHHmmssSSSSSS");
	public final DateFormat DF_ddMMyyyyHHmmssAMPM = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
	public final DateFormat DF_yyyy_MM_dd_HHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public final String REGEX_dd_DASH_MM_DASH_yyyy = "^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-([1-9][0-9]{3})$";
	public final String REGEX_dd_SLASH_MM_SLASH_yyyy = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/([1-9][0-9]{3})$";
	public final String REGEX_MM_SLASH_dd_SLASH_yyyy = "^(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/([1-9][0-9]{3})$";
	public final String REGEX_dd_DASH_MMM_DASH_yy = "^(0?[1-9]|[12][0-9]|3[01])-(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|June?|July?|Aug(ust)?|Sep(t(ember)?)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)-([0-9]{2})$";
	public final String REGEX_dd_DASH_MMM_DASH_yyyy = "^(0?[1-9]|[12][0-9]|3[01])-(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|June?|July?|Aug(ust)?|Sep(t(ember)?)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)-([1-9][0-9]{3})$";

	public final String DOCUMENT_FILE_CSV_TYPE = ".csv";
	public final String DOCUMENT_FILE_XLSX_TYPE = ".xlsx";
	public final String DOCUMENT_FILE_ZIP_TYPE = ".zip";
	public final String DOCUMENT_FILE_PDF_TYPE = ".pdf";

	public final String AES_ALGORITHM = "AES";
	public final String AES_ENCRYPTION_ALGORITHM = "AES/ECB/PKCS5Padding";

	public final String SUCCESS_STRING = "SUCCESS";
	public final String FAILED_STRING = "FAILED";
	public final String GSTN_ERROR_STRING = "GSTN_ERROR";

	public final String RSA_STRING = "RSA";
	public final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";
	public final String RSA_NONE_ALGORITH = "RSA/None/PKCS1Padding";
	public final String X509_STRING = "X.509";

	public final String PKCS12_STRING = "pkcs12";
	public final String JKS_STRING = "jks";
	public final String BC_STRING = "BC";
	public final String SHA256WITHRSA_STRING = "SHA256withRSA";

	public final String NULL = "null";
	public final String ALL = "ALL";

	public final String XLSX_ENTENSION_STRING = ".xlsx";

	public final String GSTIN_FORMAT_REGEX = "[0-9]{2}[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}[1-9A-Za-z]{1}[Z]{1}[0-9a-zA-Z]{1}";
	public final String SINGLE_TAXPAYER_SEARCH = "SINGLE_TAXPAYER_SEARCH";
	public final String BULK_TAXPAYER_SEARCH = "BULK_TAXPAYER_SEARCH";
	public final String SINGLE_FRTS_SEARCH = "SINGLE_FRTS_SEARCH";
	public final String BULK_FRTS_SEARCH = "BULK_FRTS_SEARCH";

	public final String TYPE = "type";
	public final String INVOICE_TYPE = "invoice_type";
	public final String INVOICE_NOTE_NUMBER = "invoice_note_number";
	public final BigDecimal OTHER_THAN_REVERSE_CHARGE = new BigDecimal("30002");
	public final BigDecimal REVERSE_CHARGE = new BigDecimal("30003");

	public final String CREDIT_NOTE_TYPE_STRING = "C";
	public final String DEBIT_NOTE_TYPE_STRING = "D";
	public final String REGULAR_INVOICE_TYPE_STRING = "R";
	public final String SEWP_INVOICE_TYPE_STRING = "SEWP";
	public final String SEWOP_INVOICE_TYPE_STRING = "SEWOP";
	public final String CBW_INVOICE_TYPE_STRING = "CBW";
	public final String DE_INVOICE_TYPE_STRING = "DE";

	public final String PURCHASE_RCM = "PY";
	public final String YES = "Y";

	public final String DOCUMENT_NUMBER = "document_number";
	public final String DOCUMENT_TYPE = "document_type";
	public final String ERROR_TYPE = "type";

	public final String GVS_EWB_SINGLE_SEARCH = "GVS_EWB_SINGLE_SEARCH";
	public final String GVS_EWB_BULK_SEARCH = "GVS_EWB_BULK_SEARCH";

	/** ERROR CONSTANTS **/
	public final String INVALID_INPUT = "Invalid / missing Request Payload";
	public final String EMPTY_SERVICE_INSTANCE = "Empty Service Instance";

}
