package com.john.masspp.hymn;

import com.john.masspp.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/api/auth/hymn")
public class HymnController {

    @Autowired
    HymnService hymnService;

    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody HymnDTO hymnDTO, Errors errors) throws CustomException {
        log.debug("Start register hymn .....");
        if (errors.hasErrors()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        hymnService.register(hymnDTO);
        log.debug("End register hymn .....");
        return new ResponseEntity<>("Hymn Registered.", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody HymnDTO hymnDTO, Errors errors) throws CustomException {
        log.debug("Start update hymn .....");
        if (errors.hasErrors()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        hymnService.update(hymnDTO);
        log.debug("End update hymn .....");
        return new ResponseEntity<>("Hymn Updated.", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllHymn(@PageableDefault Pageable pageable) {
        log.debug("Start get all hymn .....");
        HymnPageDTO hymnPageDTO = hymnService.getAllHymn(pageable);
        log.debug("End get all hymn .....");
        return new ResponseEntity<>(hymnPageDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getHymnById(@PathVariable Long id) throws CustomException {
        log.debug("Start get hymn by id .....");
        HymnDTO hymnDTO = hymnService.getHymnById(id);
        log.debug("End get hymn by id .....");
        return new ResponseEntity<>(hymnDTO, HttpStatus.OK);
    }

}
