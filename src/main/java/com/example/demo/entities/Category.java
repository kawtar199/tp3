package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    public Category(String title, String webTitle, Category parent, List<Category> subCategories, Integer leval) {
        this.title = title;
        this.webTitle = webTitle;
        this.parent = parent;
        this.subCategories = subCategories;
        this.leval = leval;
    }

    public Category() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "web_title", nullable = false, length = 200)
    private String webTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent")
    private Category parent;
    @OneToMany
    @JoinColumn(name = "parent")
    private List<Category> subCategories;
    @Column(name = "leval", nullable = false)
    private Integer leval;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public Integer getLeval() {
        return leval;
    }

    public void setLeval(Integer leval) {
        this.leval = leval;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    @Override
    public String toString() {
        return "Category{" +
                "subCategories=" + subCategories +
                '}';
    }
}