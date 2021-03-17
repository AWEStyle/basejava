package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.SortedArrayStoragge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * Interactive test for com.urise.webapp.storage.ArrayStorage implementation
 * (just run, no need to understand)
 */
public class MainArray {
    private final static SortedArrayStoragge storage = new SortedArrayStoragge();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Resume r;
        while (true) {
            System.out.print("Введите одну из команд - (list | save fullName | update uuid fullName | delete uuid | get uuid | clear | size | exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");
            if (params.length < 1 || params.length > 3) {
                System.out.println("Неверная команда.");
                continue;
            }
            String param = null;
            if (params.length == 3) {
                param = params[1].intern();
            }
            switch (params[0]) {
                case "list":
                    printAll();
                    break;
                case "size":
                    System.out.println(storage.size());
                    break;
                case "update":
                    r = new Resume(param, params[2]);
                    storage.update(r);
                    printAll();
                    break;
                case "save":
                    r = new Resume(param);
                    storage.save(r);
                    printAll();
                    break;
                case "delete":
                    storage.delete(param);
                    printAll();
                    break;
                case "get":
                    System.out.println(storage.get(param));
                    break;
                case "clear":
                    storage.clear();
                    printAll();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неверная команда.");
                    break;
            }
        }
    }

    static void printAll() {
        Resume[] all = storage.getAllSorted().toArray(new Resume[0]);
        System.out.println("----------------------------");
        if (all.length == 0) {
            System.out.println("Empty");
        } else {
            for (Resume r : all) {
                System.out.println(r);
            }
        }
        System.out.println("----------------------------");
    }
}