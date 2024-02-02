////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.invoice;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.State;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.HasInfo;
import ltd.qubit.model.util.StatefulInfo;
import ltd.qubit.model.util.WithApp;
import ltd.qubit.model.util.WithOrganization;

/**
 * 此模型表示开票点信息。
 *
 * @author 徐伟，胡海星
 */
public class InvoicePlace implements HasInfo, WithApp, WithOrganization,
    Auditable {

  private static final long serialVersionUID = -6807234780640284682L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 所属 App 的基本信息。
   */
  private StatefulInfo app;

  /**
   * 所属机构的基本信息。
   */
  private StatefulInfo organization;

  /**
   * 开票点编码。
   */
  @Size(min = 1, max = 64)
  private String code;

  /**
   * 开票点名称。
   */
  @Size(min = 1, max = 128)
  private String name;

  /**
   * 开票点状态。
   */
  private State state;

  /**
   * 创建时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  /**
   * 最后一次修改时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant modifyTime;

  /**
   * 删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Nullable
  private Instant deleteTime;

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(final Long id) {
    this.id = id;
  }

  @Override
  public StatefulInfo getApp() {
    return app;
  }

  @Override
  public void setApp(final StatefulInfo app) {
    this.app = app;
  }

  @Override
  public StatefulInfo getOrganization() {
    return organization;
  }

  @Override
  public void setOrganization(final StatefulInfo organization) {
    this.organization = organization;
  }

  @Override
  public String getCode() {
    return code;
  }

  @Override
  public void setCode(final String code) {
    this.code = code;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(final String name) {
    this.name = name;
  }

  public State getState() {
    return state;
  }

  public void setState(final State state) {
    this.state = state;
  }

  @Override
  public Instant getCreateTime() {
    return createTime;
  }

  @Override
  public void setCreateTime(final Instant createTime) {
    this.createTime = createTime;
  }

  @Override
  @Nullable
  public Instant getModifyTime() {
    return modifyTime;
  }

  @Override
  public void setModifyTime(@Nullable final Instant modifyTime) {
    this.modifyTime = modifyTime;
  }

  @Override
  @Nullable
  public Instant getDeleteTime() {
    return deleteTime;
  }

  @Override
  public void setDeleteTime(@Nullable final Instant deleteTime) {
    this.deleteTime = deleteTime;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final InvoicePlace other = (InvoicePlace) o;
    return Equality.equals(id, other.id)
            && Equality.equals(app, other.app)
            && Equality.equals(organization, other.organization)
            && Equality.equals(code, other.code)
            && Equality.equals(name, other.name)
            && Equality.equals(state, other.state)
            && Equality.equals(createTime, other.createTime)
            && Equality.equals(modifyTime, other.modifyTime)
            && Equality.equals(deleteTime, other.deleteTime);
  }

  @Override
  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, app);
    result = Hash.combine(result, multiplier, organization);
    result = Hash.combine(result, multiplier, code);
    result = Hash.combine(result, multiplier, name);
    result = Hash.combine(result, multiplier, state);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
            .append("id", id)
            .append("app", app)
            .append("organization", organization)
            .append("code", code)
            .append("name", name)
            .append("state", state)
            .append("createTime", createTime)
            .append("modifyTime", modifyTime)
            .append("deleteTime", deleteTime)
            .toString();
  }
}
