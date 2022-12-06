package com.john.masspp.hymn;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(Include.NON_NULL)
public class HymnDetailDTO implements Serializable {

    private static final long serialVersionUID = 2161951597023215189L;

    private Long id;
    private Long serialNo;
    private Boolean isChorus;
    private String textData;

    public HymnDetailDTO() {

    }

    public HymnDetailDTO(HymnDetail entity) {
        this.id = entity.getId();
        this.serialNo = entity.getSerialNo();
        this.isChorus = entity.getIsChorus();
        this.textData = entity.getTextData();
    }
}
