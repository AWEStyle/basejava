package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractStorage implements Storage {
    protected static final int STORAGE_SIZE = 10000;
    protected Resume[] storage = new Resume[STORAGE_SIZE];
    protected int size = 0;


    public void update(Resume r) {
        Object searchKey = checkResume(r.getUuid());
        if (searchKey==null) {
            throw new NotExistStorageException(r.getUuid());
        }
        //updateResume(r);
    }

    public void save(Resume r) {
        Object searchKey = checkResume(r.getUuid());
        if (isExist(searchKey)) {
            throw new ExistStorageException(r.getUuid());
        }
        resumeSave(r, searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = checkResume(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return getResume(searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = checkResume(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        deleteResume(searchKey);
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    protected abstract void updateResume(Object searchKey, Resume r);
    protected abstract Object checkResume(String uuid);
    protected abstract void resumeSave(Resume r, Object searchKey);
    protected abstract boolean isExist(Object searchKey);
    protected abstract Resume getResume(Object searchKey);
    protected abstract void deleteResume(Object searchKey);
}
