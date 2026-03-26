import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load users from JSON file
        List<UserDetails> users = loadUsersFromJson();
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    private List<UserDetails> loadUsersFromJson() {
        // Logic to read JSON file and return list of UserDetails
        try (FileReader reader = new FileReader("path_to_your_json_file.json")) {
            // Use your preferred library to parse JSON (like Jackson or Gson)
            // For example: return new Gson().fromJson(reader, new TypeToken<List<UserDetails>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
            return List.of(); // Return empty list on error
        }
    }
}