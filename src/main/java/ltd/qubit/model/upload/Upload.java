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
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import jakarta.validation.constraints.Size;

import ltd.qubit.commons.annotation.Identifier;
import ltd.qubit.commons.annotation.Indexed;
import ltd.qubit.commons.annotation.Precision;
import ltd.qubit.commons.io.FilenameUtils;
import ltd.qubit.commons.lang.Argument;
import ltd.qubit.commons.lang.Assignable;
import ltd.qubit.commons.lang.Assignment;
import ltd.qubit.commons.lang.Equality;
import ltd.qubit.commons.lang.Hash;
import ltd.qubit.commons.text.tostring.ToStringBuilder;
import ltd.qubit.commons.util.UuidUtils;
import ltd.qubit.model.util.Creatable;
import ltd.qubit.model.util.Deletable;
import ltd.qubit.model.util.Identifiable;

import static ltd.qubit.commons.io.FileUtils.getPath;
import static ltd.qubit.commons.lang.SystemUtils.JAVA_IO_TMPDIR;

/**
 * 此模型表示一个上传的文件的元信息。
 *
 * @author 胡海星
 */
public class Upload implements Identifiable, Creatable, Deletable,
    Assignable<Upload> {

  private static final long serialVersionUID = -1521818404700070671L;

  public static final String SCREENSHOT_SUFFIX = "_screenshot";

  public static final String SMALL_THUMBNAIL_SUFFIX = "_thumbnail_small";

  public static final String LARGE_THUMBNAIL_SUFFIX = "_thumbnail_large";

  public static final String IMAGE_EXTENSION = "jpg";

  public static final String IMAGE_FORMAT = "jpeg";

  public static final String IMAGE_CONTENT_TYPE = "image/jpeg";

  /**
   * 唯一标识，系统自动生成。
   */
  @Identifier
  private Long id;

  /**
   * 上传的原始文件的文件名，可能包含中文字符。
   */
  @Size(min = 1, max = 128)
  @Nullable
  private String originalFilename;

  /**
   * 附件类型。
   */
  @Indexed
  private AttachmentType type;

  /**
   * 原始文件在服务器上的存储信息。
   */
  private FileInfo file;

  /**
   * 原始文件的截屏在服务器上的存储信息。
   *
   * <p>对于原始文件是视频的情况，其截屏即其视频第一帧的截屏；对于原始文件是图像文件的情况，
   * 其截屏即其按照预设值尺寸压缩后的图片（原始文件可能很大），以便于向用户展示；对于原始文件
   * 是音频的情况，其截屏不存在，此属性为{@code null}。</p>
   */
  @Nullable
  private FileInfo screenshot;

  /**
   * 小尺寸缩略图在服务器上的存储信息。
   *
   * <p>对于原始文件是视频的情况，其缩略图即其截屏的缩略图；对于原始文件是图像文件的情况，
   * 其缩略图即其原始文件的缩略图；对于原始文件是音频的情况，其缩略图不存在，此属性为
   * {@code null}。</p>
   */
  @Nullable
  private FileInfo smallThumbnail;

  /**
   * 大尺寸缩略图在服务器上的存储信息。
   *
   * <p>对于原始文件是视频的情况，其缩略图即其截屏的缩略图；对于原始文件是图像文件的情况，
   * 其缩略图即其原始文件的缩略图；对于原始文件是音频的情况，其缩略图不存在，此属性为
   * {@code null}。</p>
   */
  @Nullable
  private FileInfo largeThumbnail;

  /**
   * 创建时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Indexed
  private Instant createTime;

  /**
   * 标记删除时间。
   */
  @Precision(TimeUnit.SECONDS)
  @Indexed
  @Nullable
  private Instant deleteTime;

  public Upload() {
    // empty
  }

  public Upload(final Upload other) {
    assign(other);
  }

  @Override
  public void assign(final Upload other) {
    Argument.requireNonNull("other", other);
    id = other.id;
    originalFilename = other.originalFilename;
    type = other.type;
    file = Assignment.clone(other.file);
    screenshot = Assignment.clone(other.screenshot);
    smallThumbnail = Assignment.clone(other.smallThumbnail);
    largeThumbnail = Assignment.clone(other.largeThumbnail);
    createTime = other.createTime;
    deleteTime = other.deleteTime;
  }

  @Override
  public Upload clone() {
    return new Upload(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  @Nullable
  public String getOriginalFilename() {
    return originalFilename;
  }

  public void setOriginalFilename(@Nullable final String originalFilename) {
    this.originalFilename = originalFilename;
  }

  public AttachmentType getType() {
    return type;
  }

  public void setType(final AttachmentType type) {
    this.type = type;
  }

  public FileInfo getFile() {
    return file;
  }

  public void setFile(final FileInfo file) {
    this.file = file;
  }

  @Nullable
  public FileInfo getScreenshot() {
    return screenshot;
  }

  public void setScreenshot(@Nullable final FileInfo screenshot) {
    this.screenshot = screenshot;
  }

  @Nullable
  public FileInfo getSmallThumbnail() {
    return smallThumbnail;
  }

  public void setSmallThumbnail(@Nullable final FileInfo smallThumbnail) {
    this.smallThumbnail = smallThumbnail;
  }

  @Nullable
  public FileInfo getLargeThumbnail() {
    return largeThumbnail;
  }

  public void setLargeThumbnail(@Nullable final FileInfo largeThumbnail) {
    this.largeThumbnail = largeThumbnail;
  }

  public Instant getCreateTime() {
    return createTime;
  }

  public void setCreateTime(final Instant createTime) {
    this.createTime = createTime;
  }

  @Nullable
  public Instant getDeleteTime() {
    return deleteTime;
  }

  public void setDeleteTime(@Nullable final Instant deleteTime) {
    this.deleteTime = deleteTime;
  }

  public boolean equals(@Nullable final Object o) {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    final Upload other = (Upload) o;
    return Equality.equals(id, other.id)
        && Equality.equals(originalFilename, other.originalFilename)
        && Equality.equals(type, other.type)
        && Equality.equals(file, other.file)
        && Equality.equals(screenshot, other.screenshot)
        && Equality.equals(smallThumbnail, other.smallThumbnail)
        && Equality.equals(largeThumbnail, other.largeThumbnail)
        && Equality.equals(createTime, other.createTime)
        && Equality.equals(deleteTime, other.deleteTime);
  }

  public int hashCode() {
    final int multiplier = 7;
    int result = 3;
    result = Hash.combine(result, multiplier, id);
    result = Hash.combine(result, multiplier, originalFilename);
    result = Hash.combine(result, multiplier, type);
    result = Hash.combine(result, multiplier, file);
    result = Hash.combine(result, multiplier, screenshot);
    result = Hash.combine(result, multiplier, smallThumbnail);
    result = Hash.combine(result, multiplier, largeThumbnail);
    result = Hash.combine(result, multiplier, createTime);
    result = Hash.combine(result, multiplier, deleteTime);
    return result;
  }

  public String toString() {
    return new ToStringBuilder(this)
        .append("id", id)
        .append("originalFilename", originalFilename)
        .append("type", type)
        .append("file", file)
        .append("screenshot", screenshot)
        .append("smallThumbnail", smallThumbnail)
        .append("largeThumbnail", largeThumbnail)
        .append("createTime", createTime)
        .append("deleteTime", deleteTime)
        .toString();
  }

  public FileInfo setFileInfo(final File file, final String contentType) {
    this.file = new FileInfo();
    this.file.setPath(file.getAbsolutePath());
    this.file.setSize(file.length());
    this.file.setContentType(contentType);
    return this.file;
  }

  public FileInfo setScreenshotInfo() {
    final String fileBasename;
    if (file == null) {
      fileBasename = UuidUtils.getUuid();
    } else {
      fileBasename = FilenameUtils.getBasename(file.getPath());
    }
    final String basename = fileBasename + SCREENSHOT_SUFFIX;
    final String path = getPath(JAVA_IO_TMPDIR, basename, IMAGE_EXTENSION);
    screenshot = new FileInfo();
    screenshot.setPath(path);
    screenshot.setFormat(IMAGE_FORMAT);
    screenshot.setContentType(IMAGE_CONTENT_TYPE);
    return screenshot;
  }

  public FileInfo setSmallThumbnailInfo() {
    final String fileBasename;
    if (file == null) {
      fileBasename = UuidUtils.getUuid();
    } else {
      fileBasename = FilenameUtils.getBasename(file.getPath());
    }
    final String basename = fileBasename + SMALL_THUMBNAIL_SUFFIX;
    final String path = getPath(JAVA_IO_TMPDIR, basename, IMAGE_EXTENSION);
    smallThumbnail = new FileInfo();
    smallThumbnail.setPath(path);
    smallThumbnail.setFormat(IMAGE_FORMAT);
    smallThumbnail.setContentType(IMAGE_CONTENT_TYPE);
    return smallThumbnail;
  }

  public FileInfo setLargeThumbnailInfo() {
    final String fileBasename;
    if (file == null) {
      fileBasename = UuidUtils.getUuid();
    } else {
      fileBasename = FilenameUtils.getBasename(file.getPath());
    }
    final String basename = fileBasename + LARGE_THUMBNAIL_SUFFIX;
    final String path = getPath(JAVA_IO_TMPDIR, basename, IMAGE_EXTENSION);
    largeThumbnail = new FileInfo();
    largeThumbnail.setPath(path);
    largeThumbnail.setFormat(IMAGE_FORMAT);
    largeThumbnail.setContentType(IMAGE_CONTENT_TYPE);
    return largeThumbnail;
  }

  public AttachmentType setContentType(final String contentType) {
    if (file != null) {
      file.setContentType(contentType);
    }
    type = AttachmentType.forContentType(contentType);
    return type;
  }

  /**
   * 根据原始文件路径信息创建一个新的{@link Upload}对象。
   *
   * <p>创建的新的{@link Upload}对象并不会存入数据库，</p>
   * <ul>
   * <li>其{@code file.path}会被设置为原始文件的绝对路径；</li>
   * <li>其{@code screenshot.path}, {@code smallThumbnail.path},
   * {@code largeThumbnail.path}会被设置为临时文件路径，但这些临时文件不会被创建，需要由
   * 此函数调用方处理。</li>
   * </ul>
   *
   * @param originalFilename
   *     原始文件的文件名。
   * @param path
   *     原始文件在本地文件系统中的路径。
   * @param contentType
   *     原始文件的MIME类型，需要由此函数调用方检测并提供。
   * @return
   *     根据原始文件路径信息创建的新的{@link Upload}对象。
   */
  public static Upload create(final String originalFilename, final File path,
      final String contentType) {
    final Upload upload = new Upload();
    upload.setOriginalFilename(originalFilename);
    upload.setFileInfo(path, contentType);
    upload.setScreenshotInfo();
    upload.setSmallThumbnailInfo();
    upload.setLargeThumbnailInfo();
    upload.setContentType(contentType);
    return upload;
  }
}
