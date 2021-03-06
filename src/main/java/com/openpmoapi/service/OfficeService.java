
package com.openpmoapi.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openpmoapi.model.Office;
import com.openpmoapi.repository.OfficeRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class OfficeService {

	
	@Autowired
	private OfficeRepository envRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	 * @return
	 * 		savedEnv
	
	 */
	@Transactional(readOnly = false)
	public Office update(Long id, Office env) {
		Office savedEnv = findEnvById(id);
		BeanUtils.copyProperties(env, savedEnv, "id", "env");
		return envRepository.save(savedEnv);
	}
	
	
	
	
	/**
	 * this method find by id a data type Environment, if not exist it treats the exception 
	 * @return
	 * 		savedEnv
	 */
	@Transactional(readOnly = true)
	public Office findEnvById(Long id) {
		Optional<Office> savedEnv = envRepository.findById(id);
		if (!savedEnv.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedEnv.get();
	}
	
	/**
	 * This method returns a collection of Offices
	 * 
	 * @return
	 * 		Collection of Offices
	 */
	
	@Transactional(readOnly = true)
    public Collection<Office> find() {
      Collection<Office> result = envRepository.find();
      return result;
    }
	
	/**
	 * This method return a tree based on the id of the office provide by parameter
	 * 
	 * @param id
	 * 			This is the id of the Office that will be find, by the tree
	 * @return
	 * 			Collection of Offices
	 */

	@Transactional(readOnly = true)
    public Collection<Office> findWpByIdTree(Long id) {
      Collection<Office> office = envRepository.findWpByIdTree(id);
      return office;
    }
	
	
	/**
	 * This method return a template tree based on the id of the office provide by parameter
	 * @param id
	 * 			This is the id of the Template tree that will be find
	 * @return
	 * 		Collection of Offices
	 */
	@Transactional(readOnly = true)
    public Collection<Office> findWpByIdTemplateTree(Long id) {
      Collection<Office> office = envRepository.findWpByIdTemplateTree(id);
      return office;
    }
	
	
	
	
	
	
	
}
