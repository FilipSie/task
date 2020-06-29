package com.converter.task.services;

import com.converter.task.converters.CSVConverter;
import com.converter.task.converters.XMLConverter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class AppLogic{

    Optional<String> xml = Optional.of("xml");
    Optional<String> csv = Optional.of("csv");

    public static Optional<String> getFileType(File file){
        return Optional.ofNullable(file.getName())
                .filter(f-> f.contains("."))
                .map(f-> f.substring(file.getName().lastIndexOf(".")+ 1));
    }


    public void setStrategy(File file) throws FileNotFoundException {
        if(getFileType(file).equals(xml)){
            System.out.println("File with .xml extension");
            XMLConverter converter = new XMLConverter();
//            converter.parseData(file);
        }else if(getFileType(file).equals(csv)){
            System.out.println("File with .csv extension");
            CSVConverter converter = new CSVConverter();
            converter.parseData(file);
        }
    }

    public void readFile(File file){
        try(Stream<String> stream = Files.lines(Paths.get(file.getName()))){
            stream.forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }
    }





}
