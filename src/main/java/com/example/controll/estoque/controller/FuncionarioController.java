package com.example.controll.estoque.controller;

import jakarta.validation.Valid;
import com.example.controll.estoque.model.FuncionarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.controll.estoque.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {


    @Autowired
    FuncionarioService funcionarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<FuncionarioModel> cadastrarFuncionario(@RequestBody @Valid FuncionarioModel funcionarioModel) {

        FuncionarioModel salvo = funcionarioService.cadastrar(funcionarioModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}
