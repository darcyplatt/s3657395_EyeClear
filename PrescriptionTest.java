package s3657395_EyeClear;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrescriptionTest {
    Prescription prescription = new Prescription();

    @Test
    void validFirstName_testcase1() {
        boolean result = prescription.addPrescription("Darcy", "Platt",
                "3 Mountfield Street, Brunswick, 3056, VIC, Australia", 2.50f,
                1.25f, 0.75f, "15/06/24", "Dr. Michelle Nadine");

        assertEquals(true, result, "addPrescription should return true for valid input");
    }

    @Test
    void validFirstName_testcase2() {
        boolean result = prescription.addPrescription("Z", "Platt",
                "3 Mountfield Street, Brunswick, 3056, VIC, Australia", 2.50f,
                1.25f, 0.75f, "15/06/24", "Dr. Michelle Nadine");

        assertEquals(false, result, "addPrescription should return false for invalid input");
    }

    @Test
    void validLastName_testcase1() {
        boolean result = prescription.addPrescription("Jasper", "Nguyen",
                "42 Lygon Street, Carlton, 3053, VIC, Australia", 2.50f,
                1.25f, 0.75f, "15/06/24", "Dr. Olivia Chen");

        assertEquals(true, result, "addPrescription should return true for valid input");
    }

    @Test
    void validLastName_testcase2() {
        boolean result = prescription.addPrescription("Jasper", "Nguyennnnnnnnnnnnnn",
                "42 Lygon Street, Carlton, 3053, VIC, Australia", 2.50f,
                1.25f, 0.75f, "15/06/24", "Dr. Olivia Chen");

        assertEquals(false, result, "addPrescription should return false for invalid input");
    }

    @Test
    void validAddress_testcase1() {
        boolean result = prescription.addPrescription("Zara", "O'Connor",
                "15 Flinders Lane, Melbourne, 3000, VIC, Australia", 2.50f,
                1.25f, 0.75f, "15/06/24", "Dr. Liam Patel");

        assertEquals(true, result, "addPrescription should return true for valid input");
    }

    @Test
    void validAddress_testcase2() {
        boolean result = prescription.addPrescription("Zara", "O'Connor",
                "15 Flinders Ln", 2.50f, 1.25f, 0.75f,
                "15/06/24", "Dr. Liam Patel");

        assertEquals(false, result, "addPrescription should return false for invalid input");
    }

    @Test
    void validSphere_testcase1() {
        boolean result = prescription.addPrescription("Ethan", "Kowalski",
                "78 Chapel Street, South Yarra, 3141, VIC, Australia", 2.50f, 1.25f, 0.75f,
                "15/06/24", "Dr. Sophia Rodriguez");

        assertEquals(true, result, "addPrescription should return true for valid input");
    }

    @Test
    void validSphere_testcase2() {
        boolean result = prescription.addPrescription("Ethan", "Kowalski",
                "78 Chapel Street, South Yarra, 3141, VIC, Australia", 25.00f, 1.25f, 0.75f,
                "15/06/24", "Dr. Sophia Rodriguez");

        assertEquals(false, result, "addPrescription should return false for invalid input");
    }

    @Test
    void validDateFormat_testcase1() {
        boolean result = prescription.addPrescription("Indi", "Kaye",
                "22 Acland Street, St Kilda, 3182, VIC, Australia", 2.50f, 1.25f, 0.75f,
                "15/06/24", "Dr. Aiden Chowdhury");

        assertEquals(true, result, "addPrescription should return true for valid input");
    }

    @Test
    void validDateFormat_testcase2() {
        boolean result = prescription.addPrescription("Indi", "Kaye",
                "22 Acland Street, St Kilda, 3182, VIC, Australia", 2.50f, 1.25f, 0.75f,
                "2024-06-15", "Dr. Aiden Chowdhury");

        assertEquals(false, result, "addPrescription should return false for invalid input");
    }

    @Test
    void validOptometrist_testcase1() {
        boolean result = prescription.addPrescription("Lachlan", "Sharma",
                "5 Brunswick Street, Fitzroy, 3065, VIC, Australia", 2.50f, 1.25f, 0.75f,
                "15/06/24", "Dr. Isabella Thompson");

        assertEquals(true, result, "addPrescription should return true for valid input");
    }

    @Test
    void validOptometrist_testcase2() {
        boolean result = prescription.addPrescription("Lachlan", "Sharma",
                "5 Brunswick Street, Fitzroy, 3065, VIC, Australia", 2.50f, 1.25f, 0.75f,
                "15/06/24", "Dr. I");

        assertEquals(false, result, "addPrescription should return false for invalid input");
    }

    @Test
    void validTypeClient_testcase1() {
        boolean result = prescription.addRemark("Client", "This is a valid remark for the prescription");

        assertEquals(true, result, "addRemark should return true for valid input");
    }

    @Test
    void validTypeClient_testcase2() {
        boolean result = prescription.addRemark("cc", "This is a valid remark for the prescription");

        assertEquals(false, result, "addRemark should return false for invalid input");
    }


}
