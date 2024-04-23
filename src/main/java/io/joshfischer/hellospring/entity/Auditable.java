package io.joshfischer.hellospring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class Auditable implements Serializable {

  @Serial private static final long serialVersionUID = -1680641543945088912L;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created", nullable = false)
  private Date created;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated", nullable = true)
  private Date updated;

  @Column(name = "create_id", length = 128, nullable = false)
  private String createId;

  @Column(name = "update_id", length = 128, nullable = true)
  private String updateId;

  @Column(name = "active", nullable = false)
  private Boolean active = true;

  public Date getCreated() {
    return created;
  }

  public void setCreated(final Date created) {
    this.created = created;
  }

  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(final Date updated) {
    this.updated = updated;
  }

  public String getCreateId() {
    return createId;
  }

  public void setCreateId(final String createId) {
    this.createId = createId;
  }

  public String getUpdateId() {
    return updateId;
  }

  public void setUpdateId(final String updateId) {
    this.updateId = updateId;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(final Boolean active) {
    this.active = active;
  }
}
