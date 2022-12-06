package com.john.masspp.hymn;

import com.john.masspp.common.MessageConst;
import com.john.masspp.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class HymnService {

    @Autowired
    HymnRepository hymnRepository;
    @Autowired
    HymnDetailRepository hymnDetailRepository;

    @Transactional(rollbackFor = Exception.class)
    public void register(HymnDTO hymnDTO) throws CustomException {
        Hymn hymn = new Hymn();
        hymn.setAllFields(hymnDTO);
        prepareHymnDetailList(hymn, hymnDTO);

        hymnRepository.save(hymn);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(HymnDTO hymnDTO) throws CustomException {
        Long id = hymnDTO.getId();
        if (Objects.isNull(id)) throw new CustomException(MessageConst.ID_REQUIRED);

        Hymn hymn = checkValidHymn(id);
        hymn.setAllFields(hymnDTO);
        prepareHymnDetailList(hymn, hymnDTO);

        hymnRepository.save(hymn);
    }

    private void prepareHymnDetailList(Hymn hymn, HymnDTO hymnDTO) throws CustomException {
        List<HymnDetailDTO> detailDTOList = hymnDTO.getHymnDetailDTOList();
        if (!CollectionUtils.isEmpty(detailDTOList)) {
            for (HymnDetailDTO detailDTO : detailDTOList) {
                HymnDetail detail = prepareHymnDetail(detailDTO);
                detail.setHymn(hymn);
                hymn.getHymnDetailList().add(detail);
            }
        }
    }

    private HymnDetail prepareHymnDetail(HymnDetailDTO detailDTO) throws CustomException {
        HymnDetail detail;

        if (Objects.isNull(detailDTO.getId())) detail = new HymnDetail();
        else detail = checkValidHymnDetail(detailDTO.getId());

        detail.setAllFields(detailDTO);
        return detail;
    }

    public HymnPageDTO getAllHymn(Pageable pageable) {
        Page<Hymn> page = hymnRepository.findAll(pageable);
        List<Hymn> hymnList = page.getContent();
        List<HymnDTO> hymnDTOList = prepareHymnDTOList(hymnList);

        HymnPageDTO hymnPageDTO = new HymnPageDTO();
        hymnPageDTO.setHymnList(hymnDTOList);
        hymnPageDTO.setPaginationData(page);

        return hymnPageDTO;
    }

    private List<HymnDTO> prepareHymnDTOList(List<Hymn> hymnList) {
        List<HymnDTO> hymnDTOList = new ArrayList<>();
        for (Hymn hymn : hymnList) {
            HymnDTO hymnDTO = prepareHymnDTO(hymn);
            hymnDTOList.add(hymnDTO);
        }
        return hymnDTOList;
    }

    private HymnDTO prepareHymnDTO(Hymn hymn) {
        List<HymnDetail> detailList = hymn.getHymnDetailList();
        List<HymnDetailDTO> detailDTOList = prepareHymnDetailDTOList(detailList);

        HymnDTO hymnDTO = new HymnDTO(hymn);
        hymnDTO.setHymnDetailDTOList(detailDTOList);

        return hymnDTO;
    }

    private List<HymnDetailDTO> prepareHymnDetailDTOList(List<HymnDetail> detailList) {
        List<HymnDetailDTO> detailDTOList = new ArrayList<>();
        for (HymnDetail detail : detailList) {
            HymnDetailDTO detailDTO = new HymnDetailDTO(detail);
            detailDTOList.add(detailDTO);
        }
        return detailDTOList;
    }

    public HymnDTO getHymnById(Long id) throws CustomException {
        Hymn hymn = checkValidHymn(id);
        return prepareHymnDTO(hymn);
    }

    private Hymn checkValidHymn(Long id) throws CustomException {
        return hymnRepository.findById(id).orElseThrow(() -> new CustomException(MessageConst.INVALID_ID));
    }

    private HymnDetail checkValidHymnDetail(Long id) throws CustomException {
        return hymnDetailRepository.findById(id).orElseThrow(() -> new CustomException(MessageConst.INVALID_ID));
    }
}
