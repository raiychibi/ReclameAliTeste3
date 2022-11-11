package br.com.gs.reclameali.service;

import br.com.gs.reclameali.model.Problema;
import br.com.gs.reclameali.model.Usuario;
import br.com.gs.reclameali.repository.ProblemaRepository;
import br.com.gs.reclameali.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProblemaService {

    private final ProblemaRepository repository;

    public ProblemaService(ProblemaRepository repository) {this.repository = repository;}

    public Problema notificar(Problema problema) {
        return repository.save(problema);
    }




    public void deletar(Long id){
        Problema problema = repository.findById(id).orElseThrow(()->new EntityNotFoundException("id não localizado"));
        repository.delete(problema);
    }

    public Problema buscar(Long id) {
        return repository.findById(id).orElseThrow(()->new EntityNotFoundException("id não localizado"));

    }

    public List<Problema> buscarTodos(){
        return repository.findAll();
    }

    public Problema atualizar(Long id, Problema problemaAtualizado){
        Problema problema = this.buscar(id);
        problemaAtualizado.setId(problema.getId());
        return repository.save(problemaAtualizado);
    }

}
