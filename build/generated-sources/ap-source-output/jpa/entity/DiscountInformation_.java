package jpa.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.entity.Account;
import jpa.entity.Discount;
import jpa.entity.DiscountInformationPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-15T09:15:53")
@StaticMetamodel(DiscountInformation.class)
public class DiscountInformation_ { 

    public static volatile SingularAttribute<DiscountInformation, Discount> discount;
    public static volatile SingularAttribute<DiscountInformation, DiscountInformationPK> discountInformationPK;
    public static volatile SingularAttribute<DiscountInformation, Account> account;
    public static volatile SingularAttribute<DiscountInformation, String> status;

}