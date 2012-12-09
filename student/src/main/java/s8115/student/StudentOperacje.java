package s8115.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentOperacje {

	public void saveStudent(Student student) {
		// otwiera sesje hibernate
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		// otwiera transakcje
		session.beginTransaction();
		// zapisuje studenta
		session.persist(student);
		// commituje transakcje, zatwierdza
		session.getTransaction().commit();
		// zamkniecie sesji
		session.close();
	}

}
