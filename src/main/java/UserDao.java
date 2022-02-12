import org.hibernate.Session;

import javax.transaction.SystemException;
import javax.transaction.Transaction;
import java.util.List;

public class UserDao {

    public void saveUser(User user) throws SystemException {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = (Transaction) session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateUser(User user) throws SystemException {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = (Transaction) session.beginTransaction();
            // save the student object
            session.update(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) throws SystemException {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = (Transaction) session.beginTransaction();

            // Delete a user object
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
                System.out.println("user is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public User getUser(int id) throws SystemException {

        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = (Transaction) session.beginTransaction();
            // get an user object
            user = session.get(User.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

    @SuppressWarnings("unchecked")
    public List< User > getAllUser() throws SystemException {

        Transaction transaction = null;
        List < User > listOfUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = (Transaction) session.beginTransaction();
            // get an user object

            listOfUser = session.createQuery("from User").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfUser;
    }
}
