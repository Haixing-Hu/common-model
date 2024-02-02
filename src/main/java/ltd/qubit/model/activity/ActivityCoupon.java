////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.activity;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.model.order.OrderInfo;
import ltd.qubit.model.person.Person;
import ltd.qubit.model.util.Creatable;
import ltd.qubit.model.util.Identifiable;
import ltd.qubit.model.util.Info;

/**
 * 此模型表示活动券信息。
 *
 * @author 潘凯，胡海星
 */
public class ActivityCoupon implements Identifiable, Creatable,
    Assignable<ActivityCoupon> {

  private static final long serialVersionUID = 9086699292986090176L;

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 所属活动。
   */
  private Info activity;

  /**
   * 券码。
   */
  @Size(min = 1, max = 128)
  private String couponCode;

  /**
   * 领取人信息。
   */
  private Person person;

  /**
   * 订单信息。
   */
  private OrderInfo order;

  /**
   * 创建时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant createTime;

  /**
   * 领取时间。
   */
  @Precision(TimeUnit.SECONDS)
  private Instant receiveTime;

  public ActivityCoupon() {
    // empty
  }

  public ActivityCoupon(final ActivityCoupon other) {
    assign(other);
  }

  @Override
  public void assign(final ActivityCoupon other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    activity = Assignment.clone(other.activity);
    couponCode = other.couponCode;
    person = Assignment.clone(other.person);
    order = Assignment.clone(other.order);
    createTime = other.createTime;
    receiveTime = other.receiveTime;
  }

  @Override
  public ActivityCoupon clone() {
    return new ActivityCoupon(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Info getActivity() {
    return activity;
  }

  public void setActivity(final Info activity) {
    this.activity = activity;
  }

  public String getCouponCode() {
    return couponCode;
  }

  public void setCouponCode(final String couponCode) {
    this.couponCode = couponCode;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(final Person person) {
    this.person = person;
  }

  public OrderInfo getOrder() {
    return order;
  }

  public void setOrder(final OrderInfo order) {
    this.order = order;
  }

  public Instant getCreateTime() {
    return createTime;
  }

  public void setCreateTime(final Instant createTime) {
    this.createTime = createTime;
  }

  public Instant getReceiveTime() {
    return receiveTime;
  }

  public void setReceiveTime(final Instant receiveTime) {
    this.receiveTime = receiveTime;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final ActivityCoupon other = (ActivityCoupon) o;
    return Equality.equals(id, other.id)
        && Equality.equals(activity, other.activity)
        && Equality.equals(couponCode, other.couponCode)
        && Equality.equals(person, other.person)
        && Equality.equals(order, other.order)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(receiveTime, other.receiveTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, activity);
    result = Hash.combine(result, multiplier, couponCode);
    result = Hash.combine(result, multiplier, person);
    result = Hash.combine(result, multiplier, order);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, receiveTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("activity", activity)
        .append("couponCode", couponCode)
        .append("person", person)
        .append("order", order)
        .append("createTime", createTime)
        .append("receiveTime", receiveTime)
        .toString();
  }
}
