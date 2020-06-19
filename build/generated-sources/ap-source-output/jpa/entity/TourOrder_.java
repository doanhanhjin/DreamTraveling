package jpa.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entity.Account;
import jpa.entity.OrderDetail;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-15T09:15:53")
@StaticMetamodel(TourOrder.class)
public class TourOrder_ { 

    public static volatile SingularAttribute<TourOrder, Integer> total;
    public static volatile CollectionAttribute<TourOrder, OrderDetail> orderDetailCollection;
    public static volatile SingularAttribute<TourOrder, Date> dateOrder;
    public static volatile SingularAttribute<TourOrder, Integer> id;
    public static volatile SingularAttribute<TourOrder, Integer> discountId;
    public static volatile SingularAttribute<TourOrder, Account> userId;

}