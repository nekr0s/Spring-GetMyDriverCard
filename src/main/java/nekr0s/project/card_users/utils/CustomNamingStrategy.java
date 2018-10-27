package nekr0s.project.card_users.utils;

import org.hibernate.cfg.ImprovedNamingStrategy;

public class CustomNamingStrategy extends ImprovedNamingStrategy {
    private static final String PLURAL_SUFFIX = "s";

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
}
