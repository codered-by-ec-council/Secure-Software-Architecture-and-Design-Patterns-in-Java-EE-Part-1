/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.entity;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author buddhini
 */
@Entity
public class LoyaltyPoints implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar date;
    private String mobileNo;
    private int nonRedeemedPoints;

    public LoyaltyPoints() {
    }
    

    public LoyaltyPoints(Calendar date, String mobileNo, int nonRedeemedPoints) {
        this.date = date;
        this.mobileNo = mobileNo;
        this.nonRedeemedPoints = nonRedeemedPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    
    

    public int getNonRedeemedPoints() {
        return nonRedeemedPoints;
    }

    public void setNonRedeemedPoints(int nonRedeemedPoints) {
        this.nonRedeemedPoints = nonRedeemedPoints;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoyaltyPoints)) {
            return false;
        }
        LoyaltyPoints other = (LoyaltyPoints) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "supermarket.entity.LoyaltyPoints[ id=" + id + " ]";
    }

}
