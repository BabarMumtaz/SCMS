package com.LilyCargo.Util;

import com.github.javafaker.Faker;

import java.text.DecimalFormat;
import java.util.Locale;

public class FakeDataUtil {

    private static final Faker fakerNL = new Faker(new Locale("nl"));  // Netherlands
    private static final Faker fakerCN = new Faker(new Locale("zh-CN"));  // China
    private static final Faker fakerEN = new Faker(new Locale("en")); // Default for other fields

    public static String getHouseBLNo() {
        return fakerEN.number().digits(5);
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
        return formatter.format(value).replace('.', ',');
    }
}
