package dev.practice.order.domain.partner;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PartnerInfo {

    private Long id;
    private String token;
    private String name;
    private String businessNo;
    private String email;
    private Partner.Status status;

    public PartnerInfo(Partner partner) {
        this.id = partner.getId();
        this.token = partner.getToken();
        this.name = partner.getName();
        this.businessNo = partner.getBusinessNo();
        this.email = partner.getEmail();
        this.status = partner.getStatus();
    }
}
