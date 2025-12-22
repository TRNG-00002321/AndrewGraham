package tuesday;

public interface UserRepository {
    Optional<User> findById(Long id);
    User save(User user);
    void deleteById(Long id);
    List<User> findAllActive();
    boolean existsByEmail(String email);
    long count();
}
