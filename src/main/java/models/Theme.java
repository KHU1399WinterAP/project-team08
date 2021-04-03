package models;

public class Theme {
    public int id;
    public String primaryBackground;
    public String primaryText;
    public String successBackground;
    public String successText;
    public String dangerBackground;
    public String dangerText;
    public String background;
    public String text;
    public String defaultButtonBackground;
    public String defaultButtonText;

    public Theme() {

    }

    public Theme(int id, String primaryBackground, String primaryText, String successBackground,
                 String successText, String dangerBackground, String dangerText, String background,
                 String text, String defaultButtonBackground,
                 String defaultButtonText) {
        this.id = id;
        this.primaryBackground = primaryBackground;
        this.primaryText = primaryText;
        this.successBackground = successBackground;
        this.successText = successText;
        this.dangerBackground = dangerBackground;
        this.dangerText = dangerText;
        this.background = background;
        this.text = text;
        this.defaultButtonBackground = defaultButtonBackground;
        this.defaultButtonText = defaultButtonText;

    }
}