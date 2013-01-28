package s8115.student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UczelniaOperacje {

	public void saveUczelnia(Uczelnia uczelnia) {
		// otwiera sesje hibernate
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		// otwiera transakcje bazy danych
		session.beginTransaction();
		// zapisuje uczelnie
		session.persist(uczelnia);
		// commituje transakcje, zatwierdza
		session.getTransaction().commit();
		// zamkniecie sesji
		session.close();
	}
	
	public Uczelnia findUczelniaById(Long id) {
		// otwiera sesje hibernate
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		// wybranie encji po id (select * from uczelnia where id = ?)
		Uczelnia uczelnia = (Uczelnia) session.get(Uczelnia.class, id);

		// zamkniecie sesji
		session.close();

		return uczelnia;
	}
	
	public List<Uczelnia> findAllUczelnia() {
		// otwiera sesje hibernate
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		// tworzenie zapytania
		List<Uczelnia> listaUczelnia = session.createQuery(
				"select s from Uczelnia s").list();

		// zamkniecie sesji
		session.close();
		// zwroc liste
		return listaUczelnia;
	}
	
	public void updateUczelnia(Uczelnia uczelnia) {
		// otwiera sesje hibernate
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		// otwiera transakcje
		session.beginTransaction();
		// update obiektu - inacze update
		session.update(uczelnia);
		// commituje transakcje, zatwierdza
		session.getTransaction().commit();
		// zamkniecie sesji
		session.close();
	}
	
	public List<Uczelnia> findUczelniaByFilter(String nazwaUczelni) {
		// otwiera sesje hibernate
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		// tworzenie zapytania
		List<Uczelnia> listaUczelnia = session
				.createQuery(
						"select s from Uczelnia s WHERE s.nazwaUczelni = :nazwaUczelniParam")
				.setParameter("nazwaUczelniParam", nazwaUczelni).list();

		// zamkniecie sesji
		session.close();
		// zwroc liste
		return listaUczelnia;
	}
}
