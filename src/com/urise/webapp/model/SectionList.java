package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class SectionList extends AbstractSection {
    List<String> content = new ArrayList<>();

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }
}
