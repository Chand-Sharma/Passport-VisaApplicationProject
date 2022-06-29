package com.techwave.pvms.utility;

import java.io.Serializable;
import java.util.Map;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;






public class UserKeyGenerator implements IdentifierGenerator{

	private Integer i=7000;
	private String prefix="VISA";
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String s = prefix + Integer.toString(i);
		
		return s;
	}

	

	
}
