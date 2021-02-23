package com.jq.orange;

import lombok.Data;

import java.util.List;


@Data
public class SqlMeta {

    String sql;
    List<Object> jdbcParamValues;

    public SqlMeta(String sql, List<Object> jdbcParamValues) {
        this.sql = sql;
        this.jdbcParamValues = jdbcParamValues;
    }
}
