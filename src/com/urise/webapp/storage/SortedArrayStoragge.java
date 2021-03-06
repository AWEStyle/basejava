package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.System.arraycopy;

public class SortedArrayStoragge extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());


    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
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
