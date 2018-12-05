/**
 * 
 */
package com.openpmoapi.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.openpmoapi.model.Movie;

/**
* Type here a brief description of the class.
*
* @author lucas.regio Lucas Regio 
* @since 2018-11-30
*/
public interface MovieRepository  extends Neo4jRepository<Movie, Long>{

}