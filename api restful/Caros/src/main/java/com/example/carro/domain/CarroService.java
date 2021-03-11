package com.example.carro.domain;

import com.example.carro.api.exception.ObjectNotFoundException;
import com.example.carro.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    private CarroRepository rep;

    public List<CarroDTO> getCarros(){
        return rep.findAll().stream().map(CarroDTO::create).collect(Collectors.toList());
    }

    public CarroDTO getById(Long id) {
        Optional<Carro> carro = rep.findById(id);
        return carro.map(CarroDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<CarroDTO> findyByTipo(String tipo) {
        return rep.findByTipo(tipo).stream().map(CarroDTO::create).collect(Collectors.toList());
    }

    public CarroDTO save(Carro carro) {
        Assert.notNull(carro.getId(), "Não foi possivel inserir o carro!");

        return CarroDTO.create(rep.save(carro));
    }

    public CarroDTO update(Carro carro, Long id) {
        Assert.notNull(id, "Não foi possivel localizar o carro!");

        Optional<Carro> optional = rep.findById(id);
        if(optional.isPresent()){
            Carro db = optional.get();
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            rep.save(db);
            return CarroDTO.create(db);
        }else{
            return null;
            //throw new RuntimeException("Não foi possivel atualizar o resgistro");
        }
    }

    public void delele(Long id) {
            rep.deleteById(id);
    }
}
