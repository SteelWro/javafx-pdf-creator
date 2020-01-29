package cwiklinski.me.enums;

public enum PdfEnum {
    TITLE("Wykaz podmiotów zarejestrowanychń jako podatnicy VAT," +
            " niezarejstrowanych oraz wykreślonych i przywróconych do rejestru VAT"),
    SUBTITLE("Wynik wyszukiwania na podstawie NIP: "),
    NAME("NAZWA: "),
    NIP("NIP: "),
    DAY_STATE("Stan na dzień: "),
    SEARCH_DATE("Data wyszukania: "),
    SUBTITTLE_THREE("Figuruje w rejestrze VAT "),
    SUBJECT_NAME_CELL("Firma(nazwa) lub imię i nazwisko "),
    SUBJECT_NUMBER_CELL("Numer, za pomocą któego podmiot został zidentyfikowany  na " +
            "potrzeby, jeżeli taki numer został przyznany "),
    SUBJECT_PESEL_CELL("Numer PESEL, o ile podmiot posiada "),
    SUBJECT_STATUS_CELL("Status podatnika (wg stanu na dzień sprawdzenia "),
    SUBJECT_REGON_CELL("Numer indentyfikacyjny REGON, o ile został nadany "),
    SUBJECT_KRS_NUMBER_CELL("Numer w krajowym rejestrze sądowym, o ile został nadany"),
    NATURAL_PERSON_ADDRESS_CELL("Adres siedziby - w przypadku podmiotu niebędącego osobą fizyczną"),
    LEGAL_ENTITY_ADDRESS_CELL("Adres stałego miejsca prowadzenia działalności albo adres zamieszkania, " +
            "w przypadku braku adresu stałego miejsca prowadzenia działalności - w odniesieniu do osoby fizycznej"),
    AUTHORIZED_CLERKS_LIST_CELL("Imiona i nazwiska prokurentów oraz ich numery identyfikacji podatkowej lub numery PESEL"),
    REPRESENTATIVES_NAMES_LIST_CELL("Imiona i nazwiska osób wchodzących w skład organu uprawnionego do reprezentowania podmiotu oraz ich numery identyfikacji podatkowej lub numery PESEL"),
    PARTNERS_CELL("Imię i nazwisko lub firma(nazwa) wspólnika oraz jego numer identyfikacji podatkowej lub numer PESEL"),
    ACCOUNT_NUMBERS_CELL("Numery rachunków rozliczeniowych lub imiennych rachunów w SKOK"),
    REGISTRATION_TAXPAYER_DATE_CELL("Data rejestracji jako podatnika VAT"),
    REGISTRATION_REJECT_TAXPAYER_DATE_CELL("Data odmowy rejestracji jako podatnika VAT. Podstawa prawna odmowy rejestracji"),
    REGISTRATION_REMOVE_TAXPAYER_DATE_CELL("Data wykreślenia rejestracji jako podatnika VAT. Podstawa prawna wykreślenia"),
    REGISTRATION_RECOVER_TAXPAYER_DATE_CELL("Data przywrócenia rejestracji jako podatnika VAT. Podstawa prawna przywrócenia"),
    SEARCH_ID("Identyfikator wyszukiwania: ");

    private String text;

    PdfEnum(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
