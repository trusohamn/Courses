package utp.alabrudzinska.people;
import java.util.Locale;
public enum Nationality {
	POLISH(new Locale("pl")),
	UKRAINIAN(new Locale("uk")),
	BELARUSSIAN(new Locale("be")),
	SLOVAK(new Locale("sk")),
	LITHUANIAN(new Locale("lt")),
	LATVIAN(new Locale("lv")),
	BRITISH(Locale.UK),
	INDIAN(new Locale("hi")),
	CHINESE(Locale.CHINESE),
	VIETNAMESE(new Locale("vi"));
	
    private Locale locale;

    Nationality(Locale locale) {
        this.locale = locale;
    }

    public Locale locale() {
        return locale;
    }

}
