package mts.teta.resizer;

import picocli.CommandLine;

import java.io.File;

public class ConsoleAttributes {

    @CommandLine.Parameters(paramLabel = "input-file",
                            description = "input file")
    private File inputFile;

    @CommandLine.Parameters(paramLabel = "output-file",
                            description = "create output file")
    private File outputFile;

    @CommandLine.Option(names = {"-r", "--resize"},
                        paramLabel = "width height",
                        description = "resize the image",
                        split = " ")
    private int[] resize = new int[2];

   @CommandLine.Option(names = {"-q", "--quality"},
                       paramLabel = "value",
                       description = "JPEG/PNG compression level")
    private int quality;

    @CommandLine.Option(names = {"-c", "--crop"},
                        paramLabel = "width height x y",
                        description = "cut out one rectangular area of the image",
                        split = " ")
    private int[] crop = new int[4];

    @CommandLine.Option(names = {"-b", "--blur"},
                        paramLabel = "radius",
                        description = "reduce image noise detail levels")
    private int blur;

    @CommandLine.Option(names = {"-f", "--format"},
                        paramLabel = "\"outputFormat\"",
                        description = "the image format type JPEG/PNG")
    private String format;

    public File getInputFile() {
        return inputFile;
    }

    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    public File getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    public int getResizeWidth() {
        return resize[0];
    }

    public void setResizeWidth(int width) {
        resize[0] = width;
    }

    public int getResizeHeight() {
        return resize[1];
    }

    public void setResizeHeight(int height) {
        resize[1] = height;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getCropWidth() {
        return crop[0];
    }

    public void setCropWidth(int cropWidth) {
        crop[0] = cropWidth;
    }

    public int getCropHeight() {
        return crop[1];
    }

    public void setCropHeight(int cropHeight) {
        crop[1] = cropHeight;
    }

    public int getCropX() {
        return crop[2];
    }

    public void setCropX(int cropX) {
        crop[2] = cropX;
    }

    public int getCropY() {
        return crop[3];
    }

    public void setCropY(Integer cropY) {
        crop[3] = cropY;
    }

    public int getBlur() {
        return blur;
    }

    public void setBlur(Integer blur) {
        this.blur = blur;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

}