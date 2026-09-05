package controller;

import exception.FuncionarioException;
import jakarta.validation.Valid;
import model.FuncionarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.FuncionarioService;

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
