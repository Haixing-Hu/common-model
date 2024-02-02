////////////////////////////////////////////////////////////////////////////////
//
//    Copyright (c) 2022 - 2024.
//    Haixing Hu, Qubit Co. Ltd.
//
//    All rights reserved.
//
////////////////////////////////////////////////////////////////////////////////
package ltd.qubit.model.upload;

import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Scale;
import ltd.qubit.commons.annotation.Unique;
import ltd.qubit.commons.image.ImageSize;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;

/**
 * 此模型表示存储在服务器上的文件的元信息。
 *
 * @author 胡海星
 */
public class FileInfo implements Serializable, Assignable<FileInfo> {

  private static final long serialVersionUID = -2698757688586607397L;

  /**
   * 文件存储位置的路径，只能包含ASCII字符。
   *
   * <p>此属性值根据实际存储设备不同而有不同含义：</p>
   * <ul>
   * <li>若存储设备是本地文件系统，此属性值表示本地文件系统中的绝对路径或相对路径；</li>
   * <li>若存储设备是分布式文件系统，此属性值表示分布式文件中的绝对路径或相对路径；</li>
   * <li>若存储设备是云存储系统，此属性值表示云存储系统中的绝对URL或相对URL。</li>
   * </ul>
   */
  @Size(min = 1, max = 512)
  @Unique
  private String path;

  /**
   * 文件格式。
   */
  @Size(min = 1, max = 128)
  private String format;

  /**
   * 文件的Content-Type。
   */
  @Size(min = 1, max = 128)
  private String contentType;

  /**
   * 文件大小，单位为字节。
   */
  private Long size;

  /**
   * （图像或视频）文件的宽度，单位为像素。
   */
  @Nullable
  private Integer width;

  /**
   * （图像或视频）文件的高度，单位为像素。
   */
  @Nullable
  private Integer height;

  /**
   * 视频或音频文件的长度，单位为秒。
   */
  @Nullable
  private Integer duration;

  /**
   * 图像、视频或音频文件的压缩质量，100%为无损压缩。
   */
  @Nullable
  @Scale(2)
  private BigDecimal quality;

  public FileInfo() {
    // empty
  }

  public FileInfo(final FileInfo other) {
    assign(other);
  }

  @Override
  public void assign(final FileInfo other) {
    Argument.requireNonNull("other", other);
    path = other.path;
    format = other.format;
    contentType = other.contentType;
    size = other.size;
    width = other.width;
    height = other.height;
    duration = other.duration;
    quality = other.quality;
  }

  @Override
  public FileInfo clone() {
    return new FileInfo(this);
  }

  public String getPath() {
    return path;
  }

  public void setPath(final String path) {
    this.path = path;
  }

  public String getFormat() {
    return format;
  }

  public void setFormat(final String format) {
    this.format = format;
  }

  public String getContentType() {
    return contentType;
  }

  public void setContentType(final String contentType) {
    this.contentType = contentType;
  }

  public Long getSize() {
    return size;
  }

  public void setSize(final Long size) {
    this.size = size;
  }

  @Nullable
  public Integer getWidth() {
    return width;
  }

  public void setWidth(@Nullable final Integer width) {
    this.width = width;
  }

  @Nullable
  public Integer getHeight() {
    return height;
  }

  public void setHeight(@Nullable final Integer height) {
    this.height = height;
  }

  @Nullable
  public Integer getDuration() {
    return duration;
  }

  public void setDuration(@Nullable final Integer duration) {
    this.duration = duration;
  }

  @Nullable
  public BigDecimal getQuality() {
    return quality;
  }

  public void setQuality(@Nullable final BigDecimal quality) {
    this.quality = quality;
  }

  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final FileInfo other = (FileInfo) o;
    return Equality.equals(path, other.path)
        && Equality.equals(format, other.format)
        && Equality.equals(contentType, other.contentType)
        && Equality.equals(size, other.size)
        && Equality.equals(width, other.width)
        && Equality.equals(height, other.height)
        && Equality.equals(duration, other.duration)
        && Equality.equals(quality, other.quality);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, path);
    result = Hash.combine(result, multiplier, format);
    result = Hash.combine(result, multiplier, contentType);
    result = Hash.combine(result, multiplier, size);
    result = Hash.combine(result, multiplier, width);
    result = Hash.combine(result, multiplier, height);
    result = Hash.combine(result, multiplier, duration);
    result = Hash.combine(result, multiplier, quality);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("path", path)
        .append("format", format)
        .append("contentType", contentType)
        .append("size", size)
        .append("width", width)
        .append("height", height)
        .append("duration", duration)
        .append("quality", quality)
        .toString();
  }

  /**
   * 获取此对象在本地文件系统中的路径。
   *
   * @return
   *     此对象在本地文件系统中的路径，根据此对象的URL转换而来。
   */
  public File toLocalFile() {
    return new File(path);
  }

  public void setImageSize(@Nullable final ImageSize imageSize) {
    if (imageSize == null) {
      width = null;
      height = null;
    } else {
      width = imageSize.width;
      height = imageSize.height;
    }
  }
}
