package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PermissionManagerTest {
    private PermissionManager permissionManager;

    @BeforeEach
    public void setUp() {
        permissionManager = new PermissionManager();
    }

    @Test
    public void testGetRoleNameWithAdmin() {
        assertEquals("Admin", permissionManager.getRoleName(PermissionLevel.ADMIN));
    }

    @Test
    public void testGetRoleNameWithDeveloper() {
        assertEquals("Developer", permissionManager.getRoleName(PermissionLevel.DEVELOPER));
    }

    @Test
    public void testGetRoleNameWithUser() {
        assertEquals("User", permissionManager.getRoleName(PermissionLevel.USER));
    }

    @Test
    public void testGetRoleNameWithNull() {
        assertEquals("Unknown", permissionManager.getRoleName(null));
    }

    @Test
    public void testGetRoleNameWithUnknownLevel() {
        assertEquals("Unknown", permissionManager.getRoleName(PermissionLevel.UNKNOWN));
    }

    @Test
    public void testSetCurrentLevel() {
        permissionManager.setCurrentLevel(PermissionLevel.ADMIN);
        assertEquals(PermissionLevel.ADMIN, permissionManager.getCurrentLevel());

        permissionManager.setCurrentLevel(PermissionLevel.DEVELOPER);
        assertEquals(PermissionLevel.DEVELOPER, permissionManager.getCurrentLevel());

        permissionManager.setCurrentLevel(PermissionLevel.USER);
        assertEquals(PermissionLevel.USER, permissionManager.getCurrentLevel());
    }

    @Test
    public void testGetCurrentLevelInitial() {
        assertEquals(PermissionLevel.USER, permissionManager.getCurrentLevel());
    }
}
