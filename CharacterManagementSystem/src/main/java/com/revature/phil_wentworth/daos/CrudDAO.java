package com.revature.phil_wentworth.daos;

import com.revature.phil_wentworth.util.MyList;

public interface CrudDAO<T> {

	// CRUD: Create, Read, Update, Delete

	// Create
	T create(T newObj);
	
	// Read
	MyList<T> findAll();
	T findById(String id);
	
	// Update
	boolean update(T updatedObj);
	
	// Delete
	boolean delete(String id);
}
