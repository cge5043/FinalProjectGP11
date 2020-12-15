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
@Table(name = "GROUPS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g")
    , @NamedQuery(name = "Groups.findByGroupid", query = "SELECT g FROM Groups g WHERE g.groupid = :groupid")
    , @NamedQuery(name = "Groups.findByGroupname", query = "SELECT g FROM Groups g WHERE g.groupname = :groupname")
    , @NamedQuery(name = "Groups.findByCourseattribute", query = "SELECT g FROM Groups g WHERE g.courseattribute = :courseattribute")
    , @NamedQuery(name = "Groups.findByMember1", query = "SELECT g FROM Groups g WHERE g.member1 = :member1")
    , @NamedQuery(name = "Groups.findByMember2", query = "SELECT g FROM Groups g WHERE g.member2 = :member2")
    , @NamedQuery(name = "Groups.findByMember3", query = "SELECT g FROM Groups g WHERE g.member3 = :member3")
    , @NamedQuery(name = "Groups.findByMember4", query = "SELECT g FROM Groups g WHERE g.member4 = :member4")
    , @NamedQuery(name = "Groups.findByMember5", query = "SELECT g FROM Groups g WHERE g.member5 = :member5")
    , @NamedQuery(name = "Groups.findByMember6", query = "SELECT g FROM Groups g WHERE g.member6 = :member6")
    , @NamedQuery(name = "Groups.findByMember7", query = "SELECT g FROM Groups g WHERE g.member7 = :member7")
    , @NamedQuery(name = "Groups.findByMember8", query = "SELECT g FROM Groups g WHERE g.member8 = :member8")
    , @NamedQuery(name = "Groups.findByMember9", query = "SELECT g FROM Groups g WHERE g.member9 = :member9")
    , @NamedQuery(name = "Groups.findByMember10", query = "SELECT g FROM Groups g WHERE g.member10 = :member10")})
public class Groups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "GROUPID")
    private Integer groupid;
    @Column(name = "GROUPNAME")
    private String groupname;
    @Column(name = "COURSEATTRIBUTE")
    private String courseattribute;
    @Column(name = "MEMBER1")
    private String member1;
    @Column(name = "MEMBER2")
    private String member2;
    @Column(name = "MEMBER3")
    private String member3;
    @Column(name = "MEMBER4")
    private String member4;
    @Column(name = "MEMBER5")
    private String member5;
    @Column(name = "MEMBER6")
    private String member6;
    @Column(name = "MEMBER7")
    private String member7;
    @Column(name = "MEMBER8")
    private String member8;
    @Column(name = "MEMBER9")
    private String member9;
    @Column(name = "MEMBER10")
    private String member10;

    public Groups() {
    }

    public Groups(Integer groupid) {
        this.groupid = groupid;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getCourseattribute() {
        return courseattribute;
    }

    public void setCourseattribute(String courseattribute) {
        this.courseattribute = courseattribute;
    }

    public String getMember1() {
        return member1;
    }

    public void setMember1(String member1) {
        this.member1 = member1;
    }

    public String getMember2() {
        return member2;
    }

    public void setMember2(String member2) {
        this.member2 = member2;
    }

    public String getMember3() {
        return member3;
    }

    public void setMember3(String member3) {
        this.member3 = member3;
    }

    public String getMember4() {
        return member4;
    }

    public void setMember4(String member4) {
        this.member4 = member4;
    }

    public String getMember5() {
        return member5;
    }

    public void setMember5(String member5) {
        this.member5 = member5;
    }

    public String getMember6() {
        return member6;
    }

    public void setMember6(String member6) {
        this.member6 = member6;
    }

    public String getMember7() {
        return member7;
    }

    public void setMember7(String member7) {
        this.member7 = member7;
    }

    public String getMember8() {
        return member8;
    }

    public void setMember8(String member8) {
        this.member8 = member8;
    }

    public String getMember9() {
        return member9;
    }

    public void setMember9(String member9) {
        this.member9 = member9;
    }

    public String getMember10() {
        return member10;
    }

    public void setMember10(String member10) {
        this.member10 = member10;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupid != null ? groupid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groups)) {
            return false;
        }
        Groups other = (Groups) object;
        if ((this.groupid == null && other.groupid != null) || (this.groupid != null && !this.groupid.equals(other.groupid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Groups[ groupid=" + groupid + " ]";
    }
    
}
