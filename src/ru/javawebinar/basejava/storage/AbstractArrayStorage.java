package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
  protected static final int STORAGE_LIMIT = 10000;

  protected Resume[] storage = new Resume[STORAGE_LIMIT];
  protected int size = 0;

  public int size() {
    return size;
  }

  public void clear() {
    Arrays.fill(storage, 0, size, null);
    size = 0;
  }

  public Resume get(String uuid) {
    int index = getIndex(uuid);
    if (index < 0) {
      System.out.println("Resume " + uuid + " is not exist");
      return null;
    }
    return storage[index];
  }

  public void update(Resume r) {
    int index = getIndex(r.getUuid());
    if (index < 0) {
      System.out.println("Resume " + r.getUuid() + " is not exist");
    } else {
      storage[index] = r;
    }
  }

  /**
   * @return array, contains only Resumes in storage (without null)
   */
  public Resume[] getAll() {
    return Arrays.copyOfRange(storage, 0, size);
  }

  public void save(Resume r) {
    int index = getIndex(r.getUuid());
    if (index >= 0) {
      System.out.println("Resume " + r.getUuid() + " already exist");
    } else if (size == STORAGE_LIMIT) {
      System.out.println("Storage overflow");
    } else {
      insert(r, index);
      size++;
    }
  }

  public void delete(String uuid) {
    int index = getIndex(uuid);
    if (index < 0) {
      System.out.println("Resume " + uuid + "is not exist");
    } else {
      fillDeletedElement(index);
      storage[size - 1] = null;
      size--;
    }
  }

  protected abstract int getIndex(String uuid);

  protected abstract void insert(Resume r, int index);

  protected abstract void fillDeletedElement(int index);
}
