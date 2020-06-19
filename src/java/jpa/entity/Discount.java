/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "Discount", catalog = "DreamTraveling", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discount.findAll", query = "SELECT d FROM Discount d")
    , @NamedQuery(name = "Discount.findById", query = "SELECT d FROM Discount d WHERE d.id = :id")
    , @NamedQuery(name = "Discount.findByDiscountCode", query = "SELECT d FROM Discount d WHERE d.discountCode = :discountCode")
    , @NamedQuery(name = "Discount.findByDateExpired", query = "SELECT d FROM Discount d WHERE d.dateExpired = :dateExpired")
    , @NamedQuery(name = "Discount.findBySale", query = "SELECT d FROM Discount d WHERE d.sale = :sale")})
public class Discount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Column(name = "discountCode", length = 50)
    private String discountCode;
    @Column(name = "dateExpired")
    @Temporal(TemporalType.DATE)
    private Date dateExpired;
    @Column(name = "sale")
    private Integer sale;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discount")
    private Collection<DiscountInformation> discountInformationCollection;

    public Discount() {
    }

    public Discount(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public Date getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(Date dateExpired) {
        this.dateExpired = dateExpired;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    @XmlTransient
    public Collection<DiscountInformation> getDiscountInformationCollection() {
        return discountInformationCollection;
    }

    public void setDiscountInformationCollection(Collection<DiscountInformation> discountInformationCollection) {
        this.discountInformationCollection = discountInformationCollection;
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
        if (!(object instanceof Discount)) {
            return false;
        }
        Discount other = (Discount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entity.Discount[ id=" + id + " ]";
    }
    
}
