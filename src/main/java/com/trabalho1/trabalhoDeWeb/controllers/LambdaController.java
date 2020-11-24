package com.trabalho1.trabalhoDeWeb.controllers;

import com.trabalho1.trabalhoDeWeb.service.LambdaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/lambda")
public class LambdaController {

    @Autowired
    private LambdaService lambdaService;

//    @GetMapping
//    @ResponseBody
//    public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id){
//        return new ResponseEntity(lambdaService.findPessoa(id), HttpStatus.OK);
//    }

//    @GetMapping
//    @ResponseBody
//    public ResponseEntity<?> buscarPorId(@RequestParam(name = "genero", required = false) String genero){
//        return new ResponseEntity(lambdaService.findPessoa(genero), HttpStatus.OK);
//    }

}
