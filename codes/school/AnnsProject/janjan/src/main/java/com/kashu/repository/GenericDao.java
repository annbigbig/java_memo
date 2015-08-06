package com.kashu.repository;

import java.util.List;
import java.util.Map;

public interface GenericDao<T> {
    /**
     * Method that returns the number of entries from a table that meet some
     * criteria (where clause params)
     *
     * @param params
     *            sql parameters
     * @return the number of records meeting the criteria
     */
    long countAll(Map<String, Object> params);

    T create(T t);

    void delete(Object id);

    T find(Object id);

    T update(T t);
    
    //this is added by me
    T refresh(T t);
    
    List<T> findByParams(Map<String, Object> params,Map<String, Object> orderParams);
    
    List<T> listAll();
}