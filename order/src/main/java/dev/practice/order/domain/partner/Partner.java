package dev.practice.order.domain.partner;

import dev.practice.order.common.util.TokenGenerator;
import dev.practice.order.domain.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "partners")
public class Partner extends AbstractEntity {

    private static final String PREFIX_PARTNER = "ptn_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private String name;
    private String businessNo;
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    public Partner(String name, String businessNo, String email) {
        if (StringUtils.isEmpty(name)) throw new RuntimeException("empty partnerName");
        if (StringUtils.isEmpty(businessNo)) throw new RuntimeException("empty businessNo");
        if (StringUtils.isEmpty(email)) throw new RuntimeException("empty email");

        this.token = TokenGenerator.randomCharacterWithPrefix(PREFIX_PARTNER);
        this.name = name;
        this.businessNo = businessNo;
        this.email = email;
        this.status = Status.ENABLE;
    }

    public void enable() {
        this.status = Status.ENABLE;
    }

    public void disable() {
        this.status = Status.DISABLE;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ENABLE("활성화"), DISABLE("비활성화");

        private final String description;
    }
}
