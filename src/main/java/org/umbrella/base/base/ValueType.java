package org.umbrella.base.base;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.function.Function;

import org.drools.base.base.DroolsQuery;
import org.drools.base.factmodel.traits.Thing;
import org.drools.base.facttemplates.FactTemplate;
import org.kie.api.runtime.rule.EventHandle;
import org.umbrella.util.CoercionUtil;

public enum ValueType {

    NULL_TYPE("null", null, SimpleValueType.NULL),
    PCHAR_TYPE("character", Character.TYPE, SimpleValueType.CHAR, CoercionUtil::coerceToCharacter),
    PBYTE_TYPE("byte", Byte.TYPE, SimpleValueType.INTEGER),
    PSHORT_TYPE("short", Short.TYPE, SimpleValueType.INTEGER, CoercionUtil::coerceToShort),
    PINTEGER_TYPE("int", Integer.TYPE, SimpleValueType.INTEGER, CoercionUtil::coerceToInteger),
    PLONG_TYPE("long", Long.TYPE, SimpleValueType.INTEGER, CoercionUtil::coerceToLong),
    PFLOAT_TYPE("float", Float.TYPE, SimpleValueType.DECIMAL, CoercionUtil::coerceToFloat),
    PDOUBLE_TYPE("double", Double.TYPE, SimpleValueType.DECIMAL, CoercionUtil::coerceToDouble),
    PBOOLEAN_TYPE("boolean", Boolean.TYPE, SimpleValueType.BOOLEAN),

    // wrapper types
    CHAR_TYPE( "Character", Character.class, SimpleValueType.CHAR, CoercionUtil::coerceToCharacter ),
    BYTE_TYPE( "Byte", Byte.class, SimpleValueType.INTEGER ),
    SHORT_TYPE( "Short", Short.class, SimpleValueType.INTEGER, CoercionUtil::coerceToShort ),
    INTEGER_TYPE( "Integer", Integer.class, SimpleValueType.INTEGER, CoercionUtil::coerceToInteger ),
    LONG_TYPE( "Long", Long.class, SimpleValueType.INTEGER, CoercionUtil::coerceToLong ),
    FLOAT_TYPE( "Float", Float.class, SimpleValueType.DECIMAL, CoercionUtil::coerceToFloat ),
    DOUBLE_TYPE( "Double", Double.class, SimpleValueType.DECIMAL, CoercionUtil::coerceToDouble ),
    BOOLEAN_TYPE ( "Boolean", Boolean.class, SimpleValueType.BOOLEAN ),

    NUMBER_TYPE( "Number", Number.class, SimpleValueType.NUMBER ),
    BIG_DECIMAL_TYPE( "BigDecimal", BigDecimal.class, SimpleValueType.NUMBER, CoercionUtil::coerceToBigDecimal ),
    BIG_INTEGER_TYPE("BigInteger", BigInteger.class, SimpleValueType.NUMBER, CoercionUtil::coerceToBigInteger),
    
    // other types    
    DATE_TYPE( "Date", Date.class, SimpleValueType.DATE ),
    LOCAL_DATE_TYPE( "LocalDate", LocalDate.class, SimpleValueType.DATE ),
    LOCAL_TIME_TYPE( "LocalTime", LocalDateTime.class, SimpleValueType.DATE ),

    ARRAY_TYPE( "Array", Object[].class, SimpleValueType.LIST ),
    STRING_TYPE( "String", String.class, SimpleValueType.STRING, CoercionUtil::coerceToString ),
    OBJECT_TYPE( "Object", Object.class, SimpleValueType.OBJECT ),
    FACTTEMPLATE_TYPE( "FactTemplate", FactTemplate.class, SimpleValueType.UNKNOWN ),

    EVENT_TYPE("Event", EventHandle.class, SimpleValueType.OBJECT ),
    QUERY_TYPE("Query", DroolsQuery.class, SimpleValueType.OBJECT ),
    TRAIT_TYPE( "Trait", Thing.class, SimpleValueType.OBJECT ),
    CLASS_TYPE("Class", Class.class, SimpleValueType.OBJECT);
    ;
    
    private final String name;
    private final Class<?> classType;
    private final int simpleType;
    private final Function<Object, ?> coerceFunction;

    ValueType(String name, Class<?> classType, int simpleType) {
        this(name, classType, simpleType, Function.identity());
    }

    ValueType(String name, Class<?> classType, int simpleType, Function<Object, ?> coerceFunction) {
        this.name = name;
        this.classType = classType;
        this.simpleType = simpleType;
        this.coerceFunction = coerceFunction;
    }
    
}
