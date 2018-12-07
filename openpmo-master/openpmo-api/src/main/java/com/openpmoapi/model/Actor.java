/**
 * 
 */
package com.openpmoapi.model;




import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.neo4j.ogm.annotation.NodeEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
* This class represents the actor model
*
* @author marcos.santos  
* @since 2018-11-29
*/
@NodeEntity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Actor {

		Long id;
		
		@NotNull
		@Size(min=3,max=20)
		private String name;
		
		private String fullName;
		
		private String phone;
		
		private String address;
		
		private ActorType actorType;
		
//		@Relationship(type="ACTS")
//	    private Collection <Role> roles;
//		
		  
	   
		public Long getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
	

		public String getFullName() {
			return fullName;
		}
		
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
	
		public String getPhone() {
			return phone;
		}
		
		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		/**
		 * @return the actorType
		 */
		public ActorType getActorType() {
			return actorType;
		}

		/**
		 * @param actorType the actorType to set
		 */
		public void setActorType(ActorType actorType) {
			this.actorType = actorType;
		}
		
	
	
}
