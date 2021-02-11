package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static com.urise.webapp.storage.AbstractArrayStorage.STORAGE_SIZE;
import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void overFull() throws Exception {
        for (int i = 3; i < STORAGE_SIZE; i++) {
            try {
                Resume r = new Resume(UUID_5 + i);
                storage.save(r);
            } catch (Exception e) {
                Assert.fail("Переполнение массива произошло раньше времени");
            }
        }
        Assert.assertEquals(STORAGE_SIZE, storage.size());
        Resume r = new Resume(UUID_4);
        storage.save(r);
    }


}