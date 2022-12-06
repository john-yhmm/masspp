package com.john.masspp.hymn;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(Include.NON_NULL)
public class HymnDTO implements Serializable {

    private static final long serialVersionUID = -4680595941761839584L;

    private Long id;
    private Long serialNo;
    private Long pageNo;

    @NotBlank(message = "Hymn name is required.")
    private String name;

    private Long categoryId;
    private Long bookId;

    private List<HymnDetailDTO> hymnDetailDTOList = new ArrayList<>();

    public HymnDTO() {

    }

    public HymnDTO(Hymn entity) {
        this.id = entity.getId();
        this.serialNo = entity.getSerialNo();
        this.pageNo = entity.getPageNo();
        this.name = entity.getName();
        this.categoryId = entity.getCategoryId();
        this.bookId = entity.getBookId();
    }
}
