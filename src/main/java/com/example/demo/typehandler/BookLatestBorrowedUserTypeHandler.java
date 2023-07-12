package com.example.demo.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@MappedTypes(List.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class BookLatestBorrowedUserTypeHandler implements TypeHandler<List<Character>> {
    @Override
    public void setParameter(PreparedStatement ps, int i, List<Character> parameter, JdbcType jdbcType) throws SQLException {
        if (parameter != null) {
            StringBuilder sb = new StringBuilder();
            for (Character ch : parameter) {
                sb.append(ch);
            }
            ps.setString(i, sb.toString());
        } else {
            ps.setNull(i, jdbcType.TYPE_CODE);
        }
    }

    @Override
    public List<Character> getResult(ResultSet rs, String columnName) throws SQLException {
        String result = rs.getString(columnName);
        return stringToList(result);
    }

    @Override
    public List<Character> getResult(ResultSet rs, int columnIndex) throws SQLException {
        String result = rs.getString(columnIndex);
        return stringToList(result);
    }

    @Override
    public List<Character> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String result = cs.getString(columnIndex);
        return stringToList(result);
    }

    private List<Character> stringToList(String str) {
        List<Character> charList = new ArrayList<>();
        if (str != null) {
            for (char c : str.toCharArray()) {
                charList.add(c);
            }
        }
        return charList;
    }
}
