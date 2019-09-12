package model;

public class Description {
    private int pno;
    private String langCode;
    private String text;

    public Description(int pno, String langCode, String text) {
        this.pno = pno;
        this.langCode = langCode;
        this.text = text;
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
