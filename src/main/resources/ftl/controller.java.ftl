package ${package.Controller};

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
* <p>
* ${table.comment!} 前端控制器
* </p>
*
* @author ${author}
* @since ${date}
*/
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
@Slf4j
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} implements ${entity}Feign{
</#if>

    @Autowired
    private I${entity}Service ${entity?uncap_first}Service;


    @Override
    public R save(${entity}DTO ${entity?uncap_first}Dto) {
    return ${entity?uncap_first}Service.insert${entity}(${entity?uncap_first}Dto);
    }

    @Override
    public R modify(${entity}DTO ${entity?uncap_first}Dto) {
    return ${entity?uncap_first}Service.modify${entity}(${entity?uncap_first}Dto);
    }

    @Override
    public R del(Long id) {
    return ${entity?uncap_first}Service.del${entity}ById(id);
    }

    @Override
    public R<${entity}DTO> selectById(Long id) {
        return ${entity?uncap_first}Service.select${entity}ById(id);
        }
}
</#if>