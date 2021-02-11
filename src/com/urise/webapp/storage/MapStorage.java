package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap<>();


    @Override
    protected void updateResume(Object searchKey, Resume r) {
        storage.replace(r.getUuid(), r);
    }

    @Override
    protected Object checkResume(String uuid) {
        for (Resume r : storage.values()) {
            if (r.getUuid().equals(uuid)) {
                return r;
            }
        }
        return null;
    }

    @Override
    protected void resumeSave(Resume r, Object searchKey) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return storage.containsValue((Resume) searchKey);
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return storage.get(((Resume) searchKey).getUuid());
    }

    @Override
    protected void deleteResume(Object searchKey) {
        storage.remove(((Resume) searchKey).getUuid());
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
