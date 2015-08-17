package com.kashu.repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class GenericDaoImpl<T> implements GenericDao<T> {
//	/http://www.codeproject.com/Articles/251166/The-Generic-DAO-pattern-in-Java-with-Spring-3-and

    @PersistenceContext
    protected EntityManager manager;

    private Class<T> type;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
        	System.out.println("//------debug----for----entityManager-------//");
        	System.out.println(EntityManager.class.getProtectionDomain().getCodeSource().getLocation());
    }

    @Override
    public long countAll(final Map<String, Object> params) {

        final StringBuffer queryString = new StringBuffer(
                "SELECT count(o) from ");

        queryString.append(type.getSimpleName()).append(" o ");
        queryString.append(this.getQueryClauses(params, null));

        final Query query = this.manager.createQuery(queryString.toString());

        return (Long) query.getSingleResult();

    }
    
    private String getQueryClauses(final Map<String, Object> params, final Map<String, Object> orderParams) {
        final StringBuffer queryString = new StringBuffer();
        if ((params != null) && !params.isEmpty()) {
                queryString.append(" where ");
                for (final Iterator<Map.Entry<String, Object>> it = params.entrySet().iterator(); it.hasNext();) {
                        final Map.Entry<String, Object> entry = it.next();
                        if (entry.getValue() instanceof Boolean) {
                                queryString.append(entry.getKey()).append(" is ").append(entry.getValue()).append(" ");
                        } else {
                                if (entry.getValue() instanceof Number) {
                                        queryString.append(entry.getKey()).append(" = ").append(entry.getValue());
                                } else {
                                        // string equality
                                        queryString.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
                                }
                        }
                        if (it.hasNext()) {
                                queryString.append(" and ");
                        }
                }
        }
        if ((orderParams != null) && !orderParams.isEmpty()) {
                queryString.append(" order by ");
                for (final Iterator<Map.Entry<String, Object>> it = orderParams.entrySet().iterator(); it.hasNext();) {
                        final Map.Entry<String, Object> entry = it.next();
                        queryString.append(entry.getKey()).append(" ");
                        if (entry.getValue() != null) {
                                queryString.append(entry.getValue());
                        }
                        if (it.hasNext()) {
                                queryString.append(", ");
                        }
                }
        }
        return queryString.toString();
}

    @Override
    public T create(final T t) {
        this.manager.persist(t);
        return t;
    }

    @Override
    public void delete(final Object id) {
        this.manager.remove(this.manager.getReference(type, id));
    }

    @Override
    public T find(final Object id) {
        return (T) this.manager.find(type, id);
    }

    @Override
    public T update(final T t) {
    	/*
    	  if(manager.contains(t)){
    		  			System.out.println("Object" + t.getClass().getSimpleName() + "is in current persistence context.");
    	  }else{
	  			    System.out.println("Object" + t.getClass().getSimpleName() + "is NOT in current persistence context.");
    	        }
    	        */
    	manager.clear();
        return this.manager.merge(t);
    }
    
    @Override
    public T refresh(final T t){
    		this.manager.refresh(t);
    return t;
    }
    
    @Override
	   public List<T> findByParams(Map<String, Object> params,Map<String, Object> orderParams){
    	   return null;
    }
    
    @Override
    public List<T> listAll(){
      	//String queryStr = "SELECT COUNT(o) FROM " + type.getSimpleName() + " o";
    	  String queryStr = "SELECT o FROM " + type.getSimpleName() + " o";
    	  List<T> result = manager.createQuery(queryStr,type).getResultList();
    	return result;
    }
}