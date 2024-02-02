////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.settlement;

import java.time.Instant;

import javax.annotation.Nullable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Reference;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.commons.App;
import ltd.qubit.model.medical.MedicalSettlement;
import ltd.qubit.model.organization.Organization;
import ltd.qubit.model.util.Auditable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.StatefulInfo;
import ltd.qubit.model.util.WithApp;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

/**
 * 此抽象类表示结算信息，不同业务有不同的实现。
 *
 * @author 胡海星
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({MedicalSettlement.class})
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "entity", visible = false)
@JsonSubTypes({
    @Type(value = MedicalSettlement.class, name = "MEDICAL_SETTLEMENT")
})
@JsonAutoDetect(fieldVisibility = ANY,
    getterVisibility = NONE,
    isGetterVisibility = NONE,
    setterVisibility = NONE)
@JsonInclude(Include.NON_NULL)
public abstract class Settlement implements Identifiable, WithApp, Auditable {

  private static final long serialVersionUID = 3670828620109631936L;

  /**
   * 记录在系统中的ID，唯一标识，系统自动生成。
   */
  @Identifier
  protected Long id;

  /**
   * 所属App的基本信息。
   */
  @Reference(entity = App.class, property = "info")
  protected StatefulInfo app;

  /**
   * 所属机构的基本信息。
   */
  @Reference(entity = Organization.class, property = "info")
  protected StatefulInfo organization;

  /**
   * 备注。
   */
  @Nullable
  protected String remark;

  /**
   * 此记录的创建时间。
   */
  protected Instant createTime;

  /**
   * 此记录的最后一次修改时间。
   */
  @Nullable
  protected Instant modifyTime;

  /**
   * 此记录的标记删除时间。
   */
  @Nullable
  protected Instant deleteTime;

  public Settlement() {
    // empty
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public StatefulInfo getApp() {
    return app;
  }

  public void setApp(final StatefulInfo app) {
    this.app = app;
  }

  public StatefulInfo getOrganization() {
    return organization;
  }

  public void setOrganization(final StatefulInfo organization) {
    this.organization = organization;
  }

  @Nullable
  public String getRemark() {
    return remark;
  }

  public void setRemark(@Nullable final String remark) {
    this.remark = remark;
  }

  public Instant getCreateTime() {
    return createTime;
  }

  public void setCreateTime(final Instant createTime) {
    this.createTime = createTime;
  }

  @Nullable
  public Instant getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(@Nullable final Instant modifyTime) {
    this.modifyTime = modifyTime;
  }

  @Nullable
  public Instant getDeleteTime() {
    return deleteTime;
  }

  public void setDeleteTime(@Nullable final Instant deleteTime) {
    this.deleteTime = deleteTime;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Settlement other = (Settlement) o;
    return Equality.equals(id, other.id)
        && Equality.equals(app, other.app)
        && Equality.equals(organization, other.organization)
        && Equality.equals(remark, other.remark)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(modifyTime, other.modifyTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, app);
    result = Hash.combine(result, multiplier, organization);
    result = Hash.combine(result, multiplier, remark);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, modifyTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("app", app)
        .append("organization", organization)
        .append("remark", remark)
        .append("createTime", createTime)
        .append("modifyTime", modifyTime)
        .append("deleteTime", deleteTime)
        .toString();
  }
}
