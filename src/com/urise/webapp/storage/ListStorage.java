package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage{
    List<Resume> storage = new ArrayList<>();

    @Override
    protected void updateResume(Object searchKey, Resume r) {
        storage.indexOf(r);
    }

    @Override
    protected Object checkResume(String uuid) {
        for(Resume r : storage){
            if(r.getUuid().equals(uuid)){
                return r;
            }
        }
        return null;
    }

    @Override
    protected void resumeSave(Resume r, Object searchKey) {
        storage.add(r);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return storage.contains((Resume)searchKey);
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return (Resume) searchKey;
    }

    @Override
    protected void deleteResume(Object searchKey) {
        storage.remove((Resume) searchKey);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
