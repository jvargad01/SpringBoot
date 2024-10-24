package com.jv.api.restapiqrbr.service.imp;

import java.awt.image.BufferedImage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.jv.api.restapiqrbr.model.RequestCode;
import com.jv.api.restapiqrbr.service.ServiceGenerator;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ServiceGeneratorImp implements ServiceGenerator {
  
	@Override
	public BufferedImage generateQRCode(RequestCode req)  {
		BitMatrix bitMatrix = null;
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		log.info(req);
		try {
			bitMatrix = qrCodeWriter.encode(req.getText(), BarcodeFormat.QR_CODE, req.getWidth(), req.getHeight());
		} catch (WriterException ex) {
			// TODO Auto-generated catch block 
			log.error("ERROR AL GENERAR QRCODE: " + ex.getMessage());
		}
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}

	@Override
	public BufferedImage generateBRCode(RequestCode req) {
		BitMatrix bitMatrix = null;
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		try {
			bitMatrix = qrCodeWriter.encode(req.getText(), BarcodeFormat.CODABAR, req.getWidth(), req.getHeight());
		} catch (WriterException ex) {
			// TODO Auto-generated catch block 
			log.error("ERROR AL GENERAR CODEBR: " + ex.getMessage());
		}
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}

	@Override
	public BufferedImage generateUPCACode(RequestCode req) {
		BitMatrix bitMatrix = null;
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		try {
			bitMatrix = qrCodeWriter.encode(req.getText(), BarcodeFormat.UPC_A, req.getWidth(), req.getHeight());
		} catch (WriterException ex) {
			// TODO Auto-generated catch block
			log.error("ERROR AL GENERAR QRCODE: " + ex.getMessage());
		}
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}

	@Override
	public BufferedImage generateEAN13Code(RequestCode req) {
		BitMatrix bitMatrix = null;
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		try {
			bitMatrix = qrCodeWriter.encode(req.getText(), BarcodeFormat.EAN_13, req.getWidth(), req.getHeight());
		} catch (WriterException ex) {
			// TODO Auto-generated catch block
			log.error("ERROR AL GENERAR QRCODE: " + ex.getMessage());
		}
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}

	@Override
	public BufferedImage generateCode39Code(RequestCode req) {
		BitMatrix bitMatrix = null;
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		try {
			bitMatrix = qrCodeWriter.encode(req.getText(), BarcodeFormat.CODE_39, req.getWidth(), req.getHeight());
		} catch (WriterException ex) {
			// TODO Auto-generated catch block
			log.error("ERROR AL GENERAR QRCODE: " + ex.getMessage());
		}
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}

	@Override
	public BufferedImage generateDataMatrixCode(RequestCode req) {
		BitMatrix bitMatrix = null;
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		try {
			bitMatrix = qrCodeWriter.encode(req.getText(), BarcodeFormat.DATA_MATRIX, req.getWidth(), req.getHeight());
		} catch (WriterException ex) {
			// TODO Auto-generated catch block
			log.error("ERROR AL GENERAR QRCODE: " + ex.getMessage());
		}
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}

	@Override
	public BufferedImage generatePdf417Code(RequestCode req) {
		BitMatrix bitMatrix = null;
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		try {
			bitMatrix = qrCodeWriter.encode(req.getText(), BarcodeFormat.PDF_417, req.getWidth(), req.getHeight());
		} catch (WriterException ex) {
			// TODO Auto-generated catch block
			log.error("ERROR AL GENERAR QRCODE: " + ex.getMessage());
		}
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}

	 

}
