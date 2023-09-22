package io.github.librarymanagement.model.entity;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import lombok.ToString;

@MappedSuperclass
@ToString(onlyExplicitlyIncluded = true, callSuper = false)
@Data
public class BaseEntity implements Serializable {

  /**
   * The date created.
   */
  @Column(name = "DATE_CREATED")
  protected Instant dateCreated;

  /**
   * The date deactivated.
   */
  @ToString.Include
  @Column(name = "DATE_DEACTIVATED")
  protected Instant dateDeactivated;

  /**
   * The date modified.
   */
  @Column(name = "DATE_MODIFIED")
  protected Instant dateModified;

  /**
   * The user created.
   */
  @Column(name = "USER_CREATED")
  protected String userCreated;

  /**
   * The user deactivated.
   */
  @Column(name = "USER_DEACTIVATED")
  protected String userDeactivated;

  /**
   * The user modified.
   */
  @Column(name = "USER_MODIFIED")
  protected String userModified;

  /**
   * The Constructor.
   */
  public BaseEntity() {
    super();
  }

  @PrePersist
  public void prePersist() {
    if (dateCreated == null) {
      dateCreated = Instant.now();
    }
  }

  @PreUpdate
  public void preUpdate() {
    this.dateModified = Instant.now();
  }
}
