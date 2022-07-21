package com.mobile.service.utils;

import com.mobile.service.entity.Mobile;

import java.util.List;
import java.util.UUID;

public final class MockUtils {

    public static List<Mobile> getMobilesFromMemory =
         List.of(
                Mobile.builder().id(UUID.fromString("2992c4e7-b809-4803-9fef-e8c62a5cc120")).name("Czech mobile").build(),
                Mobile.builder().id(UUID.fromString("d8bc1051-18fd-4c2a-9f53-91626dc21f1d")).name("Slovak mobile").build(),
                Mobile.builder().id(UUID.fromString("319b2336-3b58-4d81-af96-8fed2bc7be33")).name("Serbian mobile").build(),
                Mobile.builder().id(UUID.fromString("793c808d-f93d-4ede-a6da-26ad08e6147f")).name("French mobile").build(),
                Mobile.builder().id(UUID.fromString("dd91bbc8-9eb8-4df8-b7b1-dfbcd41e832b")).name("UK mobile").build(),
                Mobile.builder().id(UUID.fromString("59638dbb-07fc-4f9d-a323-42adf4935c36")).name("Austria mobile").build()
        );
}
