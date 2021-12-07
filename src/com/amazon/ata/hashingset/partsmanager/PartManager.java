package com.amazon.ata.hashingset.partsmanager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartManager {
    // instantiate a HashSet of DeviceParts to keep track of what parts we are currently using

    private Set<DevicePart> deviceParts = new HashSet<>();

    // Use the Hash Code to determine the index of an element in an array
    //Since Hashcode collisions might occue we will store the elements in an arraylist in the array
    //      rather than storing the individual elements in the array
    // Determine max size - 10


    private final int numParts = 10;

    // Define an array of ArrayList<DevicePart> - each element will be an ArrayList of Device Parts objects
    private List<DevicePart>[] parts = new ArrayList[numParts];

    public void addDevicePart(DevicePart devicePart) {
        // Use the HashSet .add() to add the parts passsed to use ot the deviceParts hashSet
        //      .add automatically calls the hashCode() method to determine the hash code
        //      .add sometimes also call the .equls() method when there is a hash code collision
        boolean isAdded = deviceParts.add(devicePart);
        // To add an element to the array :
        //  1. Find the Hash Code of an object
        //  2. Calculate the index of the array using the hash code

        //Usr the MAth.abs() to be sure the Index is not negative

        int partIndex = Math.abs(devicePart.hashCode() % numParts);

        //  3. Store the objects in hte array of index determined
        //  do we already have an object at this index? (Hash code Collision has occcured)
        if (parts[partIndex] != null) {
            parts[partIndex].add(devicePart);      // yes - add the object to the arrayList
        } else {
            parts[partIndex] = new ArrayList<>();   // no - instantiate an array list in the element and add the object
            parts[partIndex].add(devicePart);
        }
        return;     //not required for the method - it's added so we can stop the debugger here
    }

    /**
     * Will find and return an object in our Array of Objects or null if it's not found
     */
    public DevicePart findPart(DevicePart requestedDevicePart) {
        // Instantiate an object to be returned initialized it to null
        DevicePart returnedObject =  null;

        // Use the Hash code for the requested objct to determine its index in the array
        int partIndex = Math.abs(requestedDevicePart.hashCode() % numParts);

        // check to see if the element in the array for the index has an ArrayList() (if not, not objects)
        if (parts[partIndex] != null) {    // If there is an ArryaList in the element, search if for the requested object
            if (parts[partIndex].contains(requestedDevicePart)) { // if we find the requested object
                   returnedObject = parts[partIndex].get(parts[partIndex].indexOf(requestedDevicePart)); // set the returned object to it
            } else {
                returnedObject = null; // if we don't find the object in the ArrayList, set returned object to null
                // this is not required since returnedObject is initialized to null and only changes when we found the object
            }
        }


        // return the found object



        return returnedObject;
    }


    public void printDeviceParts() {
        for (DevicePart devicePart: deviceParts) {
            System.out.println(devicePart);
        }
    }
}
