package com.urise.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayStoraggeTest.class,
        SortedArrayStoraggeTest.class,
        ListStorageTest.class,
        MapStorageTest.class,
        MapResumeStorageTest.class
})
public class AllStorageTests {

}
