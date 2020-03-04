package ru.javawebinar.basejava.model;

import java.util.Objects;

/**
 * Initial resume class
 */
public class Resume {

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Resume resume = (Resume) o;
    return Objects.equals(uuid, resume.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid);
  }

  // Unique identifier
  String uuid;

  @Override
  public String toString() {
    return uuid;
  }
}
