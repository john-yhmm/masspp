package com.john.masspp.hymn;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class HymnPageDTO implements Serializable {

    private static final long serialVersionUID = 3161128580707677253L;

    List<HymnDTO> hymnList = new ArrayList<>();
    boolean isFirstPage;
    boolean isLastPage;
    int currentPage;
    int maxPageSize;
    int numberOfElements;
    int totalPages;
    long totalElements;

    public void setPaginationData(Page<Hymn> page) {
        this.isFirstPage = page.isFirst();
        this.isLastPage = page.isLast();
        this.currentPage = page.getNumber();
        this.maxPageSize = page.getSize();
        this.numberOfElements = page.getNumberOfElements();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
    }
}
