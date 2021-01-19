import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10];
    int size = 0;
    int index=0;
    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {

        return null;
    }

    void delete(String uuid) {
        index = Integer.parseInt(uuid);
        for (int i = index; i < size; i++) {
            storage[i] = storage[i + 1];
        }
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return storage;

    }

    int size() {
        return size;
    }
}
