package com.springangular.springbackebd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springangular.springbackebd.dao.MyDao;
import com.springangular.springbackebd.models.MyModel;

/**  MyService is a Spring service component that acts as an intermediary between controllers and MyDao for handling business logic related to MyModel entities. */
@Service
public class MyService {

    @Autowired
    MyDao myDao;

    /**
     * Retrieves a list of All names from the 'test' table using MyDao. 
     * @return ResponseEntity<List<String>>: A response containing the list of names  or a no-content status.
     */
    public List<String> listOfNames() {
        List<String> result = myDao.listOfNames();
        return result ;
    }

    /**
     * Saves or updates a record in the 'test' table using MyDao. 
     * @param myModel (MyModel): The model containing the name and ID to be saved or  updated.
     * @return ResponseEntity<String>: A response containing a success message or a  no-content status.
     */
    public String saveOrUpdate(MyModel myModel) {
        String result = myDao.saveOrUpdateUnnamed(myModel.getName(), myModel.getId());
        return result ;
    }

    /**
     * Deletes records from the 'test' table using MyDao. 
     * @param name (String): The name used as a condition for deletion.
     * @return ResponseEntity<String>: A response containing a success message or a  no-content status.
     */
    public String delete(String name) {
        String result = myDao.delete(name);
        return result ;
    }

}
