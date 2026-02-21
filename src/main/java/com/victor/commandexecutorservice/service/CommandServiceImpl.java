package com.victor.commandexecutorservice.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class CommandServiceImpl implements CommandService {

    @Override
    public String listFiles(String path) throws Exception {

        // Si no se envía path, usar el directorio actual
        if (path == null || path.isBlank()) {
            path = ".";
        }

        // 1. Validar caracteres peligrosos
        if (path.matches(".*[;&|><*?\"'`].*")) {
            throw new IllegalArgumentException("El path contiene caracteres no permitidos.");
        }

        // 2. Normalizar la ruta
        Path normalizedPath = Paths.get(path).normalize();

        // 3. Validar que exista
        if (!Files.exists(normalizedPath)) {
            throw new IllegalArgumentException("El directorio no existe.");
        }

        // 4. Validar que sea un directorio
        if (!Files.isDirectory(normalizedPath)) {
            throw new IllegalArgumentException("La ruta no es un directorio.");
        }

        // Detectar sistema operativo
        String os = System.getProperty("os.name").toLowerCase();
        Process process;

        if (os.contains("win")) {
            process = Runtime.getRuntime().exec("cmd /c dir " + normalizedPath);
        } else {
            process = Runtime.getRuntime().exec("ls -la " + normalizedPath);
        }

        // Leer salida del comando
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream())
        );

        StringBuilder output = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        process.waitFor();

        return output.toString();
    }
}