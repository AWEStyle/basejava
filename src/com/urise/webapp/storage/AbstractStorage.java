package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


public abstract class AbstractStorage implements Storage {

    public void update(Resume r) {
        Object searchKey = getSearchKey(r.getUuid());
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(r.getUuid());
        }
        doUpdate(searchKey,r);
    }

    public void save(Resume r) {
        Object searchKey = getSearchKey(r.getUuid());
        if (isExist(searchKey)) {
            throw new ExistStorageException(r.getUuid());
        }
        doSave(r, searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return doGet(searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        doDelete(searchKey);
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = getAllResume();
        Collections.sort(list);
        return list;
    }



    protected abstract void doUpdate(Object searchKey, Resume r);
    protected abstract Object getSearchKey(String uuid);
    protected abstract void doSave(Resume r, Object searchKey);
    protected abstract boolean isExist(Object searchKey);
    protected abstract Resume doGet(Object searchKey);
    protected abstract void doDelete(Object searchKey);
    protected abstract List<Resume> getAllResume();
}
