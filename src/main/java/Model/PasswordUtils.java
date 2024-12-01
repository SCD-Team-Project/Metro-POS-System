
package Model;

import org.mindrot.jbcrypt.BCrypt;


public class PasswordUtils 
{
    static final String INITIAL_PASSWORD="password_123";
    
    public static String getInitialPassword()
    {
        return hashPassword(INITIAL_PASSWORD);
    }
    
    public static String hashPassword(String plainPassword)
    {
        return BCrypt.hashpw(plainPassword,BCrypt.gensalt());
    }
    
    public static boolean verifyPassword(String plainPassword,String hasedPassword)
    {
        return BCrypt.checkpw(plainPassword,hasedPassword);
    }
}