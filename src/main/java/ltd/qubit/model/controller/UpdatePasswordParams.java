////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.controller;

import java.io.Serializable;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;

/**
 * 此数据结构封装了更新密码操作所需提供的参数。
 *
 * <p>注意请求参数中，{@code username}, {@code email}, {@code mobile}至少需要有一个。
 *
 * @author 胡海星
 */
public class UpdatePasswordParams implements Serializable {

  private static final long serialVersionUID = 3282692895238954120L;

  /**
   * 旧密码.
   */
  @Size(min = 1, max = 64)
  @Nullable
  private String oldPassword;

  /**
   * 新密码.
   */
  @Size(min = 1, max = 64)
  private String newPassword;

  /**
   * 下次登录是否需强制更改密码.
   */
  @Nullable
  private Boolean changePassword;

  @Nullable
  public String getOldPassword() {
    return oldPassword;
  }

  public void setOldPassword(@Nullable final String oldPassword) {
    this.oldPassword = oldPassword;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(final String newPassword) {
    this.newPassword = newPassword;
  }

  @Nullable
  public Boolean isChangePassword() {
    return changePassword;
  }

  public void setChangePassword(@Nullable final Boolean changePassword) {
    this.changePassword = changePassword;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final UpdatePasswordParams other = (UpdatePasswordParams) o;
    return Equality.equals(oldPassword, other.oldPassword)
            && Equality.equals(newPassword, other.newPassword)
            && Equality.equals(changePassword, other.changePassword);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, oldPassword);
    result = Hash.combine(result, multiplier, newPassword);
    result = Hash.combine(result, multiplier, changePassword);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("oldPassword", oldPassword)
            .append("newPassword", newPassword)
            .append("changePassword", changePassword)
            .toString();
  }
}
