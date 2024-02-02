////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.product;

import org.junit.jupiter.api.Test;

import ltd.qubit.commons.test.ModelTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ltd.qubit.commons.reflect.FieldUtils.getFieldName;

/**
 * Unit test of the {@link ProductConstraint} class.
 *
 * @author Haixing Hu
 */
public class ProductConstraintTest extends ModelTestBase<ProductConstraint> {

  public ProductConstraintTest() {
    super(ProductConstraint.class);
  }

  @Test
  public void testGetFieldNameByGetterSetter() {
    assertEquals("ageEpoch", getFieldName(ProductConstraint.class, ProductConstraint::getAgeEpoch));
    assertEquals("ageEpoch", getFieldName(ProductConstraint.class, ProductConstraint::setAgeEpoch));
    assertEquals("adultAge", getFieldName(ProductConstraint.class, ProductConstraint::getAdultAge));
    assertEquals("adultAge", getFieldName(ProductConstraint.class, ProductConstraint::setAdultAge));
    assertEquals("selfOnly", getFieldName(ProductConstraint.class, ProductConstraint::isSelfOnly));
    assertEquals("selfOnly", getFieldName(ProductConstraint.class, ProductConstraint::setSelfOnly));
    assertEquals("buyer", getFieldName(ProductConstraint.class, ProductConstraint::getBuyer));
    assertEquals("buyer", getFieldName(ProductConstraint.class, ProductConstraint::setBuyer));
    assertEquals("client", getFieldName(ProductConstraint.class, ProductConstraint::getClient));
    assertEquals("client", getFieldName(ProductConstraint.class, ProductConstraint::setClient));
    assertEquals("sources", getFieldName(ProductConstraint.class, ProductConstraint::getSources));
    assertEquals("sources", getFieldName(ProductConstraint.class, ProductConstraint::setSources));
    assertEquals("limitForBuyer", getFieldName(ProductConstraint.class, ProductConstraint::getLimitForBuyer));
    assertEquals("limitForBuyer", getFieldName(ProductConstraint.class, ProductConstraint::setLimitForBuyer));
    assertEquals("limitForClient", getFieldName(ProductConstraint.class, ProductConstraint::getLimitForClient));
    assertEquals("limitForClient", getFieldName(ProductConstraint.class, ProductConstraint::setLimitForClient));
  }
}
