package s3657395_EyeClear;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrescriptionTest {
    Prescription prescription = new Prescription();

    @BeforeEach
    void setUp() {
        //Prescription prescription = new Prescription();
    }

    @Test
    void testFirstName_testcase1() {
        boolean result = prescription.addPrescription("Darcy", "Platt",
                "3 Mountfield Street, Brunswick, 3056, VIC, Australia", 2.50f,
                1.25f, 0.75f, "15/06/23", "Dr. Michelle Nadine");

        assertEquals(true, result, "addPrescription should return true for valid input");
    }
}
