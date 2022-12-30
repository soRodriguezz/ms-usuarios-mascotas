package pch.huellaschile.msusuariosmascotas.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Usuario;
import pch.huellaschile.msusuariosmascotas.application.services.usuario.*;
import pch.huellaschile.msusuariosmascotas.infrastructure.adapters.input.UsuarioController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SaveUsuarioService save;
    @MockBean
    private GetAllUsuarioService getAll;
    @MockBean
    private GetUsuarioByIdService byId;
    @MockBean
    private UpdateUsuarioService update;
    @MockBean
    private DeleteUsuarioService delete;
    Usuario usuario = new Usuario();
    Usuario usuario2 = new Usuario();
    List<Usuario> usuarioList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        usuario.setRut("1923998-2");
        usuario.setNombre("nombre");
        usuario.setApellido("apellido");

        usuarioList.add(usuario);

        usuario2.setRut("1923998-2");
        usuario2.setNombre("nombre");
        usuario2.setApellido("apellido");

        usuarioList.add(usuario2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(usuario);

        when(save.execute(usuario)).thenReturn(usuario);

        this.mockMvc.perform(post("/usuario/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isCreated());
    }


    @Test
    void getAllTest() throws Exception {
        when(getAll.execute()).thenReturn(usuarioList);
        this.mockMvc.perform(get("/usuario/all")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getByIdTest() throws Exception {
        when(byId.execute(1)).thenReturn(Optional.ofNullable(usuario));
        this.mockMvc.perform(get("/usuario/" + "1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void updateTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(usuario);

        when(update.execute(usuario)).thenReturn(usuario);
        this.mockMvc.perform(put("/usuario/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void deleteTest() throws Exception {
        when(delete.execute(1)).thenReturn(true);
        this.mockMvc.perform(delete("/usuario/delete/" + "1")).andDo(print()).andExpect(status().isOk());
    }
}
