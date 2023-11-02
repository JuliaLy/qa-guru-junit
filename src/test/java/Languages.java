public enum Languages {
    Belorussian ("Беларуская","Увайсці"),
    Deutsch ("Deutsch", "Einloggen"),
    English ("English", "Log in"),
    Spanish ("Español", "Iniciar sesión"),
    Portuguese ("Português", "Entrar"),
    Russian ("Русский", "Войти"),
    Ukrainian("Українська", "Увійти"),
    Chinese ("简体中文", "登录");

    private String language;
    private String expectedText;
    Languages(String language, String expectedText) {
        this.language = language;
        this.expectedText = expectedText;
    }

    public String getLanguage() {
        return language;
    }

    public String getExpectedText() {
        return expectedText;
    }
}
