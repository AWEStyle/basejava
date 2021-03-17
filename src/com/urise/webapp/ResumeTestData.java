package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.LocalDate;
import java.util.Arrays;

public class ResumeTestData {
    public static void main(String[] args) {
        System.out.println("----------------------------");

        System.out.println(SectionType.OBJECTIVE.getTitle());

        SectionText section2 = new SectionText();
        section2.setContent("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        System.out.println(section2.getContent());

        System.out.println(SectionType.PERSONAL.getTitle());


        SectionText section4 = new SectionText();
        section4.setContent("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры");
        System.out.println(section4.getContent());

        System.out.println(SectionType.ACHIEVEMENT.getTitle());

        SectionList list = new SectionList();
        list.setContent(Arrays.asList("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.", "\n" +
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk." + "\n" +
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера." + "\n" +
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга." + "\n" +
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django)." + "\n" +
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."));
        System.out.println(list.getContent());

        System.out.println(SectionType.QUALIFICATIONS.getTitle());

        SectionList list2 = new SectionList();
        list2.setContent(Arrays.asList("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2 " + "\n" +
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce " + "\n" +
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, " + "\n" +
                "MySQL, SQLite, MS SQL, HSQLDB " + "\n" +
                "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy, " + "\n" +
                "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts" + "\n" +
                "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements). " + "\n" +
                "Python: Django. " + "\n" +
                "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js " + "\n" +
                "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka " + "\n" +
                "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT. " + "\n" +
                "Инструменты: Maven + plugin development, Gradle, настройка Ngnix, " + "\n" +
                "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer. " + "\n" +
                "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования " + "\n" +
                "Родной русский, английский \"upper intermediate\""));
        System.out.println(list2.getContent());

        System.out.println(SectionType.EXPERIENCE.getTitle());

        Organization org = new Organization();
        Link link = new Link("Java Online Projects", "https://javaops.ru/");
        Organization.Item item = new Organization.Item(LocalDate.parse("2013-10-01"), LocalDate.parse("2021-02-25"), "Автор проекта", "Создание, организации и проведения Java онлайн проектов и стажировок");
        org.setItems(Arrays.asList(item));
        org.setLink(link);
        System.out.println(org);

        Organization org2 = new Organization();
        Link link2 = new Link("Wrike", "https://www.wrike.com/");
        Organization.Item item2 = new Organization.Item(LocalDate.parse("2014-10-01"), LocalDate.parse("2016-01-01"), "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        org2.setItems(Arrays.asList(item2));
        org2.setLink(link2);
        System.out.println(org2);

        Organization org3 = new Organization();
        Link link3 = new Link("RIT Center", "");
        Organization.Item item3 = new Organization.Item(LocalDate.parse("2012-04-01"), LocalDate.parse("2014-10-01"), "Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python");
        org3.setItems(Arrays.asList(item3));
        org3.setLink(link3);
        System.out.println(org3);

        Organization org4 = new Organization();
        Link link4 = new Link("Luxoft(Deutsche Bank)", "https://career.luxoft.com/locations/russia/");
        Organization.Item item4 = new Organization.Item(LocalDate.parse("2010-12-01"), LocalDate.parse("2012-04-01"), "Ведущий прорграммист", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.");
        org4.setItems(Arrays.asList(item4));
        org4.setLink(link4);
        System.out.println(org4);

        Organization org5 = new Organization();
        Link link5 = new Link("Yota", "https://www.yota.ru/");
        Organization.Item item5 = new Organization.Item(LocalDate.parse("2008-06-01"), LocalDate.parse("2010-12-01"), "Ведущий специалист", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)");
        org5.setItems(Arrays.asList(item5));
        org5.setLink(link5);
        System.out.println(org5);

        Organization org6 = new Organization();
        Link link6 = new Link("Enkata", "https://www.pega.com/products/platform/robotic-process-automation");
        Organization.Item item6 = new Organization.Item(LocalDate.parse("2007-03-01"), LocalDate.parse("2008-06-01"), "Разработчик ПО", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).");
        org6.setItems(Arrays.asList(item6));
        org6.setLink(link6);
        System.out.println(org6);

        Organization org7 = new Organization();
        Link link7 = new Link("Siemens AG", "https://new.siemens.com/ru/ru.html");
        Organization.Item item7 = new Organization.Item(LocalDate.parse("2005-01-01"), LocalDate.parse("2007-02-01"), "Разработчик ПО", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).");
        org7.setItems(Arrays.asList(item7));
        org7.setLink(link7);
        System.out.println(org7);

        Organization org8 = new Organization();
        Link link8 = new Link("Alcatel", "www.alcatel.ru");
        Organization.Item item8 = new Organization.Item(LocalDate.parse("1997-09-01"), LocalDate.parse("2006-01-01"), "Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)");
        org8.setItems(Arrays.asList(item8));
        org8.setLink(link8);
        System.out.println(org8);

        System.out.println(SectionType.EDUCATION.getTitle());

        Organization org9 = new Organization();
        Link link9 = new Link("Coursera", "https://www.coursera.org/learn/progfun1");
        Organization.Item item9 = new Organization.Item(LocalDate.parse("2013-03-01"), LocalDate.parse("2013-05-01"), " \"Functional Programming Principles in Scala\" by Martin Odersky", "");
        org9.setItems(Arrays.asList(item9));
        org9.setLink(link9);
        System.out.println(org9);

        Organization org10 = new Organization();
        Link link10 = new Link("Luxoft", "https://www.luxoft-training.ru/kurs/obektno-orientirovannyy_analiz_i_proektirovanie_na_uml.html");
        Organization.Item item10 = new Organization.Item(LocalDate.parse("2011-03-01"), LocalDate.parse("2011-04-01"), "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", "");
        org10.setItems(Arrays.asList(item10));
        org10.setLink(link10);
        System.out.println(org10);

        Organization org11 = new Organization();
        Link link11 = new Link("Siemens AG", "https://new.siemens.com/ru/ru.html");
        Organization.Item item11 = new Organization.Item(LocalDate.parse("2005-01-01"), LocalDate.parse("2005-04-01"), "3 месяца обучения мобильным IN сетям (Берлин)", "");
        org11.setItems(Arrays.asList(item11));
        org11.setLink(link11);
        System.out.println(org11);

        Organization org12 = new Organization();
        Link link12 = new Link("Alcatel", "www.alcatel.ru");
        Organization.Item item12 = new Organization.Item(LocalDate.parse("1997-09-01"), LocalDate.parse("1998-03-01"), "\" 6 месяцев обучения цифровым телефонным сетям (Москва)", "");
        org12.setItems(Arrays.asList(item12));
        org12.setLink(link12);
        System.out.println(org12);

        Organization org13 = new Organization();
        Link link13 = new Link("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "https://itmo.ru/ru/");
        Organization.Item item13 = new Organization.Item(LocalDate.parse("1993-09-01"), LocalDate.parse("1996-07-01"), "Аспирантура (программист С, С++)", "");
        Organization.Item item14 = new Organization.Item(LocalDate.parse("1987-09-01"), LocalDate.parse("1993-07-01"), "Инженер (программист Fortran, C)", "");
        org13.setItems(Arrays.asList(item13, item14));
        org13.setLink(link13);
        System.out.println(org13);

        Organization org14 = new Organization();
        Link link14 = new Link("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/");
        Organization.Item item15 = new Organization.Item(LocalDate.parse("1984-09-01"), LocalDate.parse("1987-06-01"), "Закончил с отличием", "");
        org14.setItems(Arrays.asList(item15));
        org14.setLink(link14);
        System.out.println(org14);
    }
}
