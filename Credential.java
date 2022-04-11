record Credential(String username, String password) {
    public boolean equals(Object o){
        if (!(o instanceof Credential other)) return false;
        return other.username.equals(this.username);
    }

    public String toString(){
        return "[username: " + username + ", password: " + password + "]";
    }
}
