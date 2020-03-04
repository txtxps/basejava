package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

  @Override
  protected void insert(Resume r, int index) {
    storage[size] = r;
  }

  @Override
  protected void fillDeletedElement(int index) {
    storage[index] = storage[size - 1];
  }

  protected int getIndex(String uuid) {
    for (int i = 0; i < size; i++) {
      if (storage[i].getUuid().equals(uuid)) {
        return i;
      }
    }
    return -1;
  }
}
