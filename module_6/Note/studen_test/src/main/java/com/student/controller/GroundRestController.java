package com.student.controller;

import com.student.model.Ground;
import com.student.service.GroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*",allowedHeaders = "*")
public class GroundRestController {
    @Autowired
    GroundService groundService;

    @RequestMapping(value = "/ground", method = RequestMethod.GET)
    public ResponseEntity<List<Ground>> listAllBlog() {
        List<Ground> groundList = groundService.findAll();
        if (groundList.isEmpty()) {
            return new ResponseEntity<List<Ground>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Ground>>(groundList, HttpStatus.OK);
    }
    @RequestMapping(value = "/ground/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ground> getBlog(@PathVariable("id") Integer id) {
        System.out.println("Fetching Ground with id " + id);
        Ground ground = groundService.findById(id);
        if (ground == null) {
            System.out.println("Ground with id " + id + " not found");
            return new ResponseEntity<Ground>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Ground>(ground, HttpStatus.OK);
    }
}
