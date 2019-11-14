package com.EventTicket.EventTicket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestMain {

private static	EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("EventTicket");
	public static void main(String[] args) {
		addAdmin(1,"test","test");
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
			et.commit();
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
	
	public static void addOrganisator(int id,String username,String password)
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et=null;
		try
		{
			et=em.getTransaction();
			et.begin();
			Organisator o=new Organisator();
			o.setOrganisatorid(id);
			o.setPassword(password);
			o.setUsername(username);
			em.persist(o);
			et.commit();
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
	
	public static void addDistributor(int id,String username,String password)
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et=null;
		try
		{
			et=em.getTransaction();
			et.begin();
			Distributor d=new Distributor();
			d.setId(id);
			d.setPassword(password);
			d.setUsername(username);
			em.persist(d);
			et.commit();
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
