package pl.emil7f;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderBackupExecutionOrderTest {

    @Test
    void callingBackupWithoutCreatingAFileFirstShouldThrowException() throws IOException {
        // given
        // when
        OrderBackup orderBackup = new OrderBackup();
        //then
        assertThrows(IOException.class, () -> orderBackup.backupOrder(new Order()));

    }
}
