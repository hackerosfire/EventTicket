package com.EventTicket.EventTicket;

import java.sql.Date;
import java.util.ArrayList;
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
		//addAdmin(5,"admin3","parola");
		//ENTITY_MANAGER_FACTORY.close();
		//addDistributor(1,"dis1","parola");
		//addOrganisator(1,"org1","parola");
		frame1 mainframe = new frame1();
		mainframe.frame();
		//System.out.println(checkAdminByName("test"));

	}
	public static void addAdmin(String username,String password)
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et=null;
		try
		{
			et=em.getTransaction();
			et.begin();
			Admin admin=new Admin();
			//admin.setId(id);
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
	
	public static void addOrganisator(String username,String password)
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et=null;
		try
		{
			et=em.getTransaction();
			et.begin();
			Organisator o=new Organisator();
			//o.setOrganisatorid(id);
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
	
	public static void addDistributor(String username,String password)
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et=null;
		try
		{
			et=em.getTransaction();
			et.begin();
			Distributor d=new Distributor();
			//d.setId(id);
			d.setPassword(password);
			d.setUsername(username);
			d.setRating(0);
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
	public static void addEvent(String name, String location, int capacity, int tpp, double price, Date string, int idOrg)
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et=null;
		EventType etype = new EventType();
		etype.setType("concert");
		try
		{
			et=em.getTransaction();
			et.begin();
			Event e=new Event();
			e.setName(name);
			e.setLocation(location);
			e.setCapacity(capacity);
			e.setPerPerson(tpp);
			e.setPrice(price);
			e.setDate(string);
			e.setOrgId(em.getReference(Organisator.class, idOrg));

			em.persist(e);
			e.setType(etype);
			et.commit();
		}
		catch(Exception ex)
		{
			if(et!=null)
			{
				et.rollback();
			}
			ex.printStackTrace();
		}
		finally
		{
			em.close();
			
		}
	}
	public static void EditEvent(int id, String name, String location, int capacity, int tpp, double price, Date string)
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et=null;
		EventType etype = new EventType();
		etype.setType("concert");
		Event e= null;
		try
		{
			et=em.getTransaction();
			et.begin();
			e = em.find(Event.class, id);
			e.setName(name);
			e.setLocation(location);
			e.setCapacity(capacity);
			e.setPerPerson(tpp);
			e.setPrice(price);
			e.setDate(string);
			em.persist(e);
			e.setType(etype);
			et.commit();
		}
		catch(Exception ex)
		{
			if(et!=null)
			{
				et.rollback();
			}
			ex.printStackTrace();
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
		tq.setParameter("idAdmin", id);
		Admin adm = null;
		try {
		adm = tq.getSingleResult();
		//System.out.println(adm.getUsername());
		}
		catch(NoResultException ex) {
			ex.printStackTrace();
		}
		finally {
			em.close();
		}//
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
	public static Admin getAdminByName(String name)
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT admin FROM Admin admin WHERE admin.username = :AdminUsername";
		TypedQuery<Admin> tq = em.createQuery(query, Admin.class);
		tq.setParameter("AdminUsername", name);
		tq.setMaxResults(1);
		Admin adm = null;
		try {
			adm = tq.getSingleResult();
			return adm;
		}

		finally {
			em.close();
		}
	}
	public static boolean  checkAdminByName(String name)
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT admin FROM Admin admin WHERE admin.username = :AdminUsername";
		TypedQuery<Admin> tq = em.createQuery(query, Admin.class);
		tq.setParameter("AdminUsername", name);
		tq.setMaxResults(1);
		List<Admin> results;
		//Admin adm = null;
		try {
			//adm = tq.getSingleResult();
			results=tq.getResultList();
			if(results.isEmpty())
			{
				return false;
			}
			else
			{
			return true;
			}
		}

		finally {
			em.close();
		}
	}
	public static Organisator getOrganisator(int id)
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT organisator FROM Organisator organisator WHERE organisator.id = :idOrgsanisator";
		TypedQuery<Organisator> tq = em.createQuery(query, Organisator.class);
		tq.setParameter("idOrganisator", id);
		Organisator org= null;
		try {
		org = tq.getSingleResult();
		//System.out.println(adm.getUsername());
		}
		catch(NoResultException ex) {
			ex.printStackTrace();
		}
		finally {
			em.close();
		}//
		return org;
	}
	public static boolean  checkOrganisatorByName(String name)
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT organisator FROM Organisator organisator WHERE organisator.username = :OrganisatorUsername";
		TypedQuery<Organisator> tq = em.createQuery(query, Organisator.class);
		tq.setParameter("OrganisatorUsername", name);
		tq.setMaxResults(1);
		List<Organisator> results;
		try {
			results=tq.getResultList();
			if(results.isEmpty())
			{
				return false;
			}
			else
			{
			return true;
			}
		}

		finally {
			em.close();
		}
	}
	public static boolean  checkDistributorByName(String name)
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT distributor FROM Distributor distributor WHERE distributor.username = :DistributorUsername";
		TypedQuery<Distributor> tq = em.createQuery(query, Distributor.class);
		tq.setParameter("DistributorUsername", name);
		tq.setMaxResults(1);
		List<Distributor> results;
		try {
			results=tq.getResultList();
			if(results.isEmpty())
			{
				return false;
			}
			else
			{
			return true;
			}
		}

		finally {
			em.close();
		}
	}
	public static Organisator getOrganisatorByName(String name)
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT organisator FROM Organisator organisator WHERE organisator.username = :OrganisatorUsername";
		TypedQuery<Organisator> tq = em.createQuery(query, Organisator.class);
		tq.setParameter("OrganisatorUsername", name);
		Organisator org= null;
		try {
			org = tq.getSingleResult();
			return org;
		}
		catch(NoResultException ex) {
			ex.printStackTrace();
			return null;
		}
		finally {
			em.close();
		}
	}
	public static Distributor getDistributor(int id)
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT distributor FROM Distributor distributor WHERE distributor.id = :idDistributor";
		TypedQuery<Distributor> tq = em.createQuery(query, Distributor.class);
		tq.setParameter("idDistributor", id);
		Distributor dis= null;
		try {
		dis = tq.getSingleResult();
		//System.out.println(adm.getUsername());
		}
		catch(NoResultException ex) {
			ex.printStackTrace();
		}
		finally {
			em.close();
		}//
		return dis;
	}
	public static Distributor getDistributorByName(String name)
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT distributor FROM Distributor distributor WHERE distributor.username = :DistributorUsername";
		TypedQuery<Distributor> tq = em.createQuery(query, Distributor.class);
		tq.setParameter("DistributorUsername", name);
		Distributor dis= null;
		try {
			dis = tq.getSingleResult();
		}
		catch(NoResultException ex) {
			ex.printStackTrace();
		}
		finally {
			em.close();
		}
		return dis;
	}
	public static List<Event> getEventsByOrganisatorId(int id)
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT event FROM Event event  WHERE event.orgId = :EventOrganisator";
		TypedQuery<Event> tq = em.createQuery(query, Event.class);
		tq.setParameter("EventOrganisator", em.getReference(Organisator.class, id));
		tq.getParameters().toString();
		List<Event> events = null;
		try {
			if(tq.getResultList().isEmpty())
			{
				System.out.println("no events found");
			}
			else
			{
				events = tq.getResultList();
			}
		}
		catch(NoResultException ex) {
			//ex.printStackTrace();
		}
		finally {
			em.close();
		}
		return events;
	}
	public static List<Distributor> getDistributors()
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT distributor FROM Distributor distributor";
		TypedQuery<Distributor> tq = em.createQuery(query, Distributor.class);
		//tq.setParameter("EventOrganisator", em.getReference(Organisator.class, id));
		tq.getParameters().toString();
		List<Distributor> d = null;
		try {
			if(tq.getResultList().isEmpty())
			{
				System.out.println("no events found");
			}
			else
			{
				d = tq.getResultList();
			}
		}
		catch(NoResultException ex) {
			//ex.printStackTrace();
		}
		finally {
			em.close();
		}
		return d;
	}
	public static void addInvitation(int idOrganisator,Distributor d,Event e)
	{
		EntityManager em=ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et=null;
		Invitation inv = new Invitation();

		try
		{
			et=em.getTransaction();
			et.begin();
			inv.setStatus(0);
			inv.setDistributorID(d);
			inv.setOrganisatorID(em.getReference(Organisator.class, idOrganisator));
			inv.setEventID(e);
			em.persist(inv);
			et.commit();
		}
		catch(Exception ex)
		{
			if(et!=null)
			{
				et.rollback();
			}
			ex.printStackTrace();
		}
		finally
		{
			em.close();
			
		}
	}
}
