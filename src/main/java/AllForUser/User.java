package AllForUser;

public class UserReg {
    private final String email;
    private final String password;
    private final String name;

    public UserReg (String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public UserReg (String email, String password) {
        this.email = email;
        this.password = password;

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}

