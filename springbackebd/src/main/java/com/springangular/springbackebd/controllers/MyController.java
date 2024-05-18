package com.springangular.springbackebd.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springangular.springbackebd.models.MyModel;
import com.springangular.springbackebd.services.MyService;

/**
 * MyController is a Spring REST controller that handles HTTP requests related  to MyModel entities.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MyController {

	@Autowired
	MyService myService;

	/**
	 * Retrieves a list of names from the 'test' table.
	 * 
	 * @return ResponseEntity<?>: A response containing the list of names or a  no-content status.
	 */
	@GetMapping(value = "/list-names")
	public ResponseEntity<?> listOfNames() {
		//return myService.listOfNames();
		Map<String, List<String>> response = new HashMap<>();
	    response.put("response", myService.listOfNames());
	    return ResponseEntity.ok(response);
	}

	/**
	 * Saves or updates a record in the 'test' table.
	 * 
	 * @param myModel (MyModel): The model containing the name and ID to be saved or  updated.
	 * @return ResponseEntity<?>: A response containing a success message or a  no-content status.
	 */
	@PostMapping(value = "/new-names")
	public ResponseEntity<?> saveOrUpdate(@RequestBody JsonNode jsonModel) {
		//JsonNode myModelDataNode = jsonModel.get("formData");

		MyModel myModel = new ObjectMapper().convertValue(jsonModel, MyModel.class);
		
		Map<String, String> response = new HashMap<>();
	    response.put("message", myService.saveOrUpdate(myModel));
	    return ResponseEntity.ok(response);
	}

	/**
	 * Deletes records from the 'test' table based on the provided name.
	 * 
	 * @param name (String): The name used as a condition for deletion.
	 * @return ResponseEntity<?>: A response containing a success message or a  no-content status.
	 */
	@PostMapping(value = "/delete-names/{name}")
	public ResponseEntity<?> delete(@PathVariable String name) {
		Map<String, String> response = new HashMap<>();
	    response.put("message",myService.delete(name));
	    return ResponseEntity.ok(response);
	}

}
