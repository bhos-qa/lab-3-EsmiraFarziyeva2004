import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermissionManagerTest {
    private PermissionManager permissionManager;

    @BeforeEach
    void setUp() {
        permissionManager = new PermissionManager();
    }

    @Test
    void testGetRoleNameWithAdmin() {
        assertEquals("Admin", permissionManager.getRoleName(PermissionLevel.ADMIN));
    }

    @Test
    void testGetRoleNameWithDeveloper() {
        assertEquals("Developer", permissionManager.getRoleName(PermissionLevel.DEVELOPER));
    }

    @Test
    void testGetRoleNameWithUser() {
        assertEquals("User", permissionManager.getRoleName(PermissionLevel.USER));
    }

    @Test
    void testGetRoleNameWithNull() {
        assertEquals("Unknown", permissionManager.getRoleName(null));
    }

    @Test
    void testGetRoleNameWithUnknown() {
        assertEquals("Unknown", permissionManager.getRoleName(PermissionLevel.valueOf("UNKNOWN"))); // Assuming UNKNOWN is not defined
    }

    @Test
    void testSetCurrentLevel() {
        permissionManager.setCurrentLevel(PermissionLevel.ADMIN);
        assertEquals(PermissionLevel.ADMIN, permissionManager.getCurrentLevel());

        permissionManager.setCurrentLevel(PermissionLevel.DEVELOPER);
        assertEquals(PermissionLevel.DEVELOPER, permissionManager.getCurrentLevel());

        permissionManager.setCurrentLevel(PermissionLevel.USER);
        assertEquals(PermissionLevel.USER, permissionManager.getCurrentLevel());
    }

    @Test
    void testGetCurrentLevelInitially() {
        assertEquals(PermissionLevel.USER, permissionManager.getCurrentLevel());
    }
}
