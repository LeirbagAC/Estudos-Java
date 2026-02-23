package com.gabriel.spring_boot_rest.service;

import com.gabriel.spring_boot_rest.model.JobPost;
import com.gabriel.spring_boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost) {
        repo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.getAllJobs();
    }

    public JobPost getJob(int num) {
        return repo.getJob(num);
    }

    public void changeJob(JobPost jobPost, int postId) {
        repo.changeJob(jobPost, postId);
    }

    public void deleteJob(int postId) {
        repo.deleteJob(postId);
    }
}
