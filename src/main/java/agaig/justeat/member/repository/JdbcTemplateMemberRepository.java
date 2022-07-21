//package agaig.justeat.repository;
//
//import agaig.justeat.member.domain.Member;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//public class JdbcTemplateMemberRepository implements MemberRepository{
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public JdbcTemplateMemberRepository(DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    @Override
//    public Long save(Member member) {
//        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
//        jdbcInsert.withTableName("members").usingGeneratedKeyColumns("member_id");
//
//        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("name", member.getName());
//
//        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
//        member.setMember_id(key.longValue());
//        return member.getMember_id();
//    }
//
//    @Override
//    public Member update(Member member) {
//        return null;
//    }
//
//    @Override
//    public Optional<Member> findById(Long id) {
//        List<Member> result = jdbcTemplate.query("select * from members where member_id = ?", memberRowMapper());
//        return result.stream().findAny();
//    }
//
//    @Override
//    public Optional<Member> findByEmail(String email) {
//        List<Member> result = jdbcTemplate.query("select * from members where email = 'pg@gmail.com'", memberRowMapper());
//        return result.stream().findAny();
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return jdbcTemplate.query("select * from members", memberRowMapper());
//    }
//
//    private RowMapper<Member> memberRowMapper() {
//        return (rs, rowNum) -> {
//            Member member = new Member();
//            member.setMember_id(rs.getLong("member_id"));
//            member.setEmail(rs.getString("email"));
//            member.setName(rs.getString("name"));
//            return member;
//        };
//    }
//}
