package Helikopter.Vmesnik;

import Helikopter.Entitete.Helikopter;
import Helikopter.Mapper.HelicopterRowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@Repository
public class HelikopterVmesnikImpl implements  HelikopterVmesnik {

    public HelikopterVmesnikImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    NamedParameterJdbcTemplate template;

    public List<Helikopter> helikopterList = new ArrayList<Helikopter>();

    @Override
    public List<Helikopter> findAll() {
        System.out.println("template: "+template);
        return template.query("select * from helikopter", new HelicopterRowMapper());
    }

    @Override
    public void dodajHelikopter(Helikopter helikopter) {
        final String sql = "insert into helikopter(id, sifra, imeHelikopterja , status) values(:id,:sifra,:imeHelikopterja,:status)";
        KeyHolder holder = new GeneratedKeyHolder();
        List<Helikopter> list = template.query("select * from helikopter", new HelicopterRowMapper());
        int id = list.size()+1;
        SqlParameterSource param = new MapSqlParameterSource()
                //.addValue("id", helikopter.getId())
                .addValue("id", id)
                .addValue("sifra", helikopter.getSifra())
                .addValue("imeHelikopterja", helikopter.getImeHelikopterja())
                .addValue("status", helikopter.getStatus());
        template.update(sql,param, holder);
    }

    @Override
    public void brisiHelikopter(int id) {
        final String sql = "delete from helikopter where id=:id";
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id", id);
        template.execute(sql,map,new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }
}