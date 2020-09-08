package ${package.Entity};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
<#if entityLombokModel>
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
</#if>

/**
 * <p>
 * ${table.comment!}
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if entityLombokModel>
@Data
    <#if superEntityClass??>
@EqualsAndHashCode(callSuper = true)
    <#else>
@EqualsAndHashCode(callSuper = false)
    </#if>
@Accessors(chain = true)
</#if>
@ApiModel(value="${entity}Dto对象", description="${table.comment!}Dto")
public class ${entity}DTO implements Serializable {

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    /**
    * ${field.comment}
    */
    <#if  field.propertyName?contains("Id") >
    @JsonSerialize(using= ToStringSerializer.class)
    <#elseif field.propertyName?contains("id")>
    @JsonSerialize(using= ToStringSerializer.class)
    </#if>
    @ApiModelProperty(name = "${field.propertyName}",value = "${field.comment}")
    private ${field.propertyType} ${field.propertyName};

</#list>
<#------------  END 字段循环遍历  ---------->

}
