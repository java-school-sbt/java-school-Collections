package ru.rzn.sbt.javaschool.lesson4.dao;


import ru.rzn.sbt.javaschool.lesson4.entity.TextFileEntity;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataProcessing {

    public static final String fileName = "/testfile.txt";

    public static void init(Collection<TextFileEntity> list) {

        List<String> l = null;
        try (Stream<String> lines = Files.lines(Paths.get(fileName), Charset.forName("windows-1251"))){
            l = lines.collect(Collectors.toList());
        } catch (IOException e) {

        }
        for (int i = 0; i < l.size(); i++) {
            list.add(new TextFileEntity(i+1, l.get(i)));
        }
    }

}
