package com.EventTicket.EventTicket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestMain {

private static	EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("EventTicket");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ENTITY_MANAGER_FACTORY.close();
	}
	public static void addAdmin(int id,String username,String password)
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et=null;
		try
		{
			et=em.getTransaction();
			et.begin();
			Admin admin=new Admin();
			admin.setId(id);
			admin.setPassword(password);
			admin.setUsername(username);
			em.persist(admin);
		}
		catch(Exception e)
		{
			if(et!=null)
			{
				et.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
	}
}
