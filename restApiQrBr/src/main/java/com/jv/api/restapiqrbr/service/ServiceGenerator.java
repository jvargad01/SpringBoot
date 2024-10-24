package com.jv.api.restapiqrbr.service;

import java.awt.image.BufferedImage;

import com.jv.api.restapiqrbr.model.RequestCode;

public interface ServiceGenerator {

	BufferedImage generateQRCode(RequestCode request);

	BufferedImage generateBRCode(RequestCode request);
	
	BufferedImage generateUPCACode(RequestCode request);
	
	BufferedImage generateEAN13Code(RequestCode request);
	
	BufferedImage generateCode39Code(RequestCode request);

	BufferedImage generateDataMatrixCode(RequestCode request);
	
	BufferedImage generatePdf417Code(RequestCode request);
	
}
