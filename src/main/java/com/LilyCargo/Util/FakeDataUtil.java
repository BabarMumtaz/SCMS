package com.LilyCargo.Util;

import com.github.javafaker.Faker;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FakeDataUtil {

    private static final Faker fakerNL = new Faker(new Locale("nl"));  // Netherlands
    private static final Faker fakerCN = new Faker(new Locale("zh-CN"));  // China
    private static final Faker fakerEN = new Faker(new Locale("en")); // Default for other fields
    private static final Random random = new Random();


    // Generate multiple fake emails (joined with ;)
    public static String getFakeEmails(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> fakerEN.internet().emailAddress())
                .collect(Collectors.joining(";"));
    }

    public static String getRandomNumber() {
        return fakerEN.number().digits(8);  // Example: "37281945"
    }

    /*--------------------------------------------------------------- Generate Date PART ------------------------

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
        String day = String.valueOf(date.getDayOfMonth());
        String month = String.valueOf(date.getMonthValue());
        String year = String.valueOf(date.getYear());
        return new String[]{day, month, year};
    }

    // If you prefer direct day/month/year for ETD
    public static String[] getETDDayMonthYear() {
        return getFutureETDDate(5); // You can change 10 to any default offset
    }

    // And for ETA
    public static String[] getETADayMonthYear() {
        return getFutureETADate(5, 10);
    }

    public static String[] getCurrentDate() {
        LocalDate today = LocalDate.now();
        return splitDate(today);
    }

    --------------------------------------------------------------- Generate Date PART ------------------------
*/
    public static String getString() {
        return fakerEN.bothify("??#####??").toUpperCase(); // Generates a mix of letters and digits, e.g., "AB12345CD"
    }

    public static String getMrnNo() {
        return fakerEN.bothify("??###?##??##??#").toUpperCase(); // Generates a mix of letters and digits, e.g., "AB12345CD"
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
        return fakerEN.lorem().sentence(7); // Generates ~15 words
    }

    public static String getIncidentsRegProblemSolution() {
        return fakerEN.lorem().sentence(30); // Generates ~15 words
    }

    public static String getRemarksInCharacters() {
        return fakerEN.lorem().characters(40); // Generates ~15 words
    }

    public static String getDescription() {
        return fakerEN.lorem().sentence(3);// Generates ~15 words
    }

/*
    // Returns current date split into day, month, and year for Invoice field
    public static String[] getCurrentInvoiceDate() {
        LocalDate today = LocalDate.now();
        return splitDate(today);
    }

    public static String[] getInvoiceDayMonthYear() {
        return getCurrentInvoiceDate(); // You can change 10 to any default offset
    }*/

    // Method to generate invoice number
    public static String generateInvoiceNumber() {
        // Generate a random number for the invoice part (e.g., 010155)
        String invoicePart = fakerEN.number().digits(6);

        // Generate a random uppercase letter for the prefix (e.g., 25X)
        String prefix = fakerEN.letterify("25?", true);

        // Combine prefix and invoice part
        return prefix + "-" + invoicePart;
    }

    public static String getDutchPhoneNumber() {
        String dutchPhoneNumber = fakerNL.phoneNumber().phoneNumber();

        // Replace unwanted characters and ensure it starts with +31
        dutchPhoneNumber = dutchPhoneNumber.replaceAll("[^\\d+]", ""); // Keep only digits and the plus sign
        if (!dutchPhoneNumber.startsWith("+31")) {
            dutchPhoneNumber = "+31" + dutchPhoneNumber.substring(1); // Ensure it starts with +31
        }

        return dutchPhoneNumber;
    }

    public static String getRandomSaleAmount() {
        double amount = fakerEN.number().randomDouble(2, 10, 100); // 2 decimal places, range 10–100
        return String.format("%.2f", amount); // ensures two decimal places
    }

    public static String getAmountEur() {
        int amount = fakerEN.number().numberBetween(1, 10);
        return String.valueOf(amount);
    }

    public static String getIntlPidNo() {
        return fakerEN.bothify("INT###").toUpperCase(); // Generates a mix of letters and digits, e.g., "AB12345CD"
    }

    public static String getEuPidNo() {
        return fakerEN.bothify("EU###").toUpperCase(); // Generates a mix of letters and digits, e.g., "AB12345CD"
    }

    public static String getVatNo() {
        return fakerEN.bothify("??#####??").toUpperCase(); // Generates a mix of letters and digits, e.g., "AB12345CD"
    }

    public static String getHsCode(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("HS Code length must be greater than 0");
        }
        String pattern = "#".repeat(length); // e.g., length=4 -> "####"
        return fakerEN.numerify(pattern);    // generates numeric code of given length
    }

    public static String getRandomCooDecimalValues() {
        double amount = fakerEN.number().randomDouble(2, 0, 10000); // 2 decimal places, range 10–100
        return String.format("%.2f", amount); // ensures two decimal places
    }

    public static String getRandomDecimalValues() {
        double amount = fakerEN.number().randomDouble(2, 0, 20); // 2 decimal places, range 10–100
        return String.format("%.2f", amount); // ensures two decimal places
    }


    // 🌊 List of major Sea Ports
    private static final List<String> SEA_PORTS = Arrays.asList(
            "Port of Shanghai",
            "Port of Singapore",
            "Port of Rotterdam",
            "Port of Antwerp",
            "Port of Hamburg",
            "Port of Los Angeles",
            "Port of Long Beach",
            "Port of Dubai (Jebel Ali)",
            "Port of Busan",
            "Port of Hong Kong"
    );

    // ✈️ List of major Air Ports
    private static final List<String> AIR_PORTS = Arrays.asList(
            "Hartsfield–Jackson Atlanta International Airport",
            "Beijing Capital International Airport",
            "Los Angeles International Airport (LAX)",
            "Dubai International Airport (DXB)",
            "Tokyo Haneda Airport (HND)",
            "London Heathrow Airport (LHR)",
            "Paris Charles de Gaulle Airport (CDG)",
            "Hong Kong International Airport (HKG)",
            "Singapore Changi Airport (SIN)",
            "Frankfurt Airport (FRA)"
    );

    // ✅ Get random Seaport Name
    public static String getRandomSeaPort() {
        return SEA_PORTS.get(random.nextInt(SEA_PORTS.size()));
    }

    // ✅ Get random Airport Name
    public static String getRandomAirPort() {
        return AIR_PORTS.get(random.nextInt(AIR_PORTS.size()));
    }

    // ✅ Generate a random Port Code (5-letter uppercase like "ADALV")
    public static String getRandomPortCode() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            code.append(letters.charAt(random.nextInt(letters.length())));
        }
        return code.toString();
    }

    // ✅ Generate abbreviation from Port Name (first letters of each word, max 5 chars)
    public static String getAbbreviation(String portName) {
        String[] words = portName.split(" ");
        StringBuilder abbr = new StringBuilder();

        for (String word : words) {
            abbr.append(word.charAt(0));
        }

        // Ensure abbreviation is max 5 chars
        return abbr.toString().toUpperCase().substring(0, Math.min(5, abbr.length()));
    }

    // ✅ Get random country name
    public static String getRandomCountry() {
        String[] isoCountries = Locale.getISOCountries();
        String randomCode = isoCountries[random.nextInt(isoCountries.length)];
        Locale locale = new Locale("", randomCode);
        return locale.getDisplayCountry(); // e.g. "Germany", "Canada"
    }

    // ✅ Get random ISO Country Code (2 letters)
    public static String getRandomCountryCode() {
        String[] isoCountries = Locale.getISOCountries();
        return isoCountries[random.nextInt(isoCountries.length)]; // e.g. "DE", "US"
    }


}
