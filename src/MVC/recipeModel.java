package MVC;

import JavaBeans.userBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

/**
 * Created by JordanHope on 2/20/2016.
 */
public class recipeModel {
    HibernateConfig theHibernateUtility;
    List<userBean> users;
    /*
   * show how to add records to the database
   */
    public void addUser() {
        Session session = theHibernateUtility.getCurrentSession();
        /*
         * all database interactions in Hibernate are required to be inside a transaction.
         */
        Transaction transaction = session.beginTransaction();
        /*
         * create some User instances.
         */
        userBean firstUser = new userBean("jordan", "password");
        userBean anotherUser = new userBean("bob", "pass");
        userBean finalUser = new userBean("zack", "myFav");
        /*
         * save each instance as a record in the database
         */
        session.save(firstUser);
        session.save(anotherUser);
        session.save(finalUser);
        transaction.commit();
        /*
         * prove that the User instances were added to the database and that
         * the instances were each updated with a database generated id.
         */
        System.out.println("firstUser generated ID is: " + firstUser.getId());
        System.out.println("anotherUser generated ID is: " + anotherUser.getId());
        System.out.println("finalUser generated ID is: " + finalUser.getId());
    }

    /*
     * show how to get a collection of type List containing all of the records in the user table
     */
    public void showAllUsers() {
        Session session = theHibernateUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        /*
         * execute a HQL query against the database.  HQL is NOT SQL.  It is object based.
         */
        Query allUsersQuery = session.createQuery("select u from userBean as u order by u.id");
        /*
         * get a list of User instances based on what was found in the database tables.
         */

        users = allUsersQuery.list();
        System.out.println("num users: "+users.size());
        /*
         * iterate over each User instance returned by the query and found in the list.
         */
        Iterator<userBean> iter = users.iterator();;
        while(iter.hasNext()) {
            userBean element = iter.next();
            System.out.println(element.toString());
        }
        transaction.commit();
    }

    /*
     * show how to modify a database record
     */
    public void modifyUser() {

        Session session = theHibernateUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        /*
         * get a single User instance from the database.
         */
        Query singleUserQuery = session.createQuery("select u from userBean as u where u.username='bob'");
        userBean anotherUser = (userBean)singleUserQuery.uniqueResult();
        /*
         * change the user name for the Java instance
         */
        anotherUser.setUsername("Joshua");
        /*
         * call the session merge method for the User instance in question.  This tells the database that the instance is ready to be permanently stored.
         */
        session.merge(anotherUser);

        /*
         * call the transaction commit method.  This tells the database that the changes are ready to be permanently stored.
         */
        transaction.commit();
        /*
         * permanently store the changes into the database tables.
         */
        showAllUsers();
    }

    public void deleteAddedUsers() {
        Session session = theHibernateUtility.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        int numUsers = users.size();
        System.out.println("user count: " + numUsers);
        for(int i = 0; i < numUsers; i++){
            System.out.println("deleting user "+users.get(i).getUsername());
            session.delete(users.get(i));
        }
        transaction.commit();
        /*
          * at this point the records have been removed from the database but still exist in our class list attribute.
          * Do not store lists retrieved from the database since they will be out of synch with the database table from which they come.
          * This example shows that you should not store retrieved lists.
          */
        System.out.println(users);
        users.clear();
        /*
          * now the Java instances are also gone and the database is back to its original state so the example application can be run again.
          */
        System.out.println(users);
    }

}
