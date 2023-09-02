package com.apicomsqlite.poo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.poo.enity.Livro;
import com.apicomsqlite.poo.service.LivroService;

@RestController
public class LivroController {

    @Autowired
    private LivroService livroService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createlivro", method = RequestMethod.POST)
    public String createlivro(@RequestBody Livro livro) {
        return livroService.createlivro(livro);
    }

    @RequestMapping(value = "readlivros", method = RequestMethod.GET)
    public List<Livro> readlivros() {
        return livroService.readlivros();
    }

    @RequestMapping(value = "updatelivro", method = RequestMethod.PUT)
    public String updatelivro(@RequestBody Livro livro) {
        return livroService.updatelivro(livro);
    }

    @RequestMapping(value = "deletelivro", method = RequestMethod.DELETE)
    public String deletelivro(@RequestBody Livro livro) {
        return livroService.deletelivro(livro);
    }
}
