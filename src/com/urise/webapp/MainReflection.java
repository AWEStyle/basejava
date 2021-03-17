package com.urise.webapp;

import com.urise.webapp.model.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume("Name");
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        // invoke r.toString via reflection
        System.out.println(r);
        Method method = r.getClass().getMethod("toString");
        System.out.println(method.invoke(r));

        SectionText section = new SectionText();
        section.setContent("Какой-то текст");
        System.out.println(section.getContent());

        SectionList list = new SectionList();
        list.setContent(Arrays.asList("Text", "text2","text3"));
        System.out.println(list.getContent());
        Organization org = new Organization();
        Organization.Item item = new Organization.Item(LocalDate.parse("2013-01-01"), LocalDate.parse("2015-05-05"), "директор", "работал 24/7");
        Organization.Item item1 = new Organization.Item(LocalDate.parse("2013-01-05"), LocalDate.parse("2015-05-09"), "директор", "работал 24/7");
        Link link = new Link("ООП", "http://oop.com");
        org.setItems(Arrays.asList(item,item1));
        org.setLink(link);
        System.out.println(org);
    }
}
