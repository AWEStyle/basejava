package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_SIZE = 10000;
    protected Resume[] storage = new Resume[STORAGE_SIZE];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public void update(Resume r) {
        int a = checkResume(r.getUuid());
        if (a<0) {
            throw new NotExistStorageException(r.getUuid());
        }
        storage[a] = r;
    }

    public void save(Resume r) {
        if (size >= STORAGE_SIZE) {
            throw new StorageException("Массив переполнен",r.getUuid());
        }
        int a = checkResume(r.getUuid());
        if (a>=0) {
            throw new ExistStorageException(r.getUuid());
        }
        resumeSave(r,-a);
        size++;
    }

    public Resume get(String uuid) {
        int a = checkResume(uuid);
        if (a<0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[a];
    }

    public void delete(String uuid) {
        int a = checkResume(uuid);
        if (a<0) {
            throw new NotExistStorageException(uuid);
        }
        for (int i = a; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        storage[size - 1] = null;
        size--;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    protected abstract int checkResume(String uuid);
    protected abstract void resumeSave(Resume r, int a);
}
