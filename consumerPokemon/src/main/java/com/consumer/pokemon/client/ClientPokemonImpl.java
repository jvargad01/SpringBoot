package com.consumer.pokemon.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumer.pokemon.config.ApiProperties;
import com.consumer.pokemon.controller.Controller;

import lombok.extern.slf4j.Slf4j; 
 
@Slf4j
@Service
public class ClientPokemonImpl implements ClientPokemon {

	@Autowired
	private ApiProperties apiProperties;
	
	@Override
	public JSONObject getDataPokemon(String data) {
		JSONObject myResponseSlot = null;
		try {
			URL url = new URL(apiProperties.getUrlName() + apiProperties.getResource());
            HttpURLConnection conn;  
              conn = (HttpURLConnection) url.openConnection();
                            conn.setRequestMethod("GET");
                            conn.setRequestProperty("Content-Type", "application/json");
                            //conn.setRequestProperty("Accept", "vdn.dac.v1");
              if (conn.getResponseCode() != 200) {
            	  log.error("Failed : HTTP error code : {}", conn.getResponseCode());
              } else {
                  
                  BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                  StringBuffer output = new StringBuffer();
                  String inputLine; 
                       
                  while ((inputLine = br.readLine()) != null) {
                	  output.append(inputLine); 
                  }
                       
                  myResponseSlot = new JSONObject(output.toString());
                      
              }  
              conn.disconnect();               
		} catch (MalformedURLException ex) {
          ex.fillInStackTrace();
        } catch (IOException e) { 
			e.printStackTrace();
		}
		
		return myResponseSlot;
	}

}
