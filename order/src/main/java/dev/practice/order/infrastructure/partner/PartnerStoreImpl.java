package dev.practice.order.infrastructure.partner;

import dev.practice.order.common.exception.InvalidParamException;
import dev.practice.order.domain.partner.Partner;
import dev.practice.order.domain.partner.PartnerStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerStoreImpl implements PartnerStore {

    private final PartnerRepository partnerRepository;

    @Override
    public Partner store(Partner partner) {
        if (StringUtils.isEmpty(partner.getToken())) throw new RuntimeException();
        if (StringUtils.isEmpty(partner.getName())) throw new RuntimeException();
        if (StringUtils.isEmpty(partner.getBusinessNo())) throw new RuntimeException();
        if (StringUtils.isEmpty(partner.getEmail())) throw new RuntimeException();
        if (partner.getStatus() == null) throw new RuntimeException();

        return partnerRepository.save(partner);
    }
}