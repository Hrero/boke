package com.eleven.boke.handle;

import com.eleven.boke.base.BaseEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * mybatis enum 转换
 *
 * @author zxw
 * @date 2020/8/25 6:00 下午
 */
public class BaseEnumTypeHandler extends BaseTypeHandler<BaseEnum> {

    private Class<BaseEnum> javaType;

    public BaseEnumTypeHandler(Class<BaseEnum> type) {
        this.javaType = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, BaseEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public BaseEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    @Override
    public BaseEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public BaseEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }

    /**
     * 通过code获取对应的枚举
     */
    public static <T extends BaseEnum> T getByCode(Integer code, Class<T> enumClass) {
        if (null == code || null == enumClass) {
            return null;
        }
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
