package root.service;


import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class TenantProvisioningService {

    private static final String URL_PATTERN = "https://%s-marketplace.cfapps.us10-001.hana.ondemand.com";
    private static final String SUBSCRIBED_SUBDOMAIN_JSON_FIELD = "subscribedSubdomain";

    private final TenantProvisioningSchemaInitializr tenantProvisioningSchemaInitializr;

    public String subscribe(JsonNode requestBody, String tenantId) {
        tenantProvisioningSchemaInitializr.initializeSchemaForTenant(tenantId);
        return buildTenantSubscriptionUrl(requestBody);
    }

    private String buildTenantSubscriptionUrl(JsonNode requestBody) {
        String tenantSubdomain = requestBody.get(SUBSCRIBED_SUBDOMAIN_JSON_FIELD).asText();
        return format(URL_PATTERN, tenantSubdomain);
    }
}

