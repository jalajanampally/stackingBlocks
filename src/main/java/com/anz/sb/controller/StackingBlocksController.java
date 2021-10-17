package com.anz.sb.controller;

import com.anz.sb.model.SbRequest;
import com.anz.sb.model.SbResponse;
import com.anz.sb.service.StackingBlocksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "v1/anz", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class StackingBlocksController {

    private final StackingBlocksService stackingBlocksService;

    @PostMapping("/stackingBlocks")
    public ResponseEntity<SbResponse> performStackingBlocks(@Valid @RequestBody SbRequest sbRequest, HttpServletRequest httpRequest) {
        log.debug("Inside performStackingBlocks controller method");
        return new ResponseEntity<>(stackingBlocksService.findMaximumHeight(sbRequest), HttpStatus.OK);
    }
}
