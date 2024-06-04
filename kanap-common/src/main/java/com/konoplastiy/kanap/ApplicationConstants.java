package com.konoplastiy.kanap;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ApplicationConstants {

    @UtilityClass
    public class URLConstants {
        public static final String BASE_URI = "/v1";
        public static final String TRANSACTIONS = "/transactions";
        public static final String BASE_URL_TRANSACTIONS = BASE_URI + TRANSACTIONS;
    }
}
