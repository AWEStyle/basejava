package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;


public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected int checkResume(String uuid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid() == uuid) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    protected void resumeSave(Resume r, int a) {
        storage[size] = r;
    }



    public int size() {
        return size;
    }
}
