package com.example.controll.estoque.service;

import com.example.controll.estoque.exception.FuncionarioException;
import com.example.controll.estoque.model.FuncionarioModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.controll.estoque.repository.FuncionarioRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FuncionarioService {


    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public FuncionarioModel cadastrar(FuncionarioModel funcionarioModel) {

        boolean exists = funcionarioRepository.existsFuncionarioModelByCpf(funcionarioModel.getCpf());

        if (exists) {
            throw new FuncionarioException("Funcionário já existente em nosso banco de dados!");
        }

        funcionarioModel = funcionarioRepository.save(funcionarioModel);

        return funcionarioModel;

    }

    public List<FuncionarioModel> buscarAll() {
        boolean isEmpity = funcionarioRepository.findAll().isEmpty();
        if (isEmpity) {
            throw new FuncionarioException("Não há registros para mostrar");
        }
        return funcionarioRepository.findAll();
    }

    public Optional<FuncionarioModel> buscarById(Long id) {
        Optional<FuncionarioModel> funcionarioModelId = funcionarioRepository.findById(id);

        return funcionarioModelId;

    }

    @Transactional
    public void deleteById(Long id) {
        if (!funcionarioRepository.existsById(id)){
            throw new FuncionarioException("Funcionário não existe");
        }

        funcionarioRepository.deleteById(id);
    }

    public Optional<FuncionarioModel> atualizar(Long id){
        Optional<FuncionarioModel> funcionarioModelId = funcionarioRepository.findById(id);

        return funcionarioModelId;
    }


}
