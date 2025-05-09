@Repository
public class CourseDAOImpl implements CourseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Course> getAllCourses() {
        String sql = "SELECT * FROM courses";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Course(
                rs.getInt("course_id"),
                rs.getString("name"),
                rs.getString("instructor"),
                rs.getInt("credits")
        ));
    }
}
