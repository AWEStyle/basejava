package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;


public abstract class AbstractStorage<SK> implements Storage {
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    public void update(Resume r) {
        LOG.info("Update" + r);
        SK searchKey = getSearchKey(r.getUuid());
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(r.getUuid());
        }
        doUpdate(searchKey,r);
    }

    public void save(Resume r) {
        LOG.info("Save" + r);
        SK searchKey = getSearchKey(r.getUuid());
        if (isExist(searchKey)) {
            throw new ExistStorageException(r.getUuid());
        }
        doSave(r, searchKey);
    }

    public Resume get(String uuid) {
        LOG.info("Get" + uuid);
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return doGet(searchKey);
    }

    public void delete(String uuid) {
        LOG.info("Delete" + uuid);
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        doDelete(searchKey);
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
        List<Resume> list = getAllResume();
        Collections.sort(list);
        return list;
    }



    protected abstract void doUpdate(SK searchKey, Resume r);
    protected abstract SK getSearchKey(String uuid);
    protected abstract void doSave(Resume r, SK searchKey);
    protected abstract boolean isExist(SK searchKey);
    protected abstract Resume doGet(SK searchKey);
    protected abstract void doDelete(SK searchKey);
    protected abstract List<Resume> getAllResume();
}
