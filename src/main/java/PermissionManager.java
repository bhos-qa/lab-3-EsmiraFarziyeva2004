public class PermissionManager {
    private PermissionLevel mCurrentLevel = PermissionLevel.USER;

    public String getRoleName(PermissionLevel level) {
        switch (level) {
            case ADMIN: return "Admin";
            case DEVELOPER: return "Developer";
            case USER: return "User";
            default: return "Unknown";
        }
    }

    public void setCurrentLevel(PermissionLevel level) {
        this.mCurrentLevel = level;
    }
}