package root.util;

import lombok.experimental.UtilityClass;

import static java.lang.String.format;

@UtilityClass
public class TenantUtil {
    public static String createSchemaName(final String tenantId) {
        return format("tenant_%s", tenantId.replace("-", "_"));
    }
}
