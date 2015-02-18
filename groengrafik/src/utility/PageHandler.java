package utility;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class PageHandler {

    private CardLayout layout;
    private final JPanel main;
    private String currentPage;

    public PageHandler(CardLayout layout, JPanel main) {
        this.layout = layout;
        currentPage = "";
        this.main = main;
        this.layout = (CardLayout) (main.getLayout());
    }

    /**
     * Metoden tilføjer en side til CardLayoutet
     *
     * @param panel
     * @param ref
     */
    public void addPage(JPanel panel, String ref) {
        main.add(panel, ref);
    }

    /**
     * Metoden viser den side med det navn der bliver kaldt
     *
     * @param ref
     */
    public void show(String ref) {
        currentPage = ref;
        layout.show(main, ref);
        main.repaint();
        main.revalidate();
    }

    public void showLastPage() {
        show(currentPage);
    }

    public String getCurrentPage() {
        return currentPage;
    }
}
