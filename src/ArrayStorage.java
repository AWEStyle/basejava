import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10];
    int size = 0;

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
