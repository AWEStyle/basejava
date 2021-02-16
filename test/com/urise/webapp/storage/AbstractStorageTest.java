package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractStorageTest {
    protected Storage storage;

    protected static final String UUID_1 = "uuid0";
    protected static final String UUID_2 = "uuid1";
    protected static final String UUID_3 = "uuid2";
    protected static final String UUID_4 = "uuid4";
    protected static final String UUID_5 = "resume";
    protected static final String FULL_NAME_1 = "resume_1";
    protected static final String FULL_NAME_2 = "resume_2";
    protected static final String FULL_NAME_3 = "resume_2";
    protected static final String FULL_NAME_4 = "resume_4";
    protected static final Resume RESUME_1 = new Resume(UUID_1, FULL_NAME_1);
    protected static final Resume RESUME_2 = new Resume(UUID_2, FULL_NAME_2);
    protected static final Resume RESUME_3 = new Resume(UUID_3, FULL_NAME_3);
    protected static final Resume RESUME_4 = new Resume(UUID_4, FULL_NAME_4);


    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void clear() throws Exception {
        Assert.assertEquals(3, storage.size());
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        Resume r = new Resume(UUID_2,FULL_NAME_4);
        storage.update(r);
        Assert.assertEquals(r, storage.get(UUID_2));
    }

    @Test
    public void save() throws Exception {
        Assert.assertEquals(3, storage.size());
        storage.save(RESUME_4);
        Assert.assertEquals(4, storage.size());
        Assert.assertEquals(RESUME_4, storage.get(UUID_4));
    }

    @Test
    public void get() throws Exception {
        storage.get(UUID_3);
        Assert.assertEquals(RESUME_3, storage.get(UUID_3));
    }

    @Test
    public void delete() throws Exception {
        Assert.assertEquals(3, storage.size());
        storage.delete(UUID_2);
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void getAll() throws Exception {
        List<Resume> list = storage.getAllSorted();
        List<Resume> testList = Arrays.asList(RESUME_1, RESUME_2, RESUME_3);
        Assert.assertEquals(testList, list);
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }


    @Test(expected = NotExistStorageException.class)
    public void updateResumeNotExist() throws Exception {
        Resume r = new Resume(UUID_4);
        storage.update(r);
    }

    @Test(expected = ExistStorageException.class)
    public void saveResumeExist() throws Exception {
        storage.save(RESUME_2);
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