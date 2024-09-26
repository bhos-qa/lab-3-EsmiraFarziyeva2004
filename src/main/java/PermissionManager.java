
public class PermissionManager {
    private PermissionLevel mCurrentLevel = PermissionLevel.USER;
    public String getRoleName() {
        return mCurrentLevel.name();
    }
    public void setRoleName(PermissionLevel level) {
        mCurrentLevel = level;
    }
}
