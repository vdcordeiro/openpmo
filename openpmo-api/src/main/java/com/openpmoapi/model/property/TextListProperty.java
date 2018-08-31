/**
 * 
 */
package com.openpmoapi.model.property;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-21
*/
public class TextListProperty extends Property{

	
	

	@Id @GeneratedValue   
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

	public TextListProperty() {
		
		this.setTypeName("TextList");
		
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
