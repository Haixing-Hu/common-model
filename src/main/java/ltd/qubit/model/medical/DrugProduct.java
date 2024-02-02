////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.medical;

import java.io.Serializable;

import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.product.ProductInfo;

/**
 * 此模型表示药品、商品的关联关系。
 *
 * @author 孙建
 */
public class DrugProduct implements Serializable {

  private static final long serialVersionUID = -447140312970760916L;

  /**
   * 药品信息。
   */
  private DrugInfo drug;

  /**
   * 商品信息。
   */
  private ProductInfo product;

  public DrugInfo getDrug() {
    return drug;
  }

  public void setDrug(final DrugInfo drug) {
    this.drug = drug;
  }

  public ProductInfo getProduct() {
    return product;
  }

  public void setProduct(final ProductInfo product) {
    this.product = product;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final DrugProduct other = (DrugProduct) o;
    return Equality.equals(product, other.product)
            && Equality.equals(drug, other.drug);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, product);
    result = Hash.combine(result, multiplier, drug);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("product", product)
            .append("drug", drug)
            .toString();
  }
}
