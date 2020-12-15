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
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByStudentid", query = "SELECT s FROM Student s WHERE s.studentid = :studentid")
    , @NamedQuery(name = "Student.findByStudentfirstname", query = "SELECT s FROM Student s WHERE s.studentfirstname = :studentfirstname")
    , @NamedQuery(name = "Student.findByStudentlastname", query = "SELECT s FROM Student s WHERE s.studentlastname = :studentlastname")
    , @NamedQuery(name = "Student.findByStudentmajor", query = "SELECT s FROM Student s WHERE s.studentmajor = :studentmajor")
    , @NamedQuery(name = "Student.findByStudentcourse1", query = "SELECT s FROM Student s WHERE s.studentcourse1 = :studentcourse1")
    , @NamedQuery(name = "Student.findByStudentcourse2", query = "SELECT s FROM Student s WHERE s.studentcourse2 = :studentcourse2")
    , @NamedQuery(name = "Student.findByStudentcourse3", query = "SELECT s FROM Student s WHERE s.studentcourse3 = :studentcourse3")
    , @NamedQuery(name = "Student.findByStudentcourse4", query = "SELECT s FROM Student s WHERE s.studentcourse4 = :studentcourse4")
    , @NamedQuery(name = "Student.findByStudentcourse5", query = "SELECT s FROM Student s WHERE s.studentcourse5 = :studentcourse5")
    , @NamedQuery(name = "Student.findByStudentcourse6", query = "SELECT s FROM Student s WHERE s.studentcourse6 = :studentcourse6")
    , @NamedQuery(name = "Student.findByStudentcourse7", query = "SELECT s FROM Student s WHERE s.studentcourse7 = :studentcourse7")
    , @NamedQuery(name = "Student.findByStudentcourse8", query = "SELECT s FROM Student s WHERE s.studentcourse8 = :studentcourse8")
    , @NamedQuery(name = "Student.findByStudentcourse9", query = "SELECT s FROM Student s WHERE s.studentcourse9 = :studentcourse9")
    , @NamedQuery(name = "Student.findByStudentcourse10", query = "SELECT s FROM Student s WHERE s.studentcourse10 = :studentcourse10")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "STUDENTID")
    private Integer studentid;
    @Basic(optional = false)
    @Column(name = "STUDENTFIRSTNAME")
    private String studentfirstname;
    @Basic(optional = false)
    @Column(name = "STUDENTLASTNAME")
    private String studentlastname;
    @Basic(optional = false)
    @Column(name = "STUDENTMAJOR")
    private String studentmajor;
    @Column(name = "STUDENTCOURSE1")
    private String studentcourse1;
    @Column(name = "STUDENTCOURSE2")
    private String studentcourse2;
    @Column(name = "STUDENTCOURSE3")
    private String studentcourse3;
    @Column(name = "STUDENTCOURSE4")
    private String studentcourse4;
    @Column(name = "STUDENTCOURSE5")
    private String studentcourse5;
    @Column(name = "STUDENTCOURSE6")
    private String studentcourse6;
    @Column(name = "STUDENTCOURSE7")
    private String studentcourse7;
    @Column(name = "STUDENTCOURSE8")
    private String studentcourse8;
    @Column(name = "STUDENTCOURSE9")
    private String studentcourse9;
    @Column(name = "STUDENTCOURSE10")
    private String studentcourse10;

    public Student() {
    }

    public Student(Integer studentid) {
        this.studentid = studentid;
    }

    public Student(Integer studentid, String studentfirstname, String studentlastname, String studentmajor) {
        this.studentid = studentid;
        this.studentfirstname = studentfirstname;
        this.studentlastname = studentlastname;
        this.studentmajor = studentmajor;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getStudentfirstname() {
        return studentfirstname;
    }

    public void setStudentfirstname(String studentfirstname) {
        this.studentfirstname = studentfirstname;
    }

    public String getStudentlastname() {
        return studentlastname;
    }

    public void setStudentlastname(String studentlastname) {
        this.studentlastname = studentlastname;
    }

    public String getStudentmajor() {
        return studentmajor;
    }

    public void setStudentmajor(String studentmajor) {
        this.studentmajor = studentmajor;
    }

    public String getStudentcourse1() {
        return studentcourse1;
    }

    public void setStudentcourse1(String studentcourse1) {
        this.studentcourse1 = studentcourse1;
    }

    public String getStudentcourse2() {
        return studentcourse2;
    }

    public void setStudentcourse2(String studentcourse2) {
        this.studentcourse2 = studentcourse2;
    }

    public String getStudentcourse3() {
        return studentcourse3;
    }

    public void setStudentcourse3(String studentcourse3) {
        this.studentcourse3 = studentcourse3;
    }

    public String getStudentcourse4() {
        return studentcourse4;
    }

    public void setStudentcourse4(String studentcourse4) {
        this.studentcourse4 = studentcourse4;
    }

    public String getStudentcourse5() {
        return studentcourse5;
    }

    public void setStudentcourse5(String studentcourse5) {
        this.studentcourse5 = studentcourse5;
    }

    public String getStudentcourse6() {
        return studentcourse6;
    }

    public void setStudentcourse6(String studentcourse6) {
        this.studentcourse6 = studentcourse6;
    }

    public String getStudentcourse7() {
        return studentcourse7;
    }

    public void setStudentcourse7(String studentcourse7) {
        this.studentcourse7 = studentcourse7;
    }

    public String getStudentcourse8() {
        return studentcourse8;
    }

    public void setStudentcourse8(String studentcourse8) {
        this.studentcourse8 = studentcourse8;
    }

    public String getStudentcourse9() {
        return studentcourse9;
    }

    public void setStudentcourse9(String studentcourse9) {
        this.studentcourse9 = studentcourse9;
    }

    public String getStudentcourse10() {
        return studentcourse10;
    }

    public void setStudentcourse10(String studentcourse10) {
        this.studentcourse10 = studentcourse10;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentid != null ? studentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentid == null && other.studentid != null) || (this.studentid != null && !this.studentid.equals(other.studentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Student[ studentid=" + studentid + " ]";
    }
    
}
