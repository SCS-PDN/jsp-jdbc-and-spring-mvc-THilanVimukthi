@Repository
public class RegistrationDAOImpl implements RegistrationDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void registerStudentInCourse(int studentId, int courseId, LocalDate date) {
        String sql = "INSERT INTO registrations (student_id, course_id, date) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, studentId, courseId, java.sql.Date.valueOf(date));
    }
}
