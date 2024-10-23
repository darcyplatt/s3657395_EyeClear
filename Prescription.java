package s3657395_EyeClear;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Prescription {
        private static final HashSet<String> usedIDs = new HashSet<>(); // Static collection to track all used ID
        private String prescID;
        private String firstName;
        private String lastName;
        private String address;
        private float sphere;
        private float axis;
        private float cylinder;
        private String examinationDate;
        private String optometrist;
        private String[] remarkTypes = { "Client", "Optometrist" }; // change this to a ENUM
        private ArrayList<String> postRemarks = new ArrayList<>();

        Prescription() {
                this.prescID = "000";
                this.firstName = "";
                this.lastName = "";
                this.address = "";
                this.sphere = -99f;
                this.axis = -99f;
                this.cylinder = -99f;
                this.examinationDate = "";
                this.optometrist = "";
        }

        public boolean addPrescription() {
                // TODO Add the prescription's information to a TXT file
                // If the prescription meets the given conditions,
                // the information should be added to a TXT file (e.g., presc.txt), and the
                // function should return true.
                // If the prescription's information does not meet the given conditions,
                // the information should not be added to the TXT file, and the function should
                // return false.

                Scanner scanner = new Scanner(System.in);
                setFirstName(scanner.nextLine());
                setLastName(scanner.nextLine());
                setAddress(scanner.nextLine());
                setSphere(scanner.nextFloat());
                setAxis(scanner.nextFloat());
                setCylinder(scanner.nextFloat());
                setDate(scanner.nextLine());
                scanner.close();

                if (validPrescription()) {
                        generateID();
                        writePrescription();
                } else {
                        throw new IllegalArgumentException("Invalid prescription values");
                }
                return validPrescription();
        }

        private boolean setFirstName(String firstName) {
                if (firstName != null && firstName.length() >= 4 && firstName.length() <= 15) {
                        this.firstName = firstName;
                }
                return firstName != null && firstName.length() >= 4 && firstName.length() <= 15;
        }

        private boolean setLastName(String lastName) {
                if (lastName != null && lastName.length() >= 4 && lastName.length() <= 15) {
                        this.lastName = lastName;
                }
                return lastName != null && lastName.length() >= 4 && lastName.length() <= 15;
        }

        private boolean setAddress(String address) {
                if (address != null && address.length() >= 20) {
                        this.address = address;
                }
                return address != null && address.length() >= 20;
        }

        private boolean setSphere(float sphere) {
                if (sphere >= -20.00f && sphere <= 20.00f) {
                        this.sphere = sphere;
                }
                return sphere >= -20.00f && sphere <= 20.00f;
        }

        private boolean setCylinder(float cylinder) {
                if (cylinder >= -4.00f && cylinder <= 4.00f) {
                        this.cylinder = cylinder;
                }
                return cylinder >= -4.00f && cylinder <= 4.00f;
        }

        private boolean setAxis(float axis) {
                if (axis >= 0.00f && axis <= 180.00f) {
                        this.axis = axis;
                }
                return axis >= 0.00f && axis <= 180.00f;
        }

        private boolean setDate(String examinationDate) {
                try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
                        LocalDate date = LocalDate.parse(examinationDate, formatter);

                        String formattedDate = date.format(formatter);
                        this.examinationDate = formattedDate;
                        return true;

                } catch (DateTimeParseException e) {
                        return false;
                }
        }

        private boolean setOptometrist(String optometrist) {
                if (optometrist.length() >= 8 && optometrist.length() <= 25) {
                        this.optometrist = optometrist;
                }
                return optometrist.length() >= 8 && optometrist.length() <= 25;
        }

        private void generateID() {
                String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                Random random = new Random();
                StringBuilder newID;
                do {
                        newID = new StringBuilder();
                        // Generate a 6-character string
                        for (int i = 0; i < 6; i++) {
                                int index = random.nextInt(characters.length());
                                newID.append(characters.charAt(index));
                        }
                } while (!usedIDs.add(newID.toString())); // Keep generating until we get a unique ID

                this.prescID = newID.toString();
        }

        private boolean validPrescription() {
                return setFirstName(this.firstName) && setLastName(this.lastName) && setAddress(this.address)
                                && setSphere(this.sphere) && setCylinder(this.cylinder) && setAxis(this.axis)
                                && setDate(this.examinationDate) && setOptometrist(this.optometrist);
        }

        private void writePrescription() {
                // write data to .TXT file
        }

        public boolean addRemark() {
                // TODO Add the prescription's remark to a TXT file
                // If the remark meets the given conditions,
                // the information should be added to a TXT file (e.g., remark.txt), and the
                // function should return true.
                // If the remark does not meet the given conditions,
                // the information should not be added to the TXT file, and the function should
                // return false.

                Scanner scanner = new Scanner(System.in);
                String type = scanner.nextLine();
                String text = scanner.nextLine();
                scanner.close();

                if (validRemarkType(type) && validRemarkText(text) && postRemarks.size() < 2) {
                        String remark = type + " - " + text;
                        postRemarks.add(remark);
                }

                return validRemarkType(type) && validRemarkText(text) && postRemarks.size() <= 2;
        }

        private boolean validRemarkType(String type) {
                return type.equalsIgnoreCase(remarkTypes[0]) || type.equalsIgnoreCase(remarkTypes[1]);
        }

        private boolean validRemarkText(String text) {
                return Pattern.matches("^[A-Z]\\w*(?:\\s+\\w+){5,19}$", text.trim());
        }

        private void writeRemark() {

        }

}
