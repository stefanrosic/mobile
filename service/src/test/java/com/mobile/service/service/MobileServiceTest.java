package com.mobile.service.service;

import static org.junit.jupiter.api.Assertions.*;

import com.mobile.service.entity.Mobile;
import com.mobile.service.exception.MobileAlreadyExistsException;
import com.mobile.service.exception.MobileNotFoundException;
import com.mobile.service.mock.MobileGenerator;
import com.mobile.service.service.impl.MobileService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Collectors;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class MobileServiceTest {

    @InjectMocks
    private MobileService mobileService;

    @Order(1)
    @Test
    void getAll_shouldReturnAllSixRecordsProperly() {
        final var expected = 6;
        final var actual = mobileService.getAll().size();

        assertEquals(expected, actual);
    }

    @Order(2)
    @Test
    void getAll_shouldSortRecordsByNameProperly() {
        final var expected = MobileGenerator.getAllMobileNamesSortedProperly();
        final var actual = mobileService.getAll()
                .stream()
                .map(Mobile::getName)
                .collect(Collectors.toUnmodifiableSet());

        assertEquals(expected, actual);
    }

    @Order(3)
    @Test
    void update_shouldThrowMobileNotFoundException_whenMobileWithIdDoesNotExist() {
        final var updateMobileDto = MobileGenerator.updateMobileDto();

        assertThrows(MobileNotFoundException.class, () -> {
            mobileService.update("someRandomId", updateMobileDto);
        });
    }

    @Order(4)
    @Test
    void update_shouldThrowMobileAlreadyExistsException_whenMobileWithNameAlreadyExists() {
        final var updateMobileDto = MobileGenerator.updateMobileDto();

        assertThrows(MobileAlreadyExistsException.class, () -> {
            mobileService.update("59638dbb-07fc-4f9d-a323-42adf4935c36", updateMobileDto);
        });
    }

    @Order(5)
    @Test
    void update_shouldThrowMobileAlreadyExistsException_whenMobileWithNameAlreadyExistsIgnoreCase() {
        final var updateMobileDtoUpperCase = MobileGenerator.updateMobileDtoUpperCase();

        assertThrows(MobileAlreadyExistsException.class, () -> {
            mobileService.update("59638dbb-07fc-4f9d-a323-42adf4935c36", updateMobileDtoUpperCase);
        });
    }

    @Order(6)
    @Test
    void update_shouldUpdateAndReturnUpdatedRecord() {
        final var expected = MobileGenerator.updatedMobile();
        final var updateMobile = MobileGenerator.updateMobile();

        final var actual = mobileService.update("dd91bbc8-9eb8-4df8-b7b1-dfbcd41e832b", updateMobile);
        assertEquals(expected, actual);
    }

    @Order(7)
    @Test
    void getAll_shouldReturnAllRecordsReorderedAfterUpdate() {
        final var expected = MobileGenerator.getAllMobileNamesSortedProperlyAfterUpdateOperation();
        final var actual = mobileService.getAll()
                .stream()
                .map(Mobile::getName)
                .collect(Collectors.toUnmodifiableSet());

        assertEquals(expected, actual);
    }
}
