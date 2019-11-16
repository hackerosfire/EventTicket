package com.EventTicket.EventTicket;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestMain {

private static	EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("EventTicket");
	public static void main(String[] args) {
		//addAdmin(1,"test","test");
		//addAdmin(33,"admin2","admin2");
		ENTITY_MANAGER_FACTORY.close();
		frame1 mainframe = new frame1();
		mainframe.main(args);

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
	public static Admin getAdmin(int id)
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT admin FROM Admin admin WHERE admin.id = :idAdmin";
		TypedQuery<Admin> tq = em.createQuery(query, Admin.class);
		tq.setParameter("idADmin", id);
		Admin adm = null;
		try {
		adm = tq.getSingleResult();
		System.out.println(adm.getUsername());
		}
		catch(NoResultException ex) {
			ex.printStackTrace();
		}
		finally {
			em.close();
		}
		return adm;
	}
	public static void getAdmins()
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		String stringQuery = "SELECT admin FROM Admin admin WHERE idAdmin IS NOT NULL";
		TypedQuery<Admin> tq = em.createQuery(stringQuery, Admin.class);
		List<Admin> admins;
		try {
			admins = tq.getResultList();
			admins.forEach(adm->System.out.println(adm.getUsername()+ " " + adm.getPassword()));
		}
		catch(NoResultException ex) {
			ex.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	public static void getAdminsByName()
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		String stringQuery = "SELECT admin FROM Admin admin WHERE idAdmin IS NOT NULL";
		TypedQuery<Admin> tq = em.createQuery(stringQuery, Admin.class);
		List<Admin> admins;
		try {
			admins = tq.getResultList();
			admins.forEach(adm->System.out.println(adm.getUsername()+ " " + adm.getPassword()));
		}
		catch(NoResultException ex) {
			ex.printStackTrace();
		}
		finally {
			em.close();
		}
	}
}
