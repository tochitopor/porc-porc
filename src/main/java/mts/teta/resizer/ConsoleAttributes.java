package mts.teta.resizer;

import mts.teta.resizer.imageprocessor.BadAttributesException;
import picocli.CommandLine;

import java.io.File;
import java.util.Arrays;

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
    private Integer[] resize = new Integer[2];

   @CommandLine.Option(names = {"-q", "--quality"},
                       paramLabel = "value",
                       description = "JPEG/PNG compression level")
    private Integer quality;

    @CommandLine.Option(names = {"-c", "--crop"},
                        paramLabel = "width height x y",
                        description = "cut out one rectangular area of the image",
                        split = " ")
    private Integer[] crop = new Integer[4];

    @CommandLine.Option(names = {"-b", "--blur"},
                        paramLabel = "radius",
                        description = "reduce image noise detail levels")
    private Integer blur;

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

    public Integer getResizeWidth() {
        return resize[0];
    }

    public void setResizeWidth(Integer width) {
        resize[0] = width;
    }

    public Integer getResizeHeight() {
        return resize[1];
    }

    public void setResizeHeight(Integer height) {
        resize[1] = height;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getCropWidth() {
        return crop[0];
    }

    public void setCropWidth(Integer cropWidth) {
        crop[0] = cropWidth;
    }

    public Integer getCropHeight() {
        return crop[1];
    }

    public void setCropHeight(Integer cropHeight) {
        crop[1] = cropHeight;
    }

    public Integer getCropX() {
        return crop[2];
    }

    public void setCropX(Integer cropX) {
        crop[2] = cropX;
    }

    public Integer getCropY() {
        return crop[3];
    }

    public void setCropY(Integer cropY) {
        crop[3] = cropY;
    }

    public Integer getBlur() {
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

    public void chekAttr() throws BadAttributesException {
        if(resize[0] != null
                && (resize.length!=2 || resize[0]<=0 || resize[1]<=0))
            throw new BadAttributesException(" BAD RESIZE ATTRIBUTES ");

        if(quality != null
                && (quality<1 || quality>100))
            throw new BadAttributesException(" BAD QUALITY ATTRIBUTES ");

        if(crop != null
                &&(crop[0]<1 || crop[1]<1 || crop[2]<0 || crop[3]<0))
            throw new BadAttributesException(" BAD CROP ATTRIBUTES ");
    }

}