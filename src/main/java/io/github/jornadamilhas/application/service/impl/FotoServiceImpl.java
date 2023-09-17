package io.github.jornadamilhas.application.service.impl;

import io.github.jornadamilhas.application.service.FotoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FotoServiceImpl implements FotoService {

    @Value("${storage.directory}")
    private String storageDirectory;


    @Override
    public String salvarFoto(MultipartFile foto) {

        try{
            Path directory = Paths.get(storageDirectory);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            String nomeArquivo = foto.getOriginalFilename();
            Path pathFoto = Paths.get(directory.toString(), nomeArquivo);
            Files.write(pathFoto, foto.getBytes());
            return pathFoto.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
