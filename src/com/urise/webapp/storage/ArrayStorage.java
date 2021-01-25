package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int STORAGE_SIZE = 10;
    private Resume[] storage = new Resume[STORAGE_SIZE];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }


    private int checkResume(String uuid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid() == uuid) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void update(Resume r) {
        int a = checkResume(r.getUuid());
        if (a == -1) {
            System.out.println("Резюме с таким именем не существует");
            return;
        }
        storage[a] = r;
    }

    public void save(Resume r) {
        int a = checkResume(r.getUuid());
        if (size >= STORAGE_SIZE) {
            System.out.println("Массив заполнен!");
            return;
        }
        if (a > -1) {
            System.out.println("Резюме с таким именем уже существует");
            return;
        }
        storage[size] = r;
        size++;

    }

    public Resume get(String uuid) {
        int a = checkResume(uuid);
        if (a == -1) {
            System.out.println("Резюме с таким именем не существует");
            return null;
        }
        return storage[a];
    }

    public void delete(String uuid) {
        int a = checkResume(uuid);
        if (a == -1) {
            System.out.println("Резюме с таким именем не существует");
            return;
        }
        for (int i = a; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        storage[size - 1] = null;
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }
}
