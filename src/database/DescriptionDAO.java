package database;

import model.Description;

import java.util.Arrays;
import java.util.List;

public class DescriptionDAO {

    private Description whiteEn = new Description(123,"en", "White cup for coffee");
    private Description whiteDe = new Description(123,"de", "weise kop für kafe");
    private Description whiteNb = new Description(123,"nb", "Hvit kopp til kaffe");
    private Description blackEn = new Description(124,"en", "Black cup for coffee");
    private Description blackDe = new Description(124,"de", "Schwarz kop für kafe");
    private Description blackNb = new Description(124,"nb", "Sort kopp til kaffe");
    private List<Description> allDescriptions;

    public DescriptionDAO() {
        allDescriptions = Arrays.asList(whiteEn, whiteDe, whiteNb, blackDe, blackEn, blackNb);
    }

    public String getDescription(int pno, String langCode) {
        return allDescriptions.stream().filter(e -> e.getLangCode().equals(langCode) && e.getPno() == pno).findAny().get().getText();
    }

    public List<Description> getAllDescriptions() {
        return allDescriptions;
    }
}
