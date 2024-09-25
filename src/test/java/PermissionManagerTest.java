import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PermissionManagerTest {

    @Test
    public void testGetRoleName() {
        PermissionManager manager = new PermissionManager();
        assertEquals("Admin", manager.getRoleName(PermissionLevel.ADMIN));
        assertEquals("Developer", manager.getRoleName(PermissionLevel.DEVELOPER));
        assertEquals("User", manager.getRoleName(PermissionLevel.USER));
    }

    @Test
    public void testSetCurrentLevel() {
        PermissionManager manager = new PermissionManager();
        manager.setCurrentLevel(PermissionLevel.DEVELOPER);
        assertEquals("Developer", manager.getRoleName(PermissionLevel.DEVELOPER));
    }

    @Test
    public void testGetRoleNameUnknown() {
        PermissionManager manager = new PermissionManager();
        // Test with an unknown level by passing a non-existent value
        PermissionLevel unknownLevel = null; // Assuming null is not a defined PermissionLevel
        assertEquals("Unknown", manager.getRoleName(unknownLevel));
    }
}
