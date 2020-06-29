package com.converter.task.converters;

import javax.swing.text.html.Option;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;

public interface FileConverter {

    public void parseData(File f) throws FileNotFoundException;
}
