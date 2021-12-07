package com.amazon.ata.hashingset.partsmanager;

import java.util.Arrays;

public class U3S2M1ApplicationTestProgram {

        public static void main(String[] args) {

                System.out.print("-".repeat(50) + "\nDefining flex part...");
                DevicePart flex = new DevicePart("Knowles", "KAS-700-0147",
                        Arrays.asList(AmazonDevice.FIRE_TV_STICK, AmazonDevice.FIRE_TV_STICK_4K, AmazonDevice.ECHO_BUDS));
                System.out.println(flex.hashCode()); // 118352462

                System.out.print("-".repeat(50) + "\nDefining button part...");
                DevicePart button = new DevicePart("CUI Devices", "CMEJ-04150420P",
                        Arrays.asList(AmazonDevice.ECHO_PLUS));
                System.out.println(button.hashCode()); // 865113938

                System.out.print("-".repeat(50) + "\nDefining omnidirectional part...");
                DevicePart omnidirectional = new DevicePart("Knowles", "FG-23329-P142",
                        Arrays.asList(AmazonDevice.ECHO_PLUS));
                System.out.println(omnidirectional.hashCode()); // 1442407170

                System.out.print("-".repeat(50) + "\nDefining noiseCancelling part...");
                DevicePart noiseCancelling = new DevicePart("Knowles", "FB-EM-30342-000",
                        Arrays.asList(AmazonDevice.ECHO_BUDS));
                System.out.println(noiseCancelling.hashCode()); // 1975012498

                System.out.print("-".repeat(50) + "\nDefining cuiDevice part...");
                DevicePart cuiDevice = new DevicePart("CUI Devices", "CMEJ-04150420P",
                        Arrays.asList(AmazonDevice.ECHO_PLUS));
                System.out.println(cuiDevice.hashCode()); // 865113938

                System.out.print("-".repeat(50) + "\nDefining Wired part...");
                DevicePart wired = new DevicePart("Knowles", "VFG-30747-000",
                        Arrays.asList(AmazonDevice.FIRE_7_KIDS_EDITION, AmazonDevice.FIRE_HD_8_KIDS_EDITION, AmazonDevice.FIRE_HD_10_KIDS_EDITION));
                System.out.println(wired.hashCode()); // 118352462

                System.out.print("-".repeat(50) + "\nDefining cord part...");
                DevicePart cord = new DevicePart("CUI Devices", "CMEJ-4622-25-L082",
                        Arrays.asList(AmazonDevice.ECHO));
                System.out.print(cord.hashCode()); // 1550089733

                System.out.print("-".repeat(50) + "\nDefining grounded part...");
                DevicePart grounded = new DevicePart("Knowles", "EK-26899-P03",
                        Arrays.asList(AmazonDevice.ECHO_FRAMES));
                System.out.println(grounded.hashCode()); // 1118140812

                System.out.print("-".repeat(50) + "\nDefining puiAudio part...");
                DevicePart puiAudio = new DevicePart("PUI Audio", "AMM-2738B-R",
                        Arrays.asList(AmazonDevice.ECHO_DOT, AmazonDevice.ECHO_SHOW_5, AmazonDevice.ECHO_SHOW_8));
                System.out.println(puiAudio.hashCode()); // 1311053138

                PartManager microphonePartManager = new PartManager();

                System.out.println("-".repeat(50) + "\nadding flex part to HashSet in PartManager...");
                microphonePartManager.addDevicePart(flex);

                System.out.println("-".repeat(50) + "\nadding button part to HashSet in PartManager...");
                microphonePartManager.addDevicePart(button);

                System.out.println("-".repeat(50) + "\nadding omnidirectional part to HashSet in PartManager...");
                microphonePartManager.addDevicePart(omnidirectional);

                System.out.println("-".repeat(50) + "\nadding noiseCancelling part to HashSet in PartManager...");
                microphonePartManager.addDevicePart(noiseCancelling);

                System.out.println("-".repeat(50) + "\nadding cuiDevice part to HashSet in PartManager...");
                microphonePartManager.addDevicePart(cuiDevice);

                System.out.println("-".repeat(50) + "\nadding wired part to HashSet in PartManager...");
                microphonePartManager.addDevicePart(wired);

                // test our find an object method
                System.out.println("Looking for the : " + button);
                DevicePart foundObject = microphonePartManager.findPart(button);
                System.out.println("found : " + foundObject);

                // instatiate an object that we have not added to the arraylist
                System.out.println("Looking for the : " + button);
                DevicePart testPart = new DevicePart("test", "123-456",
                        Arrays.asList(AmazonDevice.ECHO_BUDS));
                foundObject = microphonePartManager.findPart(testPart);
                System.out.println("found : " + foundObject);


                return;
        }
}
