package com.ignorant.carrentalsystem.platform;

import com.ignorant.carrentalsystem.model.VehicleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRentalPlatformTest {

    private CarRentalPlatform carRentalPlatform;

    @BeforeEach
    void setUp() {
        carRentalPlatform = new CarRentalPlatform();
    }

    @Test
    @DisplayName("Should successfully add a new branch to supported types")
    public void shouldAddBranchSuccessfully(){
        // Arrange
        String branchName = "DownTown";

        List<VehicleType> supportedTypes = List.of(VehicleType.SEDAN, VehicleType.SUV);

        // Act
        String result = carRentalPlatform.addBranch(branchName, supportedTypes);

        // Assert
        assertThat(result).isEqualTo("SUCCESS: Branch " + branchName + " added.");
    }
}
