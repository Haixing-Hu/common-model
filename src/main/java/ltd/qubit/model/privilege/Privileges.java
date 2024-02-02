////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.privilege;

import java.util.ArrayList;
import java.util.Collection;

import ltd.qubit.commons.lang.Assignable;

/**
 * 此模型表示用户的权限。
 *
 * @author 胡海星
 */
public class Privileges extends ArrayList<String> implements
    Assignable<Privileges> {

  private static final long serialVersionUID = 7510619465554403307L;

  public Privileges() {
    //  empty
  }

  public Privileges(final Collection<String> col) {
    super(col);
  }

  public Privileges(final Privileges other) {
    assign(other);
  }

  @Override
  public void assign(final Privileges other) {
    this.clear();
    this.addAll(other);
  }

  @Override
  public Privileges clone() {
    return new Privileges(this);
  }
}
