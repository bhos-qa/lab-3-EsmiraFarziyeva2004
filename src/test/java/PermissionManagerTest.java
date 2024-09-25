import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PermissionManagerTest {

    @Test
    public void testGetRoleName_Admin() {
        PermissionManager manager = new PermissionManager();
        assertEquals("Admin", manager.getRoleName(PermissionLevel.ADMIN));
    }

    @Test
    public void testGetRoleName_Developer() {
        PermissionManager manager = new PermissionManager();
        assertEquals("Developer", manager.getRoleName(PermissionLevel.DEVELOPER));
    }

    @Test
    public void testGetRoleName_User() {
        PermissionManager manager = new PermissionManager();
        assertEquals("User", manager.getRoleName(PermissionLevel.USER));
    }

    @Test
    public void testGetRoleName_Null() {
        PermissionManager manager = new PermissionManager();
        assertEquals("Unknown", manager.getRoleName(null));
    }

    @Test
    public void testGetRoleName_Unknown() {
        PermissionManager manager = new PermissionManager();
        // Use an invalid value (if you had other enum values)
        assertEquals("Unknown", manager.getRoleName(PermissionLevel.valueOf("SOME_UNKNOWN_ROLE")));
    }

    @Test
    public void testSetCurrentLevel() {
        PermissionManager manager = new PermissionManager();
        manager.setCurrentLevel(PermissionLevel.ADMIN);
        assertEquals(PermissionLevel.ADMIN, manager.getCurrentLevel());
        
        manager.setCurrentLevel(PermissionLevel.DEVELOPER);
        assertEquals(PermissionLevel.DEVELOPER, manager.getCurrentLevel());

        manager.setCurrentLevel(PermissionLevel.USER);
        assertEquals(PermissionLevel.USER, manager.getCurrentLevel());
    }

    @Test
    public void testGetCurrentLevel() {
        PermissionManager manager = new PermissionManager();
        assertEquals(PermissionLevel.USER, manager.getCurrentLevel());
        
        manager.setCurrentLevel(PermissionLevel.ADMIN);
        assertEquals(PermissionLevel.ADMIN, manager.getCurrentLevel());
    }
}
