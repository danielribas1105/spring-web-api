package drcode.webapi.controller;

import drcode.webapi.model.Usuario;
import drcode.webapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    @GetMapping()
    public List<Usuario> getUsers(){
        return repository.listAll();
    }
    @GetMapping("/{username}")
    public Usuario getOne(@PathVariable("username") String username){
        return repository.findByUserName(username);
    }
    @DeleteMapping("/{userid}")
    public void deleteUser(@PathVariable("userid") Integer id){
        repository.remove(id);
    }
    @PostMapping()
    public void postUser(@RequestBody Usuario usuario){
        repository.save(usuario);
    }
    /*@PutMapping()
    public void putUser(@RequestBody Usuario usuario){
        repository.save(usuario);
    }*/
}
