package mts.teta.resizer.imageprocessor;

import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import marvinplugins.MarvinPluginCollection;
import mts.teta.resizer.ResizerApp;
import net.coobird.thumbnailator.Thumbnails;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageProcessor {
    private Thumbnails.Builder<BufferedImage> tb;
    private MarvinImage mi;

    public void processImage(BufferedImage image, ResizerApp app) throws BadAttributesException, IOException {
        //check
        app.chekAttr();

        //resize
        if(app.getResizeHeight() != null) {
            tb = Thumbnails.of(image).forceSize(app.getResizeWidth(),app.getResizeHeight());
        }

        //quality
        if(app.getQuality() != null){
            if(tb == null)
                tb = Thumbnails.of(image).forceSize(image.getWidth(), image.getHeight()).outputQuality((float)app.getQuality()/100);
            else
                tb.outputQuality((float)app.getQuality()/100);
        }

        //crop
        if(app.getCropHeight() != null){
            if(tb == null)
                mi = new MarvinImage(image);
            else
                mi = new MarvinImage(tb.asBufferedImage());

            MarvinPluginCollection.crop(mi.clone(),
                                        mi,
                                        app.getCropX(),
                                        app.getCropY(),
                                        app.getCropWidth(),
                                        app.getCropHeight());

        }

        //blur
        if(app.getBlur() != null) {
            if(mi == null) {
                if (tb != null)
                    mi = new MarvinImage(tb.asBufferedImage());
                else
                    mi = new MarvinImage(image);
            }

            MarvinPluginCollection.gaussianBlur(mi.clone(),
                                                mi,
                                              app.getBlur());
        }

        //format + output
        if(mi != null) {
            if(app.getFormat() != null)
                MarvinImageIO.saveImage(mi, app.getOutputFile().getAbsolutePath()+"."+app.getOutputFile());
            else
                MarvinImageIO.saveImage(mi, app.getOutputFile().getAbsolutePath());
        }
        else if(tb != null) {
            if(app.getFormat() != null)
                tb.outputFormat(app.getFormat()).toFile(app.getOutputFile());
            else
                tb.toFile(app.getOutputFile());
        }
        else{
            Thumbnails.of(image)
                      .forceSize(image.getWidth(), image.getHeight())
                      .outputFormat(app.getFormat())
                      .toFile(app.getOutputFile());
        }
    }
}
