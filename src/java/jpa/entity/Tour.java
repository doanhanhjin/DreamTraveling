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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Tour", catalog = "DreamTraveling", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tour.findAll", query = "SELECT t FROM Tour t")
    , @NamedQuery(name = "Tour.findById", query = "SELECT t FROM Tour t WHERE t.id = :id")
    , @NamedQuery(name = "Tour.findByTourName", query = "SELECT t FROM Tour t WHERE t.tourName = :tourName")
    , @NamedQuery(name = "Tour.findByFromDate", query = "SELECT t FROM Tour t WHERE t.fromDate = :fromDate")
    , @NamedQuery(name = "Tour.findByDate", query = "SELECT t FROM Tour t WHERE :toDate BETWEEN t.fromDate AND t.toDate")
    , @NamedQuery(name = "Tour.findByPrice", query = "SELECT t FROM Tour t WHERE t.price BETWEEN :minPrice AND :maxPrice")
    , @NamedQuery(name = "Tour.findByQuota", query = "SELECT t FROM Tour t WHERE t.quota = :quota")
    , @NamedQuery(name = "Tour.findByImage", query = "SELECT t FROM Tour t WHERE t.image = :image")
    , @NamedQuery(name = "Tour.findByToPlace", query = "SELECT t FROM Tour t WHERE t.toPlace LIKE :toPlace")
    , @NamedQuery(name = "Tour.findByStatus", query = "SELECT t FROM Tour t WHERE t.status = :status")
    , @NamedQuery(name = "Tour.findByDateImport", query = "SELECT t FROM Tour t WHERE t.dateImport = :dateImport")
//    , @NamedQuery(name = "Tour.findTourPaging", query ="SELECT t FROM (SELECT t, ROW_NUMBER() OVER (ORDER BY t.price) AS RowNum FROM Tour) "
//            + "AS MyDerivedTable WHERE MyDerivedTable.RowNum BETWEEN :minPage AND MyDerivedTable.RowNum AND toPlace LIKE 'Sa Pa'")
})
public class Tour implements Serializable {

    @Column(name = "price")
    private Integer price;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "tourName", length = 150)
    private String tourName;
    @Column(name = "fromDate")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Column(name = "toDate")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @Column(name = "quota")
    private Integer quota;
    @Column(name = "image", length = 2147483647)
    private String image;
    @Column(name = "toPlace", length = 50)
    private String toPlace;
    @Column(name = "status", length = 20)
    private String status;
    @Column(name = "dateImport")
    @Temporal(TemporalType.DATE)
    private Date dateImport;
    @OneToMany(mappedBy = "tourId")
    private Collection<OrderDetail> orderDetailCollection;

    public Tour() {
    }

    public Tour(String tourName, Date fromDate, Date toDate, Integer price, Integer quota, String image, String toPlace, String status, Date dateImport) {
        this.tourName = tourName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.price = price;
        this.quota = quota;
        this.image = image;
        this.toPlace = toPlace;
        this.status = status;
        this.dateImport = dateImport;
    }

    
    public Tour(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }


    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateImport() {
        return dateImport;
    }

    public void setDateImport(Date dateImport) {
        this.dateImport = dateImport;
    }

    @XmlTransient
    public Collection<OrderDetail> getOrderDetailCollection() {
        return orderDetailCollection;
    }

    public void setOrderDetailCollection(Collection<OrderDetail> orderDetailCollection) {
        this.orderDetailCollection = orderDetailCollection;
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
        if (!(object instanceof Tour)) {
            return false;
        }
        Tour other = (Tour) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entity.Tour[ id=" + id + " ]";
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    
}
