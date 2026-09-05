package service;

import exception.FuncionarioException;
import model.FuncionarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FuncionarioRepository;

@Service
public class FuncionarioService {


    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioModel cadastrar(FuncionarioModel funcionarioModel){

        if(funcionarioRepository.existsById(funcionarioModel.getId())){
            throw new FuncionarioException("Funcionario já existe em nosso Banco de Dados!");
        }

        funcionarioModel = funcionarioRepository.save(funcionarioModel);

        return funcionarioModel;
    }
}
