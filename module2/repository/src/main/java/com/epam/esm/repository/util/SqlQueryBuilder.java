package com.epam.esm.repository.util;

import java.util.Map;

public class SqlQueryBuilder {
    private static final String FIRST_PART_OF_UPDATE_GIFT_CERTIFICATE_STRING = "UPDATE gift_certificate SET ";
    private static final String FIRST_PART_OF_FIND_AND_SORT_GIFT_CERTIFICATES_STRING = "SELECT id, name, " +
            "description, price, duration, create_date, last_update_date FROM gift_certificate ORDER BY ";
    private static final String NAME = "name";
    private static final String DURATION = "duration";
    private static final String DESCRIPTION = "description";
    private static final String PRICE = "price";
    private static final String LAST_UPDATE_DATE = "last_update_date = ? ";
    private static final String QUESTION_MARK = "=?,";
    private static final String WHERE_ID = "WHERE id = ?";

    public String buildQueryForUpdate(Map<String, Object> paramMap) {
        StringBuilder stringBuilder = new StringBuilder(FIRST_PART_OF_UPDATE_GIFT_CERTIFICATE_STRING);
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

    public String buildFindAndSortQuery(String columnName, String orderType) {
        return FIRST_PART_OF_FIND_AND_SORT_GIFT_CERTIFICATES_STRING + columnName + " " + orderType;
    }
}
