package slz.blog.login;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

// https://www.roseindia.net/spring/spring4/login-form-using-spring-mvc-and-hibernate.shtml

public class Login {
	 @Resource(name="sessionFactory")
     protected SessionFactory sessionFactory;

     public void setSessionFactory(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
     }
    
     protected Session getSession(){
            return sessionFactory.openSession();
     }

     public boolean checkLogin(String userName, String userPassword){
			Session session = sessionFactory.openSession();
			boolean userFound = false;
			String SQL_QUERY =" from Users as o where o.userName=? and o.userPassword=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,userName);
			query.setParameter(1,userPassword);
			List list = query.list();

			if ((list != null) && (list.size() > 0)) {
				userFound= true;
			}

			session.close();
			return userFound;              
     }
}
