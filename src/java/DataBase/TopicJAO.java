package DataBase;

import Entities.Topic;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ali Mohamed
 */
public class TopicJAO extends JAO<Integer, Topic> {

    @Override
    public void Insert(Topic T) {
        try {
            session.beginTransaction();
            session.save(T);
            session.getTransaction().commit();
        } catch (Exception e) {
        }
    }

    @Override
    public Topic Read(Integer id) {
        Topic topic = new Topic();
        try {

            topic = (Topic) session.get(Topic.class, id);
        } catch (Exception e) {
        }
        return topic;
    }

    @Override
    public List<Topic> ReadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(Topic t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
