package jpa.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entity.DiscountInformation;
import jpa.entity.TourOrder;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-15T09:15:53")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, String> password;
    public static volatile SingularAttribute<Account, String> roleName;
    public static volatile SingularAttribute<Account, String> fullName;
    public static volatile SingularAttribute<Account, String> userId;
    public static volatile CollectionAttribute<Account, TourOrder> tourOrderCollection;
    public static volatile CollectionAttribute<Account, DiscountInformation> discountInformationCollection;

}