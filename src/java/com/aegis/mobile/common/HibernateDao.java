/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aegis.mobile.common;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
public abstract class HibernateDao {
    
    public static Logger logger = Logger.getLogger(HibernateDao.class);
    @Autowired
    public SessionFactory sessionFactory;
    
        
    protected Session getSession() {
        if(sessionFactory.getCurrentSession().isOpen()){
            logger.info("Old session returned");
            return sessionFactory.getCurrentSession();
        }else{
            logger.info("New  session Opened");
            return sessionFactory.openSession();
        }
    }
 
    public void persist(Object entity) {         
        getSession().persist(entity);       
    }   
    
    public Integer save(Object entity) {
        return  (Integer) getSession().save(entity);
    } 
    
    public void delete(Object entity) {               
        getSession().delete(entity);
    }
    
    
    
}
