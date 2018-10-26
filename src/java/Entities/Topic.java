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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Ali Mohamed
 */
@Entity
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "text" )
    private String Text = "";
   
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "TopicID", nullable = true)
    Set<Descussion> descussions = new HashSet<>();

    public Topic() {
    }

 

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Topic)) {
            return false;
        }
        Topic other = (Topic) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Topic[ id=" + id + " ]";
    }

    public Set<Descussion> getDescussions() {
        return descussions;
    }

    public void setDescussions(Set<Descussion> descussions) {
        this.descussions = descussions;
    }

}
