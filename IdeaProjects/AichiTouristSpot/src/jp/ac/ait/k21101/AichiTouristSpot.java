package jp.ac.ait.k21101;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class AichiTouristSpot {
    public static void main(String[] args) {

        List<Data> data = new ArrayList<>();

        try (Scanner sc = new Scanner(Files.newBufferedReader(
                Path.of("c200326.csv"), Charset.forName("ms932")))) {

            if (sc.hasNextLine()) sc.nextLine();
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                Data r = new Data();
                String[] cols = line.split(",", -1);
                int colnum = 0;
                for (String d : cols) {
                    colnum += 1;
                    switch (colnum) {
                        case 2: r.parseLatLongAndSet(d); break;
                        case 4: r.setName(d); break;
                    }
                }
                r.calcDistance();

                data.add(r);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        try (Scanner sc = new Scanner(Files.newBufferedReader(
                Path.of("c200328.csv"), Charset.forName("ms932")))) {

            if (sc.hasNextLine()) sc.nextLine();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Data r = new Data();

                String[] cols = line.split(",", -1);
                int colnum = 0;
                for (String d : cols) {
                    colnum += 1;
                    switch (colnum) {
                        case 2: r.parseLatLongAndSet(d); break;
                        case 3: r.setName(d); break;
                    }
                }
                r.calcDistance();
                data.add(r);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        try (Scanner sc = new Scanner(Files.newBufferedReader(
                Path.of("c200329.csv"), Charset.forName("ms932")))) {

            if (sc.hasNextLine()) sc.nextLine();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Data r = new Data();

                String[] cols = line.split(",", -1);
                int colnum = 0;
                for (String d : cols) {
                    colnum += 1;
                    switch (colnum) {
                        case 2: r.parseLatLongAndSet(d); break;
                        case 4: r.setName(d); break;
                    }
                }
                r.calcDistance();
                data.add(r);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        try (Scanner sc = new Scanner(Files.newBufferedReader(
                Path.of("c200330.csv"), Charset.forName("ms932")))) {

            if (sc.hasNextLine()) sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Data r = new Data();

                String[] cols = line.split(",", -1);
                int colnum = 0;
                for (String d : cols) {
                    colnum += 1;
                    switch (colnum) {
                        case 2: r.parseLatLongAndSet(d); break;
                        case 4: r.setName(d); break;
                    }
                }
                r.calcDistance();
                data.add(r);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        data.sort(Comparator.comparingDouble(Data::getDistance));

        data.forEach(item -> System.out.println(String.format("%.10f,%s", item.getDistance(), item.getName())));

        List<Data> exports = new ArrayList<>();
        Set<String> uniqueset = new HashSet<>();
        data.stream()
                .filter(item -> uniqueset.add(item.getName()))
                .forEach(item -> exports.add(item));

        try (BufferedWriter bw = Files.newBufferedWriter(
                Path.of("TouristSpot.csv"),
                Charset.defaultCharset())) {
            for (Data r : exports) {
                bw.write(String.format("%.10f,%.10f,%.10f,%s",
                        r.getLatitude(), r.getLongitude(), r.getDistance(), r.getName()));
                bw.newLine();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
