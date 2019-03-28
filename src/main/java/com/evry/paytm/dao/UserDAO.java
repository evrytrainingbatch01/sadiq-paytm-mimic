package com.evry.paytm.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.evry.paytm.dto.UserDTO;

public class UserDAO {
	
	private static SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
	public boolean addUser(UserDTO dto) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(dto);
		session.getTransaction().commit();
		session.close();
		
		if(dto.equals(dto)) {
			return true;
		}
		return false;
	}
	
	public long login(UserDTO dto) {
		
		Session session = sf.openSession();
		String qry ="select count(*) from UserDTO where uUserName=:uUserName and uPassword=:uPassword";
		
		 Query query = session.createQuery(qry);
		query.setParameter("uUserName", dto.getuUserName());
		query.setParameter("uPassword", dto.getuPassword());
		
		long result = (long) query.getSingleResult();
		return result;
	}
	
	public UserDTO addMoney(int id,double bal) {
		Session session = sf.openSession();
		UserDTO dto = session.get(UserDTO.class, id);
		dto.setBalance(dto.getBalance()+bal);
		session.beginTransaction();
		session.update(dto);
		session.getTransaction().commit();
		System.out.println("Amount added.");
		session.get(UserDTO.class, id);
		
		return dto;
		
		
	}
	
	public double getBalance(UserDTO dto)
	{
		
		Session session = sf.openSession();
		UserDTO dt = session.get(UserDTO.class, dto.getUid());
		double balance = dt.getBalance();
		return balance;
	}
	
	public UserDTO transferMoney(int id1,int id2,double amt) {
		Session session=sf.openSession();
		session.beginTransaction();
		
		
		
		
		UserDTO acuid = session.get(UserDTO.class,id1);
		UserDTO beneficiary=session.get(UserDTO.class,id2);
		acuid.setBalance(acuid.getBalance()-amt);
		beneficiary.setBalance(beneficiary.getBalance()+amt);
		session.update(acuid);
		session.update(beneficiary);
		acuid=session.get(UserDTO.class,id1);
		session.getTransaction().commit();
		System.out.println("Done with trnasaction");
		
//		session.close();
		return acuid;
	}

}
