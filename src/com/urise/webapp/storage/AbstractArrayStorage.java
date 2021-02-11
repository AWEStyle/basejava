package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_SIZE = 10000;
    protected Resume[] storage = new Resume[STORAGE_SIZE];
    protected int size = 0;


    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    @Override
    public void updateResume(Object searchKey, Resume r) {
        storage[(Integer) searchKey] = r;
    }

    protected boolean isExist(Object searchKey) {

        return (Integer) searchKey > -1;
    }

    public void resumeSave(Resume r, Object searchKey) {
        if (size >= STORAGE_SIZE) {
            throw new StorageException("Массив переполнен", r.getUuid());
        }
        resumeArraySave(r, -(Integer) searchKey);
        size++;
    }

    @Override
    public Resume getResume(Object searchKey) {
        return storage[(Integer) searchKey];
    }

    public void deleteResume(Object searchKey) {
        for (int i = (Integer)searchKey; i < size - 1; i++) {
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


    protected abstract Integer checkResume(String uuid);

    protected abstract void resumeArraySave(Resume r, Integer searchKey);

}
