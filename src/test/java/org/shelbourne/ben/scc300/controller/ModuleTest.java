package org.shelbourne.ben.scc300.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.shelbourne.ben.scc300.generated.lancaster.module.Module;

@ExtendWith(MockitoExtension.class)
public class ModuleTest {

    @Test
    @SneakyThrows
    public void readModuleFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("C:\\src\\typ-backend\\src\\main\\resources\\default-module-response.json");
        Module module = objectMapper.readValue(file, Module.class);
        assertNotNull(module);
    }
}
