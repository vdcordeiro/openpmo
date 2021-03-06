/**
 * 
 */
package com.openpmoapi.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openpmoapi.model.Role;
import com.openpmoapi.repository.RoleRepository;


/**
* this class is responsible by valid the data 
*
* @author marcos.santos  
* @since 2018-08-02
*/

@Service
public class RoleService {

	
	@Autowired
	private RoleRepository roleRepository;
	
	
	/**
	
	 * this method verify if exits the data to update 
	 * @return
	 * 		savedRole
	
	 */
	@Transactional(readOnly = false)
	public Role update(Long id, Role role) {
		Role savedRole = findRoleById(id);
		BeanUtils.copyProperties(role, savedRole, "id", "role");
		return roleRepository.save(savedRole);
	}
	
	
	
	/**
	 * this method find by id a data type Role, if not exist it treats the exception 
	 * @return
	 * 		savedRole
	 */
	@Transactional(readOnly = true)
	public Role findRoleById(Long id) {
		Optional<Role> savedRole = roleRepository.findById(id);
		if (!savedRole.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return savedRole.get();
	}
	
	/**
	 * 
	 * @param id
	 * 		This is  the Role that will be find, by the scope
	 * @return
	 * 		Collection of Role
	 */

	@Transactional(readOnly = true)
    public Collection<Role> findAllByScopeId(Long id) {
      Collection<Role> roles = roleRepository.findAllByScopeId(id);
      return roles;
    }
	

	/**
	 * 
	 * @param id
	 * 		This is the Role that will be find, by the actor id
	 * @return
	 * 		Collection of Role
	 */
	@Transactional(readOnly = true)
    public Collection<Role> findAllByActorId(Long id) {
      Collection<Role> roles = roleRepository.findAllByActorId(id);
      return roles;
    }
	
	

	
	
}
