package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage{
    List<Resume> storage = new ArrayList<>();

    @Override
    protected void doUpdate(Object searchKey, Resume r) {
        storage.set(storage.indexOf(searchKey), r);
    }

    @Override
    protected Object getSearchKey(String uuid) {
        for(Resume r : storage){
            if(r.getUuid().equals(uuid)){
                return r;
            }
        }
        return null;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        storage.add(r);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return storage.contains(searchKey);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return (Resume) searchKey;
    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove((Resume) searchKey);
    }

    @Override
    protected List<Resume> getAllResume() {
        return storage;
    }

    @Override
    public void clear() {
        storage.clear();
    }


    @Override
    public int size() {
        return storage.size();
    }
}
