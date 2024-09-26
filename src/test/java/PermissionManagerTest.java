import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class PermissionManagerTest {
    @Test
    void testGetRoleName() {
        PermissionManager manager = new PermissionManager();

        assertEquals("USER", manager.getRoleName());
    }
    @Test
    void testSetCurrentLevel() {
        PermissionManager manager = new PermissionManager();
        manager.setRoleName(PermissionLevel.USER);
        assertEquals("USER", manager.getRoleName());
        manager.setRoleName(PermissionLevel.ADMIN);
        assertEquals("ADMIN", manager.getRoleName());
        manager.setRoleName(PermissionLevel.DEVELOPER);
        assertEquals("DEVELOPER", manager.getRoleName());
    }
}
