package mts.teta.resizer;

import mts.teta.resizer.imageprocessor.ImageProcessor;
import picocli.CommandLine;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "resizer",
                     mixinStandardHelpOptions = true,
                     version = "resizer 0.0.1",
                     description = "Available formats: jpeg png",
                     separator = " ",
                     parameterListHeading = "Parameters settings:\n",
                     optionListHeading = "Options settings:\n")
public class ResizerApp extends ConsoleAttributes implements Callable<Integer> {
    public static void main(String... args){
        args[0] = "./src/test/resources/Good_Will_Hunting_1997.jpg";
        args[1] = "./src/test/resources/result.jpg";
        args[2] = "-r";
        args[3] = "900 900";
        int exitCode = runConsole(args);
        System.exit(exitCode);
    }

    protected static int runConsole(String[] args) {
        return new CommandLine(new ResizerApp()).execute(args);
    }

    @Override
    public Integer call() throws Exception {
        ImageProcessor imageProcessor = new ImageProcessor();
        try{
            imageProcessor.processImage(ImageIO.read(getInputFile()), this);
        }
        catch(IIOException e){
            throw new IIOException("FAILURE OF READING OR WRITING OPERATIONS");
        }
        return 0;
    }
}
