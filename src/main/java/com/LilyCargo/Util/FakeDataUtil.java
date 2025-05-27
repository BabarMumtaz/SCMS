package com.LilyCargo.Util;

import com.github.javafaker.Faker;

import java.text.DecimalFormat;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FakeDataUtil {

    private static final Faker fakerNL = new Faker(new Locale("nl"));  // Netherlands
    private static final Faker fakerCN = new Faker(new Locale("zh-CN"));  // China
    private static final Faker fakerEN = new Faker(new Locale("en")); // Default for other fields

    public static String getFNO() {
        return fakerEN.number().digits(8);  // Example: "37281945"
    }

    //--------------------------------------------------------------- Generate Date PART ------------------------
    public static String[] getFutureETDDate(int daysFromToday) {
        LocalDate etd = LocalDate.now().plusDays(daysFromToday);
        return splitDate(etd);
    }

    public static String[] getFutureETADate(int etdOffset, int daysAfterETD) {
        LocalDate eta = LocalDate.now().plusDays(etdOffset + daysAfterETD);
        return splitDate(eta);
    }

    // Optional: If you need full date as a string like "2025-06-26"
    public static String getFormattedDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    private static String[] splitDate(LocalDate date) {
        String day = String.format("%02d", date.getDayOfMonth());
        String month = String.format("%02d", date.getMonthValue());
        String year = String.valueOf(date.getYear());
        return new String[]{day, month, year};
    }

    // If you prefer direct day/month/year for ETD
    public static String[] getETDDayMonthYear() {
        return getFutureETDDate(10); // You can change 10 to any default offset
    }

    // And for ETA
    public static String[] getETADayMonthYear() {
        return getFutureETADate(10, 14);
    }

    //--------------------------------------------------------------- Generate Date PART ------------------------

    public static String getHouseBLNo() {
        return fakerEN.bothify("??#####??").toUpperCase(); // Generates a mix of letters and digits, e.g., "AB12345CD"
    }

    public static String getBLNo() {
        return fakerEN.bothify("??#####??").toUpperCase(); // Generates a mix of letters and digits, e.g., "AB12345CD"
    }

    public static String getContents() {
        int amount = 1000 + fakerEN.number().numberBetween(100, 9000);
        return String.valueOf(amount);
    }

    public static String getWeights() {
        double weight = fakerEN.number().randomDouble(2, 1000, 20000);
        return String.format("%.2f", weight);
    }

    public static String getMeasurements() {
        double measurement = fakerEN.number().randomDouble(2, 1000, 100000);
        return String.format("%.2f", measurement);
    }

    public static String getBondedLocation(String country) {
        if (country.equalsIgnoreCase("netherlands")) {
            return fakerNL.address().fullAddress();
        } else if (country.equalsIgnoreCase("china")) {
            return fakerCN.address().fullAddress();
        } else {
            return fakerEN.address().fullAddress();
        }
    }

    public static String getAdminFee() {
        double fee = 100 + (900 * fakerEN.random().nextDouble());
        return formatAmount(fee);
    }

    public static String getDuty() {
        double duty = 100 + (400 * fakerEN.random().nextDouble());
        return formatAmount(duty);
    }

    private static String formatAmount(double value) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        return formatter.format(value);
    }

    public static String getRemarks() {
        return fakerEN.lorem().sentence(15); // Generates ~15 words
    }

    public static String getIncidentsRegProblemSolution() {
        return fakerEN.lorem().sentence(30); // Generates ~15 words
    }

    public static String getRemarksInCharacters() {
        return fakerEN.lorem().characters(40); // Generates ~15 words
    }

    // Returns current date split into day, month, and year for Invoice field
    public static String[] getCurrentInvoiceDate() {
        LocalDate today = LocalDate.now();
        return splitDate(today);
    }

    public static String[] getInvoiceDayMonthYear() {
        return getCurrentInvoiceDate(); // You can change 10 to any default offset
    }

    // Method to generate invoice number
    public static String generateInvoiceNumber() {
        // Generate a random number for the invoice part (e.g., 010155)
        String invoicePart = fakerEN.number().digits(6);

        // Generate a random uppercase letter for the prefix (e.g., 25X)
        String prefix = fakerEN.letterify("25?", true);

        // Combine prefix and invoice part
        return prefix + "-" + invoicePart;
    }

    public static String getRandomSaleAmount() {
        double amount = fakerEN.number().randomDouble(2, 10, 100); // 2 decimal places, range 10–100
        return String.format("%.2f", amount); // ensures two decimal places
    }

    public static String getAmountEur() {
        int amount = fakerEN.number().numberBetween(1, 10);
        return String.valueOf(amount);
    }
}
