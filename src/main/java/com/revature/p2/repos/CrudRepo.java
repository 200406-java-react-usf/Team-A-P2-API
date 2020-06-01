package com.revature.p2.repos;

import java.util.List;

public interface CrudRepo<T> {

    List<T> findAll();
    T findById (int id);
    T save(T newObj);
    boolean update(T updatedObj);
    boolean deleteById(int id);

}
