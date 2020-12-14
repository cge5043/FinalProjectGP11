/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a9512
 */
@Entity
@Table(name = "PROFESSOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p")
    , @NamedQuery(name = "Professor.findByProfessorid", query = "SELECT p FROM Professor p WHERE p.professorid = :professorid")
    , @NamedQuery(name = "Professor.findByProfessorfirstname", query = "SELECT p FROM Professor p WHERE p.professorfirstname = :professorfirstname")
    , @NamedQuery(name = "Professor.findByProfessorlastname", query = "SELECT p FROM Professor p WHERE p.professorlastname = :professorlastname")
    , @NamedQuery(name = "Professor.findByDepartment", query = "SELECT p FROM Professor p WHERE p.department = :department")
    , @NamedQuery(name = "Professor.findByCourse1", query = "SELECT p FROM Professor p WHERE p.course1 = :course1")
    , @NamedQuery(name = "Professor.findByCourse2", query = "SELECT p FROM Professor p WHERE p.course2 = :course2")
    , @NamedQuery(name = "Professor.findByCourse3", query = "SELECT p FROM Professor p WHERE p.course3 = :course3")
    , @NamedQuery(name = "Professor.findByCourse4", query = "SELECT p FROM Professor p WHERE p.course4 = :course4")
    , @NamedQuery(name = "Professor.findByCourse5", query = "SELECT p FROM Professor p WHERE p.course5 = :course5")})
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PROFESSORID")
    private Integer professorid;
    @Basic(optional = false)
    @Column(name = "PROFESSORFIRSTNAME")
    private String professorfirstname;
    @Basic(optional = false)
    @Column(name = "PROFESSORLASTNAME")
    private String professorlastname;
    @Column(name = "DEPARTMENT")
    private String department;
    @Column(name = "COURSE1")
    private String course1;
    @Column(name = "COURSE2")
    private String course2;
    @Column(name = "COURSE3")
    private String course3;
    @Column(name = "COURSE4")
    private String course4;
    @Column(name = "COURSE5")
    private String course5;

    public Professor() {
    }

    public Professor(Integer professorid) {
        this.professorid = professorid;
    }

    public Professor(Integer professorid, String professorfirstname, String professorlastname) {
        this.professorid = professorid;
        this.professorfirstname = professorfirstname;
        this.professorlastname = professorlastname;
    }

    public Integer getProfessorid() {
        return professorid;
    }

    public void setProfessorid(Integer professorid) {
        this.professorid = professorid;
    }

    public String getProfessorfirstname() {
        return professorfirstname;
    }

    public void setProfessorfirstname(String professorfirstname) {
        this.professorfirstname = professorfirstname;
    }

    public String getProfessorlastname() {
        return professorlastname;
    }

    public void setProfessorlastname(String professorlastname) {
        this.professorlastname = professorlastname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourse1() {
        return course1;
    }

    public void setCourse1(String course1) {
        this.course1 = course1;
    }

    public String getCourse2() {
        return course2;
    }

    public void setCourse2(String course2) {
        this.course2 = course2;
    }

    public String getCourse3() {
        return course3;
    }

    public void setCourse3(String course3) {
        this.course3 = course3;
    }

    public String getCourse4() {
        return course4;
    }

    public void setCourse4(String course4) {
        this.course4 = course4;
    }

    public String getCourse5() {
        return course5;
    }

    public void setCourse5(String course5) {
        this.course5 = course5;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (professorid != null ? professorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.professorid == null && other.professorid != null) || (this.professorid != null && !this.professorid.equals(other.professorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Professor[ professorid=" + professorid + " ]";
    }
    
}
