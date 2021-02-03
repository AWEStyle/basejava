package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private Storage storage;

    private static final String UUID_1 = "uuid0";
    private static final String UUID_2 = "uuid1";
    private static final String UUID_3 = "uuid2";
    private static final String UUID_4 = "uuid4";
    private static final String UUID_5 = "resume";
    private static final int sizemass = 10000;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void clear() throws Exception {
        Assert.assertEquals(3, storage.size());
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        Resume r = new Resume(UUID_2);
        storage.update(r);
        Assert.assertEquals(r, storage.get(UUID_2));
    }

    @Test
    public void save() throws Exception {
        Resume r = new Resume(UUID_4);
        Assert.assertEquals(3, storage.size());
        storage.save(r);
        Assert.assertEquals(4, storage.size());
        Assert.assertEquals(r, storage.get(UUID_4));
    }

    @Test
    public void get() throws Exception {
        Resume r = new Resume(UUID_3);
        storage.get(UUID_3);
        Assert.assertEquals(r, storage.get(UUID_3));
    }

    @Test
    public void delete() throws Exception {
        Assert.assertEquals(3, storage.size());
        storage.delete(UUID_2);
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void getAll() throws Exception {
        storage.getAll();
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test(expected = StorageException.class)
    public void overFull() throws Exception {
        // проверить наличие ошибок на переполнение
        for (int i = 3; i < sizemass; i++) {
            try {
                Resume r = new Resume(UUID_5 + i);
                storage.save(r);
            } catch (Exception e) {
                Assert.fail("Переполнение массива произошло раньше времени");
            }
        }
        Assert.assertEquals(10000, storage.size());
        Resume r = new Resume(UUID_4);
        storage.save(r);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateResumeNotExist() throws Exception {
        Resume r = new Resume(UUID_4);
        storage.update(r);
    }

    @Test(expected = ExistStorageException.class)
    public void saveResumeExist() throws Exception {
        Resume r = new Resume(UUID_2);
        storage.save(r);
    }


    @Test(expected = NotExistStorageException.class)
    public void getResumeNotExist() throws Exception {
        storage.get(UUID_4);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteResumeNotExist() throws Exception {
        storage.delete(UUID_4);
    }
}