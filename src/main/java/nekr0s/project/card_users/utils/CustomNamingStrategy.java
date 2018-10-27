package nekr0s.project.card_users.utils;

import org.hibernate.cfg.ImprovedNamingStrategy;

public class CustomNamingStrategy extends ImprovedNamingStrategy {
    private static final String PLURAL_SUFFIX = "s";
    private static final String CORNER_CASE = "ID";

    @Override
    public String classToTableName(String className) {
        String tableNameInSingularForm = super.classToTableName(className);
        return transformToPluralForm(tableNameInSingularForm);
    }

    private String transformToPluralForm(String tableNameInSingularForm) {
        StringBuilder sb = new StringBuilder();
        sb.append(tableNameInSingularForm).append(PLURAL_SUFFIX);
        return sb.toString();
    }

    @Override
    public String columnName(String columnName) {
        if (columnName.toUpperCase().endsWith(CORNER_CASE)) {
            int lastCharIndex = columnName.length() - 1;
            return firstLetterToUpper(columnName.substring(0, lastCharIndex) +
                    Character.toUpperCase(columnName.charAt(lastCharIndex)));
        }
        return firstLetterToUpper(columnName);
    }

    private String firstLetterToUpper(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
