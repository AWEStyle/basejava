package com.urise.webapp.model;

import com.urise.webapp.util.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Organization implements Serializable {
    private Link link;
    private List<Item> items;

    public Link getLink() {
        return link;
    }

    public Organization() {
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "link=" + link +
                ", items=" + items +
                '}';
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Item extends Organization {
        @XmlJavaTypeAdapter(LocalDateAdapter.class)
        public LocalDate dateStart;
        @XmlJavaTypeAdapter(LocalDateAdapter.class)
        public LocalDate dateEnd;
        public String position;
        public String description;

        public Item() {
        }

        public Item(LocalDate dateStart, LocalDate dateEnd, String position, String description) {
            this.dateStart = dateStart;
            this.dateEnd = dateEnd;
            this.position = position;
            this.description = description;
        }

        public LocalDate getDateStart() {
            return dateStart;
        }

        public void setDateStart(LocalDate dateStart) {
            this.dateStart = dateStart;
        }

        public LocalDate getDateEnd() {
            return dateEnd;
        }

        public void setDateEnd(LocalDate dateEnd) {
            this.dateEnd = dateEnd;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "\nItem{" +
                    "dateStart=" + dateStart +
                    ", dateEnd=" + dateEnd +
                    ", position='" + position + '\'' +
                    ", description='" + description + '\'' +
                    "}";
        }
    }
}


