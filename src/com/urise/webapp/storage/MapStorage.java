package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage<String> {
    private Map<String, Resume> storage = new HashMap<>();


    @Override
    protected void doUpdate(String uuid, Resume r) {
        storage.replace(r.getUuid(), r);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doSave(Resume r, String uuid) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected boolean isExist(String uuid) {
        return storage.containsKey(uuid);
    }

    @Override
    protected Resume doGet(String uuid) {
        return storage.get((uuid));
    }

    @Override
    protected void doDelete(String uuid) {
        storage.remove((uuid));
    }

    @Override
    protected List<Resume> getAllResume() {
        return new ArrayList<>(storage.values());
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
