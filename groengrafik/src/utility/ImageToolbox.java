package utility;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;

public class ImageToolbox {

    private static ImageToolbox reference;
    
    /**Laver en URL referencevariable som holder filnavnet. Kontrollerer om denne er tom,
     * hvis ikke oprettes et nyt ImageIcon og returneres.
     * 
     * @param filename
     * @return image
     * @throws IOException 
     */
    public static Image loadImageIconRessource(String filename) throws IOException {
        ImageIcon ii = null;
        System.out.println("fil " + filename);
        // laver ressource file  url
        URL url = reference.getClass().getClassLoader().getResource(filename);

        // laver bufferedImage
        if (url != null) {
            ii = new ImageIcon(url);
        }
        return ii.getImage();
    }

    /**Tegner billede, sætter placering og størrelse.
     * 
     * @param g
     * @param imageIcon
     * @param startX
     * @param startY
     * @param sizeX
     * @param sizeY 
     */
   public static void drawImage(Graphics g, ImageIcon imageIcon, int startX, int startY, int sizeX, int sizeY){
       g.drawImage(imageIcon.getImage(), startX, startY, sizeX, sizeY, null);
   }
   
}
