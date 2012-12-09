// klasa ktora otwiera sesje habernate
package s8115.student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentOperacje {

	public void saveStudent(Student student) {
		// otwiera sesje hibernate
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		// otwiera transakcje bazy danych
		session.beginTransaction();
		// zapisuje studenta
		session.persist(student);
		// commituje transakcje, zatwierdza
		session.getTransaction().commit();
		// zamkniecie sesji
		session.close();
	}

	
	public Student findStudentById(Long id) {
		// otwiera sesje hibernate
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//wybranie encji po id (select * from student where id = ?)
		Student student = (Student) session.get(Student.class, id);
		
		// zamkniecie sesji
		session.close();
		
		return student;
	}
	
	public List<Student> findAllStudent() {
		// otwiera sesje hibernate
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		// tworzenie zapytania 
		List<Student> listaStudent = session.createQuery("select s from Student s").list();
		
		// zamkniecie sesji
		session.close();
		// zwroc liste
		return listaStudent;
	}

	public void updateStudent(Student student) {
		// otwiera sesje hibernate
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		// otwiera transakcje
		session.beginTransaction();
		// update obiektu - inacze update
		session.update(student);
		// commituje transakcje, zatwierdza
		session.getTransaction().commit();
		// zamkniecie sesji
		session.close();
	}	
}
