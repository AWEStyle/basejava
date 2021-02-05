package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

import static java.lang.System.arraycopy;

public class SortedArrayStoragge extends AbstractArrayStorage {


    @Override
    protected Integer checkResume(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void resumeArraySave(Resume r, Integer a) {
        //вставить в элемент позицию а -1, потому что бинарный поиск возвращает позицию index -1
        // Сдвигаем вправо часть массива с позиции а-1,чтобы освободить место для нового элемента
        arraycopy(storage, a - 1, storage, a, size - (a - 1));
        // for (int i = size-1; i >= a - 1; i--) {
        //    storage[i+1] = storage[i];
        //}
        storage[a - 1] = r;
    }
}
