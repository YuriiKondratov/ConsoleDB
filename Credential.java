public class Credential {
    private String username;
    private String password;

    public Credential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean equals(Object o){
        if (!(o instanceof Credential other)) return false;
        return other.username.equals(this.username);
    }

    public String toString(){
        return "[username: " + username + ", password: " + password + "]";
    }
}
