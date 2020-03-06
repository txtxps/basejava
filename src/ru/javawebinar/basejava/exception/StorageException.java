package ru.javawebinar.basejava.exception;

public class StorageException extends RuntimeException {
  private final String uuid;

  public StorageException(String message, String uuid) {
    this.uuid = uuid;
  }

  public String getUuid() {
    return uuid;
  }
}
