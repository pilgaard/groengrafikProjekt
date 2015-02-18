package utility;

import java.text.DecimalFormat;

public abstract class PriceFormater {

    /**
     * Denne metode kaldes med en integer, der divideres med 100 og vises med 2
     * decimaler og formateres til en String.
     *
     * @param salgsPris int
     * @return
     */
    public static String formaterPrisTilString(int salgsPris) {
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format((double) salgsPris / 100);
    }

    /**
     * Formaterer en String til en int. Metoden bruges til at håndtere priser
     * angivet som decimaltal i feks tekstfelter, Double referencevariable
     * ganges med 100, afrundes og formateres til en integer. Der skal angives
     * en string med en Integer i og intet andet. Ellers vil denne metode IKKE
     * virke.
     *
     * @param pris String må ikke være null
     * @return
     */
    public static int formaterPrisTilInt(String pris) {
        int result = 0;
        if (!pris.equals("")) {
            pris = pris.replace(',', '.');
            if (!pris.isEmpty()) {
                double prisDouble = Double.parseDouble(pris) * 100;
                result = (int) Math.round(prisDouble);
            }
        }
        return result;
    }
}
