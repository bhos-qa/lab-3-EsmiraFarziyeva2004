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

        manager.setCurrentLevel(PermissionLevel.ADMIN);
        assertEquals(PermissionLevel.ADMIN, manager.getCurrentLevel());

        manager.setCurrentLevel(PermissionLevel.DEVELOPER);
        assertEquals(PermissionLevel.DEVELOPER, manager.getCurrentLevel());
        
        
        manager.setCurrentLevel(PermissionLevel.USER);
        assertEquals(PermissionLevel.USER, manager.getCurrentLevel());
    }

    @Test
    public void testGetRoleNameWithInvalidLevel() {
        PermissionManager manager = new PermissionManager();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            manager.getRoleName(null);
        });

        assertEquals("Unknown PermissionLevel", exception.getMessage());
    }
}
