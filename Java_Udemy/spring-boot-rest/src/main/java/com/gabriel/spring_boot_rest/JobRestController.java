package com.gabriel.spring_boot_rest;

import com.gabriel.spring_boot_rest.model.JobPost;
import com.gabriel.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("/jobPosts")
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("/JobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) {
        return service.getJob(postId);
    }

    @PostMapping("/JobPost") //O ResponseEntity para retornar 'Feedback' Visual (201 Created) e confirmação dos dados
    public ResponseEntity<JobPost> addJob(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(jobPost);
    }

    @PutMapping("/JobPost/{postId}")
    public ResponseEntity<JobPost> changeJob(@PathVariable("postId") int postId, @RequestBody JobPost jobPost) {
        service.changeJob(jobPost, postId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(jobPost);

    }

    @DeleteMapping("/JobPost/{postId}")
    public void deleteJob(@PathVariable int postId) {
        service.deleteJob(postId);
    }

}













