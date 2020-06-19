/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "Account", catalog = "DreamTraveling", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
    , @NamedQuery(name = "Account.findByUserId", query = "SELECT a FROM Account a WHERE a.userId = :userId")
    , @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password")
    , @NamedQuery(name = "Account.findByRoleName", query = "SELECT a FROM Account a WHERE a.roleName = :roleName")
    , @NamedQuery(name = "Account.findByFullName", query = "SELECT a FROM Account a WHERE a.fullName = :fullName")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "userId", nullable = false, length = 50)
    private String userId;
    @Column(name = "password", length = 50)
    private String password;
    @Column(name = "roleName", length = 50)
    private String roleName;
    @Column(name = "fullName", length = 50)
    private String fullName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private Collection<DiscountInformation> discountInformationCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<TourOrder> tourOrderCollection;

    public Account() {
    }

    public Account(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @XmlTransient
    public Collection<DiscountInformation> getDiscountInformationCollection() {
        return discountInformationCollection;
    }

    public void setDiscountInformationCollection(Collection<DiscountInformation> discountInformationCollection) {
        this.discountInformationCollection = discountInformationCollection;
    }

    @XmlTransient
    public Collection<TourOrder> getTourOrderCollection() {
        return tourOrderCollection;
    }

    public void setTourOrderCollection(Collection<TourOrder> tourOrderCollection) {
        this.tourOrderCollection = tourOrderCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entity.Account[ userId=" + userId + " ]";
    }
    
}
