package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_SIZE = 10000;
    protected Resume[] storage = new Resume[STORAGE_SIZE];
    protected int size = 0;


    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    @Override
    public void doUpdate(Integer searchKey, Resume r) {
        storage[(Integer) searchKey] = r;
    }

    protected boolean isExist(Integer searchKey) {

        return searchKey > -1;
    }

    public void doSave(Resume r, Integer searchKey) {
        if (size >= STORAGE_SIZE) {
            throw new StorageException("Массив переполнен", r.getUuid());
        }
        resumeArraySave(r, -(Integer) searchKey);
        size++;
    }

    @Override
    public Resume doGet(Integer searchKey) {
        return storage[searchKey];
    }

    public void doDelete(Integer searchKey) {
        for (int i = searchKey; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        storage[size - 1] = null;
        size--;
    }

    public List<Resume> getAllResume() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
    }

    public int size() {
        return size;
    }


    protected abstract Integer getSearchKey(String uuid);

    protected abstract void resumeArraySave(Resume r, Integer searchKey);

}
