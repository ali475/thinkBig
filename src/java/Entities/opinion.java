/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Ali Mohamed
 */
@Entity
public class opinion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "text" )
    private String Text = "";
    @Column(columnDefinition = "text"  )
    private String Type = "";/*we have three types text aoudio vedio*/
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "OPID")
    Set<HashTag> opinions = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DescID", nullable = false)
    Descussion descussion = new Descussion();

    public Set<HashTag> getOpinions() {
        return opinions;
    }

    public void setOpinions(Set<HashTag> opinions) {
        this.opinions = opinions;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
   

    @Override
    public String toString() {
        return "Entities.opinion[ id=" + id + " ]";
    }

}
