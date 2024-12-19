
 
package javaassignment.Admin.SM;

import javaassignment.SalesManager.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javaassignment.SalesManager.GraphPanel;
import javax.imageio.ImageIO;

/**
 *
 * @author vroom
 */

public class AdminSaveGraphAsImage{
public static void saveGraphAsImage(GraphPanel graphPanel, String filePath) {
    int width = graphPanel.getWidth();
    int height = graphPanel.getHeight();

    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = image.createGraphics();
    graphPanel.paint(g2d);
    g2d.dispose();

    try {
        ImageIO.write(image, "png", new File("C:/barGraph.png"));
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}