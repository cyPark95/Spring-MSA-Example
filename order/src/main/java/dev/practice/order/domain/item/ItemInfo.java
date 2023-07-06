package dev.practice.order.domain.item;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class ItemInfo {

    @Getter
    @ToString
    public static class Main {

        private final String itemToken;
        private final Long partnerId;
        private final String itemName;
        private final Long itemPrice;
        private final Item.Status status;
        private final List<ItemOptionGroupInfo> itemOptionGroups;

        @Builder
        public Main(Item item, List<ItemOptionGroupInfo> itemOptionGroupInfos) {
            this.itemToken = item.getItemToken();
            this.partnerId = item.getPartnerId();
            this.itemName = item.getItemName();
            this.itemPrice = item.getItemPrice();
            this.status = item.getStatus();
            this.itemOptionGroups = itemOptionGroupInfos;
        }
    }

    @Getter
    @ToString
    public static class ItemOptionGroupInfo {
        private final Integer ordering;
        private final String itemOptionGroupName;
        private final List<ItemOptionInfo> itemOptions;

        public ItemOptionGroupInfo(dev.practice.order.domain.item.optiongroup.ItemOptionGroup itemOptionGroup, List<ItemOptionInfo> itemOptions) {
            this.ordering = itemOptionGroup.getOrdering();
            this.itemOptionGroupName = itemOptionGroup.getItemOptionGroupName();
            this.itemOptions = itemOptions;
        }
    }

    @Getter
    @ToString
    public static class ItemOptionInfo {
        private final Integer ordering;
        private final String itemOptionName;
        private final Long itemOptionPrice;

        public ItemOptionInfo(dev.practice.order.domain.item.option.ItemOption itemOption) {
            this.ordering = itemOption.getOrdering();
            this.itemOptionName = itemOption.getItemOptionName();
            this.itemOptionPrice = itemOption.getItemOptionPrice();
        }
    }
}
