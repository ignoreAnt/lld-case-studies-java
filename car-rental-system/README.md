
# **Car Rental System Design Problem**

## **System Overview And Objective**

Design a console-based Car Rental System to manage vehicle rentals across multiple city branches. Core tasks include inventory management, availability checks, booking processing, and dynamic pricing. The system operates entirely in-memory, requiring no GUI or user authentication. Prioritize robust error handling, testability, and a flexible, extensible design.

---

## **Core Functional Requirements**

### **Branch And Vehicle Management**

* Add rental branches, each with a unique name and a configurable list of supported vehicle types (e.g., SUV, Sedan).
* Add vehicles (unique ID, type, base hourly price) to a branch, ensuring the branch supports the vehicle type. Vehicles are rented from their assigned branch.

### **Booking, Availability, And Basic Pricing**

* Allow booking of a specific vehicle type from a branch for a given time interval (start and end hour).
* Prioritize the cheapest available vehicle of the requested type for the entire interval. Decline if unavailable.
* Prevent double-booking for overlapping time slots.
* Query and display available vehicles (type, branch, time interval).
* Base rental price: `(endHour - startHour) * vehicle_base_price_per_hour`.

---

## **Advanced System Capabilities (Design Challenges)**

Incorporate these advanced, extensible features:

### **Dynamic Pricing**

* Implement dynamic pricing where rental costs vary based on factors like peak hours, promotions, or customer loyalty.
* Support multiple, easily updatable pricing strategies (e.g., "Peak Hour Pricing," "Weekend Special") selectable at booking.

### **Customizable Rentals (Add-ons)**

* Allow customers to add optional services/equipment (e.g., GPS, Child Seat, Premium Insurance) at an additional cost.
* Total cost must reflect base rental plus add-ons. Ensure easy addition of new add-on types.

### **Event Notifications**

* Implement a notification system (e.g., console logs) for significant events like booking confirmations or cancellations, targeting relevant parties (e.g., branch managers).
* Design for extensibility to new event types and subscribers.

### **Customer Loyalty Program**

* Introduce a loyalty program where customers earn points from rentals, redeemable for discounts or benefits.
* Consider loyalty tiers (e.g., Bronze, Silver, Gold) with varying benefits and adaptable rules for point accrual/redemption.

---

## **Key System Operations And Expected Outputs**

Key operations and sample console outputs (illustrative):

* **Adding a branch**:
    * Input: `addBranch("Downtown", List.of("Sedan", "SUV"))`
    * Output: `SUCCESS: Branch Downtown added.` or `FAILURE: Branch already exists.`
* **Adding a vehicle**:
    * Input: `addVehicle("CAR001", "Sedan", "Downtown", 15.00)`
    * Output: `SUCCESS: Vehicle CAR001 added to Downtown.` or `FAILURE: Branch Downtown does not support Sedan.`
* **Booking a vehicle**:
    * Input: `bookVehicle("Downtown", "Sedan", 10, 12, "CUST001")`
    * Output: `SUCCESS: Vehicle CAR001 booked for $30.00.` or `FAILURE: No Sedan available.`
* **Displaying available vehicles**:
    * Input: `displayAvailableVehicles("Downtown", "Sedan", 9, 17)`
    * Output: `Available Sedans: CAR001 ($15.00/hr), CAR005 ($16.00/hr).` or `No Sedan available.`

---

## **General Constraints**

* Vehicle identifiers must be unique system-wide.
* Booking times must be valid (`startHour < endHour`, 0-23 range).
* Vehicles can only be added to existing, supportive branches.
* Prevent double-bookings.
* Provide clear error messages for invalid operations.
* All data is in-memory (no persistence).
* Console-driven application.
* Emphasize modularity for easy integration of new strategies, add-ons, etc.

---

## **Testing Scenarios To Cover**

Key testing scenarios include:

* **Branch/Vehicle Onboarding**: Successful and failed additions (unsupported type, duplicate ID).
* **Booking/Availability**: Successful booking, unavailability, overlapping booking failures, correct availability queries.
* **Dynamic Pricing**: Verifying price adjustments based on selected strategies.
* **Rental Add-ons**: Verifying the correct total price with add-ons.
* **Loyalty Program**: Verifying discount application and point accrual (conceptually).
* **Notifications**: Simulated verification of event triggering.
* **Error Handling**: Invalid inputs (time intervals, non-existent entities), boundary conditions.
