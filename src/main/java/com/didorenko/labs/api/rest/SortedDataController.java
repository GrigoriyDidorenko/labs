//package com.didorenko.labs.api.rest;
//
//import com.didorenko.labs.domain.Region;
//import com.didorenko.labs.dto.SortedListHolder;
//import com.didorenko.labs.service.SortedDataService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
///**
// * Created by g.didorenko on 03.03.2018.
// */
//
//@RestController
//public class SortedDataController {
//
//
//    @GetMapping(path = "parameters")
//    public ResponseEntity<List<String>> getSortingParameters() {
//        return new ResponseEntity<>(new SortedDataService<Region>
//                (new ArrayList<>(Collections.singletonList(new Region(10, 10, "central", 10))))
//                .getSortingFields(), HttpStatus.OK);
//    }
//
//    @GetMapping(path = "lists")
//    public ResponseEntity<List<SortedListHolder>> getSortedLists() {
//        return null;
//    }
//
//
//}
