package de.luzifer.asm.api.user;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UserRepository {
    
    private final Set<User> users = new HashSet<>();
    
    public Set<User> getUsers() {
        return users;
    }
    
    public User getOrCreateUser(UUID uuid) {
        
        for(User u : users)
            if(u.uuid.equals(uuid))
                return u;
        
        User user = new User(uuid);
        users.add(user);
        
        return user;
    }
    
    public void removeUser(UUID uuid) {
        users.remove(getOrCreateUser(uuid));
    }
    
}
