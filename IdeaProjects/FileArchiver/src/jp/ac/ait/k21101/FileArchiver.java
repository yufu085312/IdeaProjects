package jp.ac.ait.k21101;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
public class FileArchiver{
    public void zip(String inputFile, String outputFile, String zipFile){
        Charset charset = Charset.forName("MS932");

        try(FileOutputStream fil = new FileOutputStream(zipFile);
            BufferedOutputStream bos = new BufferedOutputStream(fil);
            ZipOutputStream zos = new ZipOutputStream(bos,charset);)
        {
            byte[] data = Files.readAllBytes(Path.of(inputFile));
            ZipEntry zip = new ZipEntry(outputFile);
            zos.putNextEntry(zip);
            zos.write(data);

        }catch (IOException e){
            throw new UncheckedIOException(e);
        }
    }
    public static void main(String[] args) {
        String inputFile = "inputSample.txt";
        String outputFile = "outputSample.txt";
        String zipFile = inputFile + ".zip";

        FileArchiver app = new FileArchiver();
        app.zip(inputFile, outputFile, zipFile);
    }
}


