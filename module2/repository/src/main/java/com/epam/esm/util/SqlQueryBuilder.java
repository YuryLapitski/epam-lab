package com.epam.esm.util;

import java.util.Map;

public class SqlQueryBuilder {
    public final static String BLANK_FOR_UPDATE_GIFT_CERTIFICATE_BY_ID = "UPDATE gift_certificate SET ";
    private static final String NAME = "name";
    private static final String DURATION = "duration";
    private static final String DESCRIPTION = "description";
    private static final String PRICE = "price";
    private static final String LAST_UPDATE_DATE = "last_update_date = ? ";
    private static final String QUESTION_MARK = "=?,";
    private static final String WHERE_ID = "WHERE id = ?";

    public String buildQueryForUpdate(Map<String, Object> paramMap) {
        StringBuilder stringBuilder = new StringBuilder(BLANK_FOR_UPDATE_GIFT_CERTIFICATE_BY_ID);
        for (String column : paramMap.keySet()) {
            switch (column) {
                case NAME:
                case PRICE:
                case DESCRIPTION:
                case DURATION:
                    stringBuilder.append(column);
                    stringBuilder.append(QUESTION_MARK);
                    break;
            }
        }
        stringBuilder.append(LAST_UPDATE_DATE);
        stringBuilder.append(WHERE_ID);
        return stringBuilder.toString();
    }
}
