package jpa.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entity.DiscountInformation;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-15T09:15:53")
@StaticMetamodel(Discount.class)
public class Discount_ { 

    public static volatile SingularAttribute<Discount, Integer> sale;
    public static volatile SingularAttribute<Discount, String> discountCode;
    public static volatile SingularAttribute<Discount, Date> dateExpired;
    public static volatile SingularAttribute<Discount, Integer> id;
    public static volatile CollectionAttribute<Discount, DiscountInformation> discountInformationCollection;

}