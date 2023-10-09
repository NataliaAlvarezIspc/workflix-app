package com.tec.workflix.controllers;

import java.util.List;
import java.util.Map;

import com.tec.workflix.models.Usuario;
import com.tec.workflix.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/listar")
    public List<Map<String, Object>> listar(Model model) {
        return service.listar();
    }

    @PostMapping("/agregar")
    public String save(@RequestBody Usuario usuario, Model model) {
        int id=service.add(usuario);
        if(id==0) {
            return "No se pudo Registrar!";
        }
        return "Se registró con éxito!";
    }

    @PostMapping("/actualizar/{id}")
    public String save(@RequestBody Usuario usuario, @PathVariable int id, Model model) {
        usuario.setId(id);
        int r=service.edit(usuario);
        if(r==0) {
            return "No se pudo Actualizar!";
        }
        return "Se actualizó con éxito!";
    }
    @PostMapping("/eliminar/{id}")
    public String delete(@PathVariable int id,Model model) {
        int r=service.delete(id);
        if(r==0) {
            return "Registro No Eliminado!";
        }
        return "Registro Eliminado!";
    }

}
