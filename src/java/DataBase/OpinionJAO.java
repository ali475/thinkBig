/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Entities.opinion;
import java.util.List;

/**
 *
 * @author Ali Mohamed
 */
public class OpinionJAO extends JAO<Integer, opinion> {

    @Override
    public void Insert(opinion T) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public opinion Read(Integer id) {
          opinion opin= new opinion();
        try {

            opin = (opinion) session.get(opinion.class, id);
        } catch (Exception e) {
        }
        return opin;
    }

    @Override
    public List<opinion> ReadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(opinion t) {
          try {
            session.beginTransaction();
            session.merge(t);
            session.getTransaction().commit();
        } catch (Exception e) {
        }
    }

}
