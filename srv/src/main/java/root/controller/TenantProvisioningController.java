package root.controller;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import root.service.TenantProvisioningService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/callback/v1.0/tenants/{tenantId}")
public class TenantProvisioningController {

    private final TenantProvisioningService tenantProvisioningService;

    @PutMapping
    public String onSubscription(@PathVariable String tenantId, @RequestBody JsonNode requestBody) {

        log.info("Handling subscription callback for tenant: [{}].", tenantId);
        return tenantProvisioningService.subscribe(requestBody, tenantId);
    }

    @DeleteMapping
    public void onDelete(@PathVariable String tenantId) {
        log.info("Handling unsubscription callback for tenant: [{}].", tenantId);
    }
}
