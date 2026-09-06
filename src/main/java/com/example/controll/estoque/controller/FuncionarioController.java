package com.example.controll.estoque.controller;

import com.example.controll.estoque.exception.FuncionarioException;
import com.example.controll.estoque.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import com.example.controll.estoque.model.FuncionarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.controll.estoque.service.FuncionarioService;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {


    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<FuncionarioModel> cadastrarFuncionario(@RequestBody @Valid FuncionarioModel funcionarioModel) {
        FuncionarioModel salvo = funcionarioService.cadastrar(funcionarioModel);


        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioModel>> buscarALlFuncionarios() {

        List<FuncionarioModel> todosFuncionarios = funcionarioService.buscarAll();

        return ResponseEntity.status(HttpStatus.OK).body(todosFuncionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioModel> findById(@PathVariable Long id) {

        return funcionarioRepository.findById(id).map(funcionarioModelId -> ResponseEntity.ok().body(funcionarioModelId)).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        funcionarioService.deleteById(id);

    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioModel> atualizar(@PathVariable Long id, @RequestBody FuncionarioModel funcionarioAtualizado) {

        return funcionarioRepository.findById(id).map(funcionarioModel -> {
            funcionarioModel.setNome(funcionarioAtualizado.getNome());
            funcionarioModel.setCargo(funcionarioAtualizado.getCargo());
            funcionarioModel.setSetor(funcionarioAtualizado.getSetor());
            funcionarioModel.setCpf(funcionarioAtualizado.getCpf());
            funcionarioModel.setEmail(funcionarioAtualizado.getEmail());
            funcionarioModel.setIdade(funcionarioAtualizado.getIdade());
            funcionarioModel.setSalario(funcionarioAtualizado.getSalario());

            FuncionarioModel funcionarioModelAtualizado = funcionarioRepository.save(funcionarioModel);

            return ResponseEntity.ok().body(funcionarioModelAtualizado);
        }).orElse(ResponseEntity.notFound().build());

    }
}
