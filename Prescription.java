package s3657395_EyeClear;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Prescription {
        private String prescID;
        private String firstName;
        private String lastName;
        private String address;
        private float sphere;
        private float axis;
        private float cylinder;
        private String examinationDate;
        private String optometrist;
        private String[] remarkTypes = { "Client", "Optometrist" };
        private ArrayList<String> postRemarks = new ArrayList<>();
        private static final HashSet<String> usedIDs = new HashSet<>();

        // default constructor to initialize values that don't pass condition checks
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

        // method called to set all relevant fields of prescription data and then write
        // them to a TXT file
        public boolean addPrescription(String firstName, String lastName, String address, float sphere, float axis,
                        float cylinder, String examinationDate, String optometrist) {
                // If the prescription meets the given conditions,
                // the information should be added to a TXT file (e.g., presc.txt), and the
                // function should return true.
                // If the prescription's information does not meet the given conditions,
                // the information should not be added to the TXT file, and the function should
                // return false.

                setFirstName(firstName);
                setLastName(lastName);
                setAddress(address);
                setSphere(sphere);
                setAxis(axis);
                setCylinder(cylinder);
                setDate(examinationDate);
                setOptometrist(optometrist);

                // if all the setter methods return true and fields have been set correctly then
                // a unique prescID
                // will be created andn the fields will be written to a .txt file
                if (validPrescription()) {
                        generateID();
                        writePrescription();
                        return true;
                } else {
                        return false;
                        //throw new IllegalArgumentException("Invalid prescription values");
                }
                //return validPrescription();
        }

        // checks if passed in firstName is has a minimum of 4 characters and a maximum
        // of 15 characters
        private boolean setFirstName(String firstName) {
                if (firstName != null && firstName.length() >= 4 && firstName.length() <= 15) {
                        this.firstName = firstName;
                }
                return firstName != null && firstName.length() >= 4 && firstName.length() <= 15;
        }

        // checks if passed in lastName is has a minimum of 4 characters and a maximum
        // of 15 characters
        private boolean setLastName(String lastName) {
                if (lastName != null && lastName.length() >= 4 && lastName.length() <= 15) {
                        this.lastName = lastName;
                }
                return lastName != null && lastName.length() >= 4 && lastName.length() <= 15;
        }

        // checks if the passed in address has a minimum of 20 characters
        // (considering the street address, suburb, postcode, and country).
        private boolean setAddress(String address) {
                if (address != null && address.length() >= 20) {
                        this.address = address;
                }
                return address != null && address.length() >= 20;
        }

        // checks if passed in spherical correction value ranges between -20.00 and
        // +20.00
        private boolean setSphere(float sphere) {
                if (sphere >= -20.00f && sphere <= 20.00f) {
                        this.sphere = sphere;
                }
                return sphere >= -20.00f && sphere <= 20.00f;
        }

        // checks if the cylinder value is between -4.00 to +4.00
        private boolean setCylinder(float cylinder) {
                if (cylinder >= -4.00f && cylinder <= 4.00f) {
                        this.cylinder = cylinder;
                }
                return cylinder >= -4.00f && cylinder <= 4.00f;
        }

        // checks if the axis value ranges between 0 and 180
        private boolean setAxis(float axis) {
                if (axis >= 0.00f && axis <= 180.00f) {
                        this.axis = axis;
                }
                return axis >= 0.00f && axis <= 180.00f;
        }

        // takes a passed in string and checks to see if it formatted as DD/MM//YY
        // if formatted correctly the date will be converted from a LocalDate object to
        // a string to be stored
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

        // checks to see if the passed in optometrist name has a minimum of 8 and
        // maximum of 25 characters
        private boolean setOptometrist(String optometrist) {
                if (optometrist.length() >= 8 && optometrist.length() <= 25) {
                        this.optometrist = optometrist;
                }
                return optometrist.length() >= 8 && optometrist.length() <= 25;
        }

        // generates a random 6 character string, checks the HashSet usedIDs if the
        // generated string matches an already used ID, if it does not it sets it to
        // prescID
        private void generateID() {
                String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
                Random random = new Random();
                StringBuilder newID;
                do {
                        newID = new StringBuilder();
                        for (int i = 0; i < 6; i++) {
                                int index = random.nextInt(characters.length());
                                newID.append(characters.charAt(index));
                        }
                } while (!usedIDs.add(newID.toString())); // Keep generating until we get a unique ID

                this.prescID = newID.toString();
        }

        // checks if all boolean methods for setting fields for prescription resolve to
        // true, returns false otherwise
        private boolean validPrescription() {
                return setFirstName(this.firstName) && setLastName(this.lastName) && setAddress(this.address)
                                && setSphere(this.sphere) && setCylinder(this.cylinder) && setAxis(this.axis)
                                && setDate(this.examinationDate) && setOptometrist(this.optometrist);
        }

        // writes all the fields for prescription to the file prescription.txt
        private void writePrescription() {
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("prescription.txt"))) {
                        bufferedWriter.write("Prescription ID: " + this.prescID);
                        bufferedWriter.newLine();
                        bufferedWriter.write("Patient Name: " + this.firstName + " " + this.lastName);
                        bufferedWriter.newLine();
                        bufferedWriter.write("Address: " + this.address);
                        bufferedWriter.newLine();
                        bufferedWriter.write("Sphere: " + String.format("%.2f", this.sphere));
                        bufferedWriter.newLine();
                        bufferedWriter.write("Axis: " + String.format("%.2f", this.axis));
                        bufferedWriter.newLine();
                        bufferedWriter.write("Cylinder: " + String.format("%.2f", this.cylinder));
                        bufferedWriter.newLine();
                        bufferedWriter.write("Examination Date: " + this.examinationDate);
                        bufferedWriter.newLine();
                        bufferedWriter.write("Optometrist: " + this.optometrist);
                } catch (IOException e) {
                        System.out.println("Error writing file.");
                        e.printStackTrace();
                }
        }

        // method called to add a remark by either a Client or Optometrist to a TXT file
        public boolean addRemark(String type, String text) {
                // If the remark meets the given conditions,
                // the information should be added to a TXT file (e.g., remark.txt), and the
                // function should return true.
                // If the remark does not meet the given conditions,
                // the information should not be added to the TXT file, and the function should
                // return false.

                // checks if the validRemarkType(type) and validRemarkText(text) resolve to true
                // and the size of the array list postRemark is not already 2
                if (validRemarkType(type) && validRemarkText(text) && postRemarks.size() < 2) {
                        String remark = type + " - " + text;
                        postRemarks.add(remark);
                        writeRemark();
                        return true;
                } else {
                        return false;
                }
        }

        // checks if the passed in string matches either "Client" or "Optometrist"
        // ignoring case
        private boolean validRemarkType(String type) {
                return type.equalsIgnoreCase(remarkTypes[0]) || type.equalsIgnoreCase(remarkTypes[1]);
        }

        // checks if the remark text should has minimum of 6 words and a maximum of 20
        // words. also checks if the first character of the first word is uppercase
        private boolean validRemarkText(String text) {
                String[] words = text.trim().split("\\s+");
                return words.length >= 6 && words.length <= 20 &&
                                Character.isUpperCase(words[0].charAt(0));
        }

        // write the arraylist of remarks to the a .txt file
        private void writeRemark() {
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("remarks.txt"))) {
                        for (String remark : postRemarks) {
                                bufferedWriter.write(remark);
                                bufferedWriter.newLine();
                        }
                } catch (IOException e) {
                        System.out.println("Error writing file");
                        e.printStackTrace();
                }
        }

}
