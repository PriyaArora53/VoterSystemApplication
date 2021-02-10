package com.learning.votingsystem.controller;

import com.learning.votingsystem.entity.Candidates;
import com.learning.votingsystem.entity.Citizen;
import com.learning.votingsystem.repositories.CandidateRepo;
import com.learning.votingsystem.repositories.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class VotingController {

    @Autowired
    CitizenRepo citizenRepo;

    @Autowired
    CandidateRepo candidateRepo;

    @RequestMapping("/")
    public String goToVote(){
//takes the user to default page
        return "vote.html";
    }

    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam String name, Model model){
    //checks if the name has voted
      Citizen citizen =  citizenRepo.findByName(name);
      if(!citizen.getHasVoted()){
          List<Candidates> candidates = candidateRepo.findAll();
          model.addAllAttributes(candidates);
          return "/performVote.html";
      }else{
          return "/alreadyVoted.html";
      }
    }
}
