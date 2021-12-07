package com.amazon.ata.hashingset.partsmanager;

import java.util.List;
import java.util.Objects;

public class DevicePart {
    //immutable - value cannot be changed once it is assigned (no setter is assigned)
    // mutable - value may be changed (using setter)
    private String manufacturer;            //read only non-changeable value (immutable)
    private String manufacturersPartNumber;
    private List<AmazonDevice> devicesUsedIn;

    public DevicePart(String manufacturer, String manufacturersPartNumber, List<AmazonDevice> devicesUsedIn) {
        this.manufacturer = manufacturer;
        this.manufacturersPartNumber = manufacturersPartNumber;
        this.devicesUsedIn = devicesUsedIn;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getManufacturersPartNumber() {
        return manufacturersPartNumber;
    }

    public List<AmazonDevice> getDevicesUsedIn() {
        return devicesUsedIn;
    }

    public void setDevicesUsedIn(List<AmazonDevice> devicesUsedIn) {
        this.devicesUsedIn = devicesUsedIn;
    }

    public void addDeviceUsedIn(AmazonDevice amazonDevice) {
        devicesUsedIn.add(amazonDevice);
    }

    public void removeDeviceUsedIn(AmazonDevice amazonDevice) {
        devicesUsedIn.remove(amazonDevice);
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Device Part equals().....");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DevicePart that = (DevicePart) o;
        return getManufacturer().equals(that.getManufacturer()) && getManufacturersPartNumber().equals(that.getManufacturersPartNumber());
    }

    @Override
    public int hashCode() {
        System.out.println("DevicePart hashcode().....");
        return Objects.hash(getManufacturer(), getManufacturersPartNumber());
    }

    @Override
    public String toString() {
        return String.format("Device Part: {manufacturer: %s, manufacturersPartNumber: %s, devicesUsedIn: %s}",
                manufacturer, manufacturersPartNumber, devicesUsedIn);
    }
}
