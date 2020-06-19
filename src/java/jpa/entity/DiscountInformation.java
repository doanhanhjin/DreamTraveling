/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "DiscountInformation", catalog = "DreamTraveling", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiscountInformation.findAll", query = "SELECT d FROM DiscountInformation d")
    , @NamedQuery(name = "DiscountInformation.findByDiscountId", query = "SELECT d FROM DiscountInformation d WHERE d.discountInformationPK.discountId = :discountId")
    , @NamedQuery(name = "DiscountInformation.findByUserId", query = "SELECT d FROM DiscountInformation d WHERE d.discountInformationPK.userId = :userId")
    , @NamedQuery(name = "DiscountInformation.findByStatus", query = "SELECT d FROM DiscountInformation d WHERE d.status = :status")})
public class DiscountInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DiscountInformationPK discountInformationPK;
    @Column(name = "status", length = 50)
    private String status;
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Account account;
    @JoinColumn(name = "discountId", referencedColumnName = "Id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Discount discount;

    public DiscountInformation() {
    }

    public DiscountInformation(DiscountInformationPK discountInformationPK) {
        this.discountInformationPK = discountInformationPK;
    }

    public DiscountInformation(int discountId, String userId) {
        this.discountInformationPK = new DiscountInformationPK(discountId, userId);
    }

    public DiscountInformationPK getDiscountInformationPK() {
        return discountInformationPK;
    }

    public void setDiscountInformationPK(DiscountInformationPK discountInformationPK) {
        this.discountInformationPK = discountInformationPK;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (discountInformationPK != null ? discountInformationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiscountInformation)) {
            return false;
        }
        DiscountInformation other = (DiscountInformation) object;
        if ((this.discountInformationPK == null && other.discountInformationPK != null) || (this.discountInformationPK != null && !this.discountInformationPK.equals(other.discountInformationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entity.DiscountInformation[ discountInformationPK=" + discountInformationPK + " ]";
    }
    
}
