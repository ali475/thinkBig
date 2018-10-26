/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Entities.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Ali Mohamed
 */
public abstract class JAO<ID, Type> {

    static Configuration config = new Configuration();
    static SessionFactory factory = config.configure().buildSessionFactory();
    static Session session = factory.openSession();

    public JAO() {
        
       config.addAnnotatedClass(HashTag.class);
       config.addAnnotatedClass(Topic.class);
       config.addAnnotatedClass(Descussion.class);
       config.addAnnotatedClass(opinion.class);
    }
    

    public abstract void Insert(Type T);

    public abstract Type Read(ID id);

    public abstract List<Type> ReadAll();

    public abstract void Update(Type t);

}
