package com.blog.api.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blog.api.services.FileService;

/**
 * This class provides implementations for the FileService interface.
 *
 * @Author Nishant
 */
@Service
public class FileServiceImpl implements FileService {
    /**
     * Upload an image file to the specified path.
     *
     * @param path The path to upload the image.
     * @param file The MultipartFile containing the image data.
     * @return The generated file name.
     * @throws IOException If an I/O error occurs during file operations.
     */
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        // Original file name
        String name = file.getOriginalFilename();

        // Generate a random file name
        String randomID = UUID.randomUUID().toString();
        String fileName1 = randomID.concat(name.substring(name.lastIndexOf(".")));

        // Full path of the file
        String filePath = path + File.separator + fileName1;

        // Create the folder if it doesn't exist
        File f = new File(path);
        if (!f.exists()) {
            f.mkdir();
        }

        // Copy the file data
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileName1;
    }

    /**
     * Get the input stream for a resource located at the specified path and file name.
     *
     * @param path     The base path of the resource.
     * @param fileName The name of the file.
     * @return An InputStream for the resource.
     * @throws FileNotFoundException If the resource file is not found.
     */
    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath = path + File.separator + fileName;
        InputStream is = new FileInputStream(fullPath);
        return is;
    }
}
