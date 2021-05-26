package mts.teta.resizer;

import picocli.CommandLine.Option;

public class ConsoleAttributes {
    @Option(names={"-r", "--resize"}, description="resize the image")
    protected boolean resize;

    @Option(names={"-q", "--quality"}, description="quality")
    protected boolean quality ;
}
