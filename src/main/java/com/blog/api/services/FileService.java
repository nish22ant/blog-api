package com.blog.api.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

/**
 * This interface defines the service methods for managing file operations in the Blog API.
 *
 * @Author Nishant
 */
public interface FileService {

    /**
     * Upload an image file.
     *
     * @param path The destination path for uploading the image.
     * @param file The image file to be uploaded.
     * @return The name of the uploaded image file.
     * @throws IOException If an I/O error occurs during file upload.
     */
    String uploadImage(String path, MultipartFile file) throws IOException;

    /**
     * Get an input stream for a resource file.
     *
     * @param path The path of the resource.
     * @param fileName The name of the resource file.
     * @return An InputStream for the resource file.
     * @throws FileNotFoundException If the resource file is not found.
     */
    InputStream getResource(String path, String fileName) throws FileNotFoundException;
}
