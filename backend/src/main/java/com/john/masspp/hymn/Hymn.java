package com.john.masspp.hymn;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "hymn")
public class Hymn implements Serializable {
    private static final long serialVersionUID = 5371538493873396093L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "serial_no")
    private Long serialNo;
    @Column(name = "page_no")
    private Long pageNo;
    @Column(name = "name")
    private String name;
    @Column(name = "category_id")
    private Long categoryId;
    @Column(name = "book_id")
    private Long bookId;

    @OneToMany(mappedBy = "hymn", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HymnDetail> hymnDetailList = new ArrayList<>();

    public void setAllFields(HymnDTO hymnDTO) {
        this.serialNo = hymnDTO.getSerialNo();
        this.pageNo = hymnDTO.getPageNo();
        this.name = hymnDTO.getName();
        this.categoryId = hymnDTO.getCategoryId();
        this.bookId = hymnDTO.getBookId();
    }
}
