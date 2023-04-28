package com.lottery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lottery.service.WinnerService;

@RestController
@RequestMapping("/lottery")
public class LotteryController {

    @Autowired
    private WinnerService winnerService;

    @PostMapping("/checkNumber/{num}")
    public ResponseEntity<Boolean> checkNumber(@PathVariable("num") int num) throws Exception {
        boolean res=winnerService.checkNumber(num);
        return new ResponseEntity<Boolean>(res,HttpStatus.OK);
    }
    
}
