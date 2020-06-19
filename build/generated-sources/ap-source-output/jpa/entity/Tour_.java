package jpa.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entity.OrderDetail;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-15T09:15:53")
@StaticMetamodel(Tour.class)
public class Tour_ { 

    public static volatile SingularAttribute<Tour, Date> fromDate;
    public static volatile SingularAttribute<Tour, String> image;
    public static volatile SingularAttribute<Tour, Date> dateImport;
    public static volatile CollectionAttribute<Tour, OrderDetail> orderDetailCollection;
    public static volatile SingularAttribute<Tour, Integer> price;
    public static volatile SingularAttribute<Tour, Date> toDate;
    public static volatile SingularAttribute<Tour, Integer> quota;
    public static volatile SingularAttribute<Tour, String> toPlace;
    public static volatile SingularAttribute<Tour, Integer> id;
    public static volatile SingularAttribute<Tour, String> tourName;
    public static volatile SingularAttribute<Tour, String> status;

}