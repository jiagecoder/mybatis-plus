package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
@Slf4j
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {


    @Override
    public R insert${entity}(${entity}DTO ${entity?uncap_first}Dto) {
        return null;
    }

    @Override
    public R modify${entity}(${entity}DTO ${entity?uncap_first}Dto) {
        return null;
    }

    @Override
    public R del${entity}ById(Long id) {
        return null;
    }

    @Override
    public R<${entity}DTO> select${entity}ById(Long id) {
        return null;
    }


}