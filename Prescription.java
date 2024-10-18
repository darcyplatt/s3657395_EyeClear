package s3657395_EyeClear;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

public class Prescription {
        private int prescID;
        private String firstName;
        private String lastName;
        private String address;
        private float sphere;
        private float axis;
        private float cylinder;
        private Date examinationDate;
        private String optometrist;
        private String[] remarkTypes = { "Client", "Optometrist" }; //change this to a ENUM
        private ArrayList<String> postRemarks = new ArrayList<>();

        public boolean addPrescription() {
                // TODO Add the prescription's information to a TXT file
                // If the prescription meets the given conditions,
                // the information should be added to a TXT file (e.g., presc.txt), and the
                // function should return true.
                // If the prescription's information does not meet the given conditions,
                // the information should not be added to the TXT file, and the function should
                // return false.

                if(validPrescription()) {
                        generateID();
                        writePrescription(this.prescID, this.firstName, this.lastName, this.address, this.sphere,
                                this.axis, this.cylinder, this.examinationDate, this.optometrist);
                }
                return validPrescription();
        }

        public boolean setName(String firstName, String lastName) {
                if (isValidName(firstName)) {
                        this.firstName = firstName;
                } else {
                        throw new IllegalArgumentException("Invalid first name");
                }
                if (isValidName(lastName)) {
                        this.lastName = lastName;
                } else {
                        throw new IllegalArgumentException("Invalid last name");
                }
                return isValidName(firstName) && isValidName(lastName);
        }

        private boolean isValidName(String name) {
                return name != null && name.length() >= 4 && name.length() <= 15;
        }

        public boolean setAddress(String address) {
                if (address != null && address.length() >= 20) {
                        this.address = address;
                } else {
                        throw new IllegalArgumentException("Invalid address");
                }
                return address != null && address.length() >= 20;
        }

        public boolean setSphere(float sphere) {
                if (sphere >= -20.00f && sphere <= 20.00f) {
                        this.sphere = sphere;
                } else {
                        throw new IllegalArgumentException("Invalid sphere value");
                }
                return sphere >= -20.00f && sphere <= 20.00f;
        }

        public boolean setCylinder(float cylinder) {
                if (cylinder >= -4.00f && cylinder <= 4.00f) {
                        this.cylinder = cylinder;
                } else {
                        throw new IllegalArgumentException("Invalid cylinder value");
                }
                return cylinder >= -4.00f && cylinder <= 4.00f;
        }

        public boolean setAxis(float axis) {
                if (axis >= 0.00f && axis <= 180.00f) {
                        this.axis = axis;
                } else {
                        throw new IllegalArgumentException("Invalid axis value");
                }
                return axis >= 0.00f && axis <= 180.00f;
        }

        public boolean setDate(Date examinationDate) {
                //inspect the Date object for a method to check for correct formatting DD/MM/YY
                this.examinationDate = examinationDate;
                return true;
        }

        public boolean setOptometrist(String optometrist) {
                if(optometrist.length() >= 8 && optometrist.length() <= 25) {
                        this.optometrist = optometrist;
                } else {
                        throw new IllegalArgumentException("Invalid optometrist value");
                }
                return optometrist.length() >= 8 && optometrist.length() <= 25;
        }

        public void generateID() {
                        int id = 1;
                        this.prescID = id;
        }

        private boolean validPrescription() {
                return setName(firstName, lastName) && setAddress(address) && setSphere(sphere) &&
                        setCylinder(cylinder) && setAxis(axis) && setDate(examinationDate) && setOptometrist(optometrist);
        }
        
        private void writePrescription(int prescID, String firstName, String lastName, String address,
                        float sphere, float axis, float cylinder, Date examinationDate, String optometrist) {
                //write data to .TXT file
        }

        public boolean addRemark() {
                // TODO Add the prescription's remark to a TXT file
                // If the remark meets the given conditions,
                // the information should be added to a TXT file (e.g., remark.txt), and the
                // function should return true.
                // If the remark does not meet the given conditions,
                // the information should not be added to the TXT file, and the function should
                // return false.
                return true;
        }

        public boolean validRemarkType(String type) {
                return type.equalsIgnoreCase(remarkTypes[0]) || type.equalsIgnoreCase(remarkTypes[1]);
        }

        public boolean validRemarkText(String text) {
                return Pattern.matches("^[A-Z]\\w*(?:\\s+\\w+){5,19}$", text.trim());
        }

}
