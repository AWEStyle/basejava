package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    private List<Resume> storage = new ArrayList<>();

    @Override
    protected void doUpdate(Integer searchKey, Resume r) {
        storage.set(searchKey, r);
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected void doSave(Resume r, Integer searchKey) {
        storage.add(r);
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey != null;
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return storage.get(searchKey);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        storage.remove(searchKey.intValue());
    }

    @Override
    protected List<Resume> getAllResume() {
        return new ArrayList<>(storage);
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
