import java.io.IOException;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
            return null;
        }

        void delete (String uuid) {
            for (int i = 0; i < size; i++) {
                if ((storage[i].uuid).equals(uuid)) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                }
            }
        }

        /**
         * @return array, contains only Resumes in storage (without null)
         */
        Resume[] getAll () {
            Resume[] tempStorage = new Resume[size];
            for (int i = 0; i < tempStorage.length; i++) {
                tempStorage[i] = storage[i];
            }
            return tempStorage;
        }

        int size () {
            return size;
        }
    }
