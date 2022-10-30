package pch.huellaschile.msusuariosmascotas.infrastructure.adapters.input;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Mascota;
import pch.huellaschile.msusuariosmascotas.application.services.mascota.*;
import pch.huellaschile.msusuariosmascotas.infrastructure.dto.RequestMascotaDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    private GetAllMascotaService getAll;

    @Autowired
    private GetMascotaByIdService getById;

    @Autowired
    private SaveMascotaService save;

    @Autowired
    private UpdateMascotaService update;

    @Autowired
    private DeleteMascotaService delete;

    @GetMapping("/all")
    public ResponseEntity<List<Mascota>> getAll(){
        return new ResponseEntity<>(getAll.execute(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Mascota>> getById(@PathVariable int id) {
        return new ResponseEntity<>(getById.execute(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Mascota> save(@RequestBody RequestMascotaDTO dto) {
        return new ResponseEntity<>(save.execute(dto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Mascota> update(@RequestBody RequestMascotaDTO dto) {
        return new ResponseEntity<>(update.execute(dto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        return new ResponseEntity<>(delete.execute(id), HttpStatus.OK);
    }

}
