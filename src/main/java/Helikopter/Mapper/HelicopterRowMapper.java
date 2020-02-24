package Helikopter.Mapper;

import Helikopter.Entitete.Helikopter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HelicopterRowMapper  implements RowMapper<Helikopter> {
    @Override
    public Helikopter mapRow(ResultSet rs, int arg1) throws SQLException {
        Helikopter helikopter = new Helikopter();
        helikopter.setId(rs.getInt("id"));
        helikopter.setSifra(rs.getString("sifra"));
        helikopter.setImeHelikopterja(rs.getString("imeHelikopterja"));
        helikopter.setStatus(rs.getString("status"));
        return helikopter;
    }
}