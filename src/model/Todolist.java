/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a9512
 */
@Entity
@Table(name = "TODOLIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Todolist.findAll", query = "SELECT t FROM Todolist t")
    , @NamedQuery(name = "Todolist.findByCourseid", query = "SELECT t FROM Todolist t WHERE t.courseid = :courseid")
    , @NamedQuery(name = "Todolist.findByDuedate", query = "SELECT t FROM Todolist t WHERE t.duedate = :duedate")
    , @NamedQuery(name = "Todolist.findByAssignments", query = "SELECT t FROM Todolist t WHERE t.assignments = :assignments")})
public class Todolist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COURSEID")
    private String courseid;
    @Column(name = "DUEDATE")
    @Temporal(TemporalType.DATE)
    private Date duedate;
    @Basic(optional = false)
    @Column(name = "ASSIGNMENTS")
    private String assignments;

    public Todolist() {
    }

    public Todolist(String courseid) {
        this.courseid = courseid;
    }

    public Todolist(String courseid, String assignments) {
        this.courseid = courseid;
        this.assignments = assignments;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public String getAssignments() {
        return assignments;
    }

    public void setAssignments(String assignments) {
        this.assignments = assignments;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseid != null ? courseid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Todolist)) {
            return false;
        }
        Todolist other = (Todolist) object;
        if ((this.courseid == null && other.courseid != null) || (this.courseid != null && !this.courseid.equals(other.courseid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Todolist[ courseid=" + courseid + " ]";
    }
    
}
