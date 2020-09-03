package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {


    /**
    * 保存${table.comment!}信息
    * @auther ${author}
    * @Date ${date}
    * @param ${entity?uncap_first}Dto
    * @return
    */
    R insert${entity}(${entity}DTO ${entity?uncap_first}Dto);

    /**
    * 修改${table.comment!}信息
    * @auther ${author}
    * @Date ${date}
    * @param ${entity?uncap_first}Dto
    * @return
    */
    R modify${entity}(${entity}DTO ${entity?uncap_first}Dto);

    /**
    * 删除${table.comment!}信息
    * @auther ${author}
    * @Date ${date}
    * @param id
    * @return
    */
    R del${entity}ById(Long id);

    /**
    * 根据id查询${table.comment!}信息
    * @auther ${author}
    * @Date ${date}
    * @param id
    */
    R<${entity}DTO> select${entity}ById(Long id);


}
</#if>