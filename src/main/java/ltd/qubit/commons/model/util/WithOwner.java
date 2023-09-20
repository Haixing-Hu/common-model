////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2023.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.commons.model.util;

/**
 * This interface represents that an entity class has an owner (which is another
 * entity object) attribute.
 *
 * @author Haixing Hu
 */
public interface WithOwner {

  /**
   * Get basic information about the owner of the current object.
   *
   * @return
   *     Basic information about the owner of the current object, including
   *     entity type and entity ID.
   */
  Owner getOwner();

  /**
   * Sets the owner of the current object.
   *
   * @param owner
   *     Basic information about the new owner, including entity type and
   *     entity ID.
   */
  void setOwner(Owner owner);
}
