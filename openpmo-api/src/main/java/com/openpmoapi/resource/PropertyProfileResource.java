/**
 * 
 */
package com.openpmoapi.resource;



<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openpmoapi.model.PropertyProfile;
import com.openpmoapi.repository.PropertyProfileRepository;

import io.swagger.annotations.Api;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-29
*/
@RestController
@RequestMapping("/api/propertyprofile")
@Api(value = "/api/propertyprofile",  tags = "PropertyProfile",description=" ")
public class PropertyProfileResource {

	

	
	@Autowired
	private PropertyProfileRepository propertyRepository;
	

	
	
	
	

	
	/**
	This method find by one WorkpackTemplate
	*/
	@GetMapping("/{id}")
		public ResponseEntity<PropertyProfile> findById(@PathVariable Long id) {
		java.util.Optional<PropertyProfile> propProfile = propertyRepository.findById(id,2);
		return propProfile.isPresent() ? ResponseEntity.ok(propProfile.get()) : ResponseEntity.notFound().build();
	}
	

=======
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openpmoapi.model.PropertyProfile;
import com.openpmoapi.repository.PropertyProfileRepository;

import io.swagger.annotations.Api;

/**
* Type here a brief description of the class.
*
* @author marcos.santos  
* @since 2018-08-29
*/
@RestController
@RequestMapping("/api/property")
@Api(value = "/api/property",  tags = "Property",description=" ")
public class PropertyProfileResource {

	
//	@Autowired
//	private WorkpackTemplateRepository wptmplRepository;
	
	
	@Autowired
	private PropertyProfileRepository propertyRepository;
	
	
//	@Autowired
//	WorkpackTemplateResource wptemplate;
	
//	@Autowired
//	private WorkpackTemplateService wptmpService;
	
	
	
	

	
//	/**
//	This method find by one WorkpackTemplate
//	*/
//	@GetMapping("/{id}")
//		public ResponseEntity<PropertyProfile> findById(@PathVariable Long id) {
//		Optional<PropertyProfile> wpTmpl = propertyRepository.findById(id);
//		return wpTmpl.isPresent() ? ResponseEntity.ok(wpTmpl.get()) : ResponseEntity.notFound().build();
//	}
	
//
//	/**
//	 * This is method update WorkpackTemplate
//	 */
//	@PutMapping("/{id}")
//	public ResponseEntity<WorkpackTemplate> update(@PathVariable  Long id,@Valid  @RequestBody TextProperty text, WorkpackTemplate wpTmpl ) {
//		
//		Optional<WorkpackTemplate> wp = wptmplRepository.findById(id,2);
//		
//		wp.get().getProperties().add(text);
//		
//		WorkpackTemplate wpSalvo = wptmpService.update(id,wp);
//		
//		return ResponseEntity.ok(wpSalvo);
//	}
	
>>>>>>> branch 'master' of https://github.com/sep-es-br/openpmo.git


	
	
}
