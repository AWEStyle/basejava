package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;


public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer checkResume(String uuid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid() == uuid) {
                index = i;
                break;
            }
        }
        return (Integer) index;
    }

    @Override
    protected void resumeArraySave(Resume r, Integer a) {
        storage[size] = r;
    }

    public int size() {
        return size;
    }
}
