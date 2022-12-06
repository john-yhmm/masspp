package com.john.masspp.hymn;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "hymn_detail")
public class HymnDetail implements Serializable {
    private static final long serialVersionUID = -8401070207420119926L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "serial_no")
    private Long serialNo;
    @Column(name = "is_chorus")
    private Boolean isChorus;
    @Column(name = "text_data")
    private String textData;

    @ManyToOne
    @JoinColumn(name = "hymn_id")
    private Hymn hymn;

    public void setAllFields(HymnDetailDTO hymnDetailDTO) {
        this.serialNo = hymnDetailDTO.getSerialNo();
        this.isChorus = hymnDetailDTO.getIsChorus();
        this.textData = hymnDetailDTO.getTextData();
    }
}
