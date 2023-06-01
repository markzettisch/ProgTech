public interface Database_IF {
    public void Test();
    public int checkLogin(String username, String password);
    public String IDtoData(int ID);
    public boolean checkUsername(String username);
    public boolean addUser(String username, String full_name, String password);
}
