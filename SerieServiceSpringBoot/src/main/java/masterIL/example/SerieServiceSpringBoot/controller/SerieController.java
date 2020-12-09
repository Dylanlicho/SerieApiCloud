package masterIL.example.SerieServiceSpringBoot.controller;

import masterIL.example.SerieServiceSpringBoot.dao.ISerieRepository;
import masterIL.example.SerieServiceSpringBoot.ig.responseType.DiversResponse;
import masterIL.example.SerieServiceSpringBoot.model.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SerieController {

    @Qualifier("ISerieRepository")
    @Autowired
    private ISerieRepository dao;

    @Value("${me}")
    private String me;


    @GetMapping(value = "/Cestqui")
    public String getName(){
        return me;
    }

    @GetMapping(value = "Series")
    public List<Serie> getListeSeries(){
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("YO");
        System.out.println("-------------------------------------------------------------------------------------------");
        return dao.findAll();
    }

    @GetMapping(value = "Serie/{id}")
    public Optional<Serie> getSerieById(@PathVariable Integer id){
        return dao.findById(id);
    }

    @GetMapping(value = "existSerie/{id}")
    public DiversResponse existSerieById(@PathVariable Integer id){
        DiversResponse response = new DiversResponse();
        response.exist = dao.existsById(id);
        return response;
    }

    @GetMapping(value = "count")
    public DiversResponse count(){
        DiversResponse response = new DiversResponse();
        response.nbSerie = dao.count();
        return response;
    }

    @PostMapping(value = "addSerie")
    public void addSerie(@RequestBody Serie serie){
        dao.save(serie);
    }

    @DeleteMapping(value = "deleteSerieBySerie/{serie}")
    public void deleteSerieBySerie(@PathVariable Serie serie){ dao.delete(serie);}

    @DeleteMapping(value = "deleteSerieById/{id}")
    public void deleteSerieById(@PathVariable Integer id){ dao.deleteById(id);}

}
