package pch.huellaschile.msusuariosmascotas.infrastructure.adapters.input;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Usuario;
import pch.huellaschile.msusuariosmascotas.application.services.usuario.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private GetAllUsuarioService getAll;

    @Autowired
    private GetUsuarioByIdService getById;

    @Autowired
    private SaveUsuarioService save;

    @Autowired
    private UpdateUsuarioService update;

    @Autowired
    private DeleteUsuarioService delete;

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAll() {
        return new ResponseEntity<>(getAll.execute(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> getById(@PathVariable int id) {
        return new ResponseEntity<>(getById.execute(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(save.execute(usuario), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(update.execute(usuario), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        return new ResponseEntity<>(delete.execute(id), HttpStatus.OK);
    }
}
