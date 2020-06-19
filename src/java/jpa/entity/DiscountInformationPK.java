/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author user
 */
@Embeddable
public class DiscountInformationPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "discountId", nullable = false)
    private int discountId;
    @Basic(optional = false)
    @Column(name = "userId", nullable = false, length = 50)
    private String userId;

    public DiscountInformationPK() {
    }

    public DiscountInformationPK(int discountId, String userId) {
        this.discountId = discountId;
        this.userId = userId;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) discountId;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiscountInformationPK)) {
            return false;
        }
        DiscountInformationPK other = (DiscountInformationPK) object;
        if (this.discountId != other.discountId) {
            return false;
        }
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entity.DiscountInformationPK[ discountId=" + discountId + ", userId=" + userId + " ]";
    }
    
}
