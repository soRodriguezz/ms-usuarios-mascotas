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
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Mascota;
import pch.huellaschile.msusuariosmascotas.application.domain.entities.Usuario;
import pch.huellaschile.msusuariosmascotas.application.services.mascota.*;
import pch.huellaschile.msusuariosmascotas.infrastructure.adapters.input.MascotaController;
import pch.huellaschile.msusuariosmascotas.infrastructure.dto.RequestMascotaDTO;
import pch.huellaschile.msusuariosmascotas.infrastructure.dto.RequestMascotaUsuarioDTO;
import pch.huellaschile.msusuariosmascotas.infrastructure.dto.RequestNombreRazaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MascotaController.class)
public class MascotaControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SaveMascotaService save;
    @MockBean
    private GetAllMascotaService getAll;
    @MockBean
    private GetMascotaByIdService byId;
    @MockBean
    private UpdateMascotaService update;
    @MockBean
    private GetMascotaByIdUsuarioService getByIdUser;
    @MockBean
    private GetMascotaByNombreService getByNombre;
    @MockBean
    private DeleteMascotaService delete;
    Mascota mascotaOne = new Mascota();
    Mascota mascotaTwo = new Mascota();
    RequestMascotaDTO dto = new RequestMascotaDTO();
    List<Mascota> mascotaList = new ArrayList<>();
    Usuario usuario = new Usuario();
    RequestMascotaUsuarioDTO dtoMascotaUsuario = new RequestMascotaUsuarioDTO();

    RequestNombreRazaDTO razaDTO = new RequestNombreRazaDTO();

    @BeforeEach
    void setUp() {
        mascotaOne.setNombre("nombre");
        mascotaOne.setTratamiento(true);
        mascotaOne.setRaza("RAZA");
        mascotaOne.setIdUsuario(1);
        mascotaOne.setUsuario(usuario);

        mascotaList.add(mascotaOne);

        mascotaOne.setNombre("nombre2");
        mascotaOne.setTratamiento(true);
        mascotaOne.setRaza("RAZA2");
        mascotaOne.setIdUsuario(1);
        mascotaOne.setUsuario(usuario);

        mascotaList.add(mascotaTwo);

        dtoMascotaUsuario.setIdMascota(1);
        dtoMascotaUsuario.setIdUsuario(1);

        razaDTO.setNombre("nombre");
        razaDTO.setRaza("raza");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(dto);

        when(save.execute(dto)).thenReturn(mascotaOne);

        this.mockMvc.perform(post("/mascota/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isCreated());
    }

    @Test
    void getAllTest() throws Exception {
        when(getAll.execute()).thenReturn(mascotaList);
        this.mockMvc.perform(get("/mascota/" + "all")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getByIdTest() throws Exception {
        when(byId.execute(1)).thenReturn(Optional.ofNullable(mascotaOne));
        this.mockMvc.perform(get("/mascota/" + "1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void updateTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(dto);

        when(update.execute(dto)).thenReturn(mascotaOne);
        this.mockMvc.perform(put("/mascota/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void deleteTest() throws Exception {
        when(delete.execute(1)).thenReturn(true);
        this.mockMvc.perform(delete("/mascota/delete/" + "1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getFindByIdUsuarioAndIdMascotaTest() throws Exception {
        when(getByIdUser.execute(dtoMascotaUsuario)).thenReturn(mascotaOne);
        this.mockMvc.perform(get("/mascota/usuario")).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void getFindByNombreOrRazaTest() throws Exception {
        when(getByNombre.execute(razaDTO)).thenReturn(mascotaList);
        this.mockMvc.perform(get("/mascota/nameorraza")).andDo(print()).andExpect(status().isBadRequest());
    }

}
