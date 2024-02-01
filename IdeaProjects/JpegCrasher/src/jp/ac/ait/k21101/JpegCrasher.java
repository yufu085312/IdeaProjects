package jp.ac.ait.k21101;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class JpegCrasher {
    /**
     * メインメソッド
     */
    public static void main(String[] args) {
        //15違う数字
        crash("Baboon.jpg", "Baboon_out.jpg", 100);
    }
    /**
     * 入力されたファイルのランダムな1Byteをランダムな1bit加算で置き換えることでファイルをクラッシュさせる
     * @param input_filePath
     * @param output_filePath
     * @param challenge
     */
    public static void crash(
            String input_filePath,
            String output_filePath,
            int challenge) {
        // TODO:
        byte[] bits = {
                (byte)0b00000001,
                (byte)0b00000010,
                (byte)0b00000100,
                (byte)0b00001000,
                (byte)0b00010000,
                (byte)0b00100000,
                (byte)0b01000000,
                (byte)0b10000000
        };
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(Path.of(input_filePath));
        }catch(IOException e){
            throw new UncheckedIOException(e);
        }
        int randamVal1;
        byte randamVal2;
        for(int i=0; i<challenge; i++){
            randamVal1 = (int)(Math.random() * bytes.length);
            randamVal2 = (byte)(Math.random() * bits.length);
            bytes[randamVal1] += randamVal2;
        }
        try{
            Files.write(Path.of(output_filePath), bytes);
        } catch (IOException e){
            throw new UncheckedIOException(e);
        }
    }
}
