/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Entities.Descussion;
import java.util.List;

/**
 *
 * @author Ali Mohamed
 */
public class DescusionJAO extends JAO<Integer, Descussion>{

    @Override
    public void Insert(Descussion T) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Descussion Read(Integer id) {
         Descussion Desc= new Descussion();
        try {

            Desc = (Descussion) session.get(Descussion.class, id);
        } catch (Exception e) {
        }
        return Desc;
    }

    @Override
    public List<Descussion> ReadAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update(Descussion t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
