package com.mobile.service.mock;

import com.mobile.service.dto.UpdateMobileDto;
import com.mobile.service.entity.Mobile;

import java.util.Set;
import java.util.UUID;

public final class MobileGenerator {

    public static Set<String> getAllMobileNamesSortedProperly() {
        return Set.of("Austria mobile", "Czech mobile", "French mobile", "Serbian mobile", "Slovak mobile", "UK mobile");
    }

    public static UpdateMobileDto updateMobileDto() {
        return UpdateMobileDto.builder().name("Austria mobile").build();
    }

    public static UpdateMobileDto updateMobileDtoUpperCase() {
        return UpdateMobileDto.builder().name("AUSTRIA mobile").build();
    }

    public static UpdateMobileDto updateMobile() {
        return UpdateMobileDto.builder().name("Belgian mobile").build();
    }

    public static Mobile updatedMobile() {
        return Mobile.builder()
                .id(UUID.fromString("dd91bbc8-9eb8-4df8-b7b1-dfbcd41e832b"))
                .name("Belgian mobile")
                .build();
    }

    public static Set<String> getAllMobileNamesSortedProperlyAfterUpdateOperation() {
        return Set.of("Austria mobile", "Belgian mobile", "Czech mobile", "French mobile", "Serbian mobile", "Slovak mobile");
    }
}
