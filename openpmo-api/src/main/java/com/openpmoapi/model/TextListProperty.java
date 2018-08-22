/**
 * 
 */
package com.openpmoapi.model;

import java.util.ArrayList;
import java.util.List;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-21
*/
public class TextListProperty {

	

	private String name;
	
	private final String typeName = "Textlist";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeName() {
		return typeName;
	}


	private int max;
	
	private int min;
	
	private List<String>  value = new ArrayList<>();
	
	
	public List<String> getValue() {
		return value;
	}

	public void setValue(List<String> value) {
		this.value = value;
	}

	public int getMax() {
		return max;
	}


	public void setMax(int max) {
		this.max = max;
	}


	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}





	
	
	
}
