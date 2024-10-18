package s3657395_EyeClear;

import java.util.ArrayList;
import java.util.Date;

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
        private String[] remarkTypes = { "Client", "Optometrist" };
        private ArrayList<String> postRemarks = new ArrayList<>();

        public boolean addPrescription() {
                // TODO Add the prescription's information to a TXT file
                // If the prescription meets the given conditions,
                // the information should be added to a TXT file (e.g., presc.txt), and the
                // function should return true.
                // If the prescription's information does not meet the given conditions,
                // the information should not be added to the TXT file, and the function should
                // return false.
                return true;
        }

        public void setName(String firstName, String lastName) {
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
        }

        private boolean isValidName(String name) {
                return name != null && name.length() >= 4 && name.length() <= 15;
        }

        public void setAddress(String address) {
                if (address != null && address.length() >= 20) {
                        this.address = address;
                } else {
                        throw new IllegalArgumentException("Invalid address");
                }
        }

        public void setSphere(float sphere) {
                if (sphere >= -20.00f && sphere <= 20.00f) {
                        this.sphere = sphere;
                } else {
                        throw new IllegalArgumentException("Invalid sphere value");
                }
        }

        public void setCylinder(float cylinder) {
                if (cylinder >= -4.00f && cylinder <= 4.00f) {
                        this.cylinder = cylinder;
                } else {
                        throw new IllegalArgumentException("Invalid cylinder value");
                }
        }

        public void setAxis(float axis) {
                if (axis >= 0.00f && axis <= 180.00f) {
                        this.axis = axis;
                } else {
                        throw new IllegalArgumentException("Invalid axis value");
                }
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

}
