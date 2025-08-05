package org.sat4j.tools;

import org.checkerframework.dataflow.qual.Impure;
import org.checkerframework.dataflow.qual.Pure;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class FileBasedVisualizationTool implements IVisualizationTool {

    private String filename;
    private PrintStream out;

    @Impure
    public FileBasedVisualizationTool(String filename) {
        this.filename = filename;
        updateWriter();
    }

    @Impure
    public void updateWriter() {
        try {
            this.out = new PrintStream(new FileOutputStream(this.filename
                    + ".dat"));
        } catch (FileNotFoundException e) {
            this.out = System.out;
        }
    }

    @Pure
    public String getFilename() {
        return this.filename;
    }

    @Impure
    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Impure
    public void addPoint(double x, double y) {
        this.out.println(x + "\t" + y);
    }

    @Impure
    public void addInvisiblePoint(double x, double y) {
        this.out.println("#" + x + "\t" + "1/0");
    }

    @Impure
    public void init() {
        updateWriter();
    }

    @Impure
    public void end() {
        this.out.close();
    }

}
