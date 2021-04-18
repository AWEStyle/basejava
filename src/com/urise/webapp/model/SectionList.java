package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class SectionList extends AbstractSection {
    private static final long serialVersionUID =1L;

    List<String> content = new ArrayList<>();

    public SectionList() {
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }
}
