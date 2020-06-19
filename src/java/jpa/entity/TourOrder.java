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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TourOrder", catalog = "DreamTraveling", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TourOrder.findAll", query = "SELECT t FROM TourOrder t")
    , @NamedQuery(name = "TourOrder.findById", query = "SELECT t FROM TourOrder t WHERE t.id = :id")
    , @NamedQuery(name = "TourOrder.findByDiscountId", query = "SELECT t FROM TourOrder t WHERE t.discountId = :discountId")
    , @NamedQuery(name = "TourOrder.findByTotal", query = "SELECT t FROM TourOrder t WHERE t.total = :total")
    , @NamedQuery(name = "TourOrder.findByDateOrder", query = "SELECT t FROM TourOrder t WHERE t.dateOrder = :dateOrder")})
public class TourOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Column(name = "discountId")
    private Integer discountId;
    @Column(name = "total")
    private Integer total;
    @Column(name = "dateOrder")
    @Temporal(TemporalType.DATE)
    private Date dateOrder;
    @OneToMany(mappedBy = "orderId")
    private Collection<OrderDetail> orderDetailCollection;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne
    private Account userId;

    public TourOrder() {
    }

    public TourOrder(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    @XmlTransient
    public Collection<OrderDetail> getOrderDetailCollection() {
        return orderDetailCollection;
    }

    public void setOrderDetailCollection(Collection<OrderDetail> orderDetailCollection) {
        this.orderDetailCollection = orderDetailCollection;
    }

    public Account getUserId() {
        return userId;
    }

    public void setUserId(Account userId) {
        this.userId = userId;
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
        if (!(object instanceof TourOrder)) {
            return false;
        }
        TourOrder other = (TourOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entity.TourOrder[ id=" + id + " ]";
    }
    
}
