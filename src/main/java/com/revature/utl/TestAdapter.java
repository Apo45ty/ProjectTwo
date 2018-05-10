/**
 * 
 */
package com.revature.utl;

import java.io.IOException;


import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.revature.model.Test;

/**
 * @author Ed M
 * @date May 10, 2018
 * @time time 9:39:54 AM
 */
public class TestAdapter extends TypeAdapter<Test> {

	/**
	 * 
	 */

	@Override
	public void write(JsonWriter out, Test value) throws IOException {
		  if (value == null) {
			  out.nullValue();
	            return;
	        }
		  out.value(value.toString());
		
	}

	@Override
	public Test read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
