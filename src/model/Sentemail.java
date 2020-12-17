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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "SENTEMAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sentemail.findAll", query = "SELECT s FROM Sentemail s")
    , @NamedQuery(name = "Sentemail.findByEmailid", query = "SELECT s FROM Sentemail s WHERE s.emailid = :emailid")
    , @NamedQuery(name = "Sentemail.findByReciever", query = "SELECT s FROM Sentemail s WHERE s.reciever = :reciever")
    , @NamedQuery(name = "Sentemail.findByTextmessage", query = "SELECT s FROM Sentemail s WHERE s.textmessage = :textmessage")
    , @NamedQuery(name = "Sentemail.findByEmailtitle", query = "SELECT s FROM Sentemail s WHERE s.emailtitle = :emailtitle")
    , @NamedQuery(name = "Sentemail.findByEmaildate", query = "SELECT s FROM Sentemail s WHERE s.emaildate = :emaildate")
    , @NamedQuery(name = "Sentemail.findByRecieverAdvanced", query = "SELECT s FROM Sentemail s WHERE  LOWER(s.reciever) LIKE  CONCAT('%', LOWER(:reciever), '%')")})

public class Sentemail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EMAILID")
    private Integer emailid;
    @Column(name = "RECIEVER")
    private String reciever;
    @Column(name = "TEXTMESSAGE")
    private String textmessage;
    @Column(name = "EMAILTITLE")
    private String emailtitle;
    @Column(name = "EMAILDATE")
    private String emaildate;

    public Sentemail() {
    }

    public Sentemail(Integer emailid) {
        this.emailid = emailid;
    }

    public Integer getEmailid() {
        return emailid;
    }

    public void setEmailid(Integer emailid) {
        this.emailid = emailid;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getTextmessage() {
        return textmessage;
    }

    public void setTextmessage(String textmessage) {
        this.textmessage = textmessage;
    }

    public String getEmailtitle() {
        return emailtitle;
    }

    public void setEmailtitle(String emailtitle) {
        this.emailtitle = emailtitle;
    }

    public String getEmaildate() {
        return emaildate;
    }

    public void setEmaildate(String emaildate) {
        this.emaildate = emaildate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailid != null ? emailid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sentemail)) {
            return false;
        }
        Sentemail other = (Sentemail) object;
        if ((this.emailid == null && other.emailid != null) || (this.emailid != null && !this.emailid.equals(other.emailid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Sentemail[ emailid=" + emailid + " ]";
    }
    
}
