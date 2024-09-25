import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PermissionManagerTest {

    @Test
    public void testGetRoleName() {
        PermissionManager manager = new PermissionManager();
        assertEquals("Admin", manager.getRoleName(PermissionLevel.ADMIN));
        assertEquals("Developer", manager.getRoleName(PermissionLevel.DEVELOPER));
        assertEquals("User", manager.getRoleName(PermissionLevel.USER));
        assertEquals("Unknown", manager.getRoleName(null)); 
    }

    @Test
    public void testSetCurrentLevel() {
        PermissionManager manager = new PermissionManager();
        manager.setCurrentLevel(PermissionLevel.DEVELOPER);
        assertEquals("Developer", manager.getRoleName(manager.getCurrentLevel()));
        
        manager.setCurrentLevel(PermissionLevel.ADMIN);
        assertEquals("Admin", manager.getRoleName(manager.getCurrentLevel()));
        
        manager.setCurrentLevel(PermissionLevel.USER);
        assertEquals("User", manager.getRoleName(manager.getCurrentLevel()));
    }
}
