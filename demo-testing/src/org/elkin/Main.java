package org.elkin;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.Locale;

public class Main {

  public static void main(String[] args) {
    // write your code here
    String numeroCedula = "256106578";
    String numeroObligacion = "AB11111";

    System.out.println(
        new DecimalFormat("###,###.##")
            .format(new Integer(numeroObligacion.replaceAll("[^0-9]", ""))));
    DecimalFormat formatea = (new DecimalFormat("###,###.##"));

    Integer numero1 = 1000000;
    double numero2 = 1000000000.50;
    double numero3 = 10000000000000.50;
    Integer nc = Integer.parseInt(numeroCedula);
    System.out.println(nc);

    System.out.println(formatea.format(nc));
    System.out.println(formatea.format(numero2));
    System.out.println(formatea.format(numero3));

    LocalDate localDate = LocalDate.of(2016, 8, 19);

    System.out.println("LocalDate is: " + localDate);
    System.out.println(
        "Date is: " + new SimpleDateFormat("yyyy/MM/dd").format(java.sql.Date.valueOf(localDate)));

    DecimalFormat df = new DecimalFormat("###,###.##");
    double value = 1061722019.32;
    System.out.println(df.format(value));

    DecimalFormat df1 = new DecimalFormat("####.00##'%'");
    double valflo = 02.25;
    System.out.println("DF " + df1.format(valflo));

    System.out.println(Locale.forLanguageTag("es-CO"));

    Currency col = Currency.getInstance(Locale.forLanguageTag("es-CO"));
    System.out.println("Currency symbol of Germany: " + col.getSymbol());

    NumberFormat nf = NumberFormat.getNumberInstance(Locale.forLanguageTag("es-CO"));
    System.out.println("nnnn " + nf.format(value));

    NumberFormat nfval = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("es-CO"));
    System.out.println(nfval.format(value));

    Double valdou = 23.45;

    System.out.println(NumberFormat.getCurrencyInstance(Locale.forLanguageTag("es-CO")).format(valdou.doubleValue()));

    System.out.println(
            Currency.getInstance("USD").getSymbol(Locale.US)
    );

    Double v = 1202.9496;
    Double v1 = 601.4748;
    System.out.println(df.format(v1));
    System.out.println(new DecimalFormat("###,###.##").format(v1));
    System.out.println(NumberFormat.getNumberInstance(Locale.forLanguageTag("es-CO")).toString());
    System.out.println(NumberFormat.getNumberInstance(Locale.forLanguageTag("es-CO")).format(v1.doubleValue()));
    System.out.println(Currency.getInstance(Locale.forLanguageTag("es-CO")).getSymbol());
    System.out.println(Currency.getInstance("USD").getSymbol(Locale.US));
  }
}
